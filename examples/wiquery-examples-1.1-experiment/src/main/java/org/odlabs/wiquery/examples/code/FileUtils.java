package org.odlabs.wiquery.examples.code;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {
	
	static int BUFFER_SIZE = 10*1024;
	
	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
	
	/**
     * Attempts to list all the classes in the specified package as determined
     * by the context class loader...
     * 
     * @param pckgname
     *            the package name to search
     * @return a list of classes that exist within that package
     * @throws ClassNotFoundException
     *             if something went wrong
     */
    public static List<Class<?>> getClassesInSamePackage(Class<?>... classes) throws ClassNotFoundException {
    	ArrayList<Class<?>> result = new ArrayList<Class<?>>();
    	if(classes == null || classes.length == 0) 
    		return result;
        // This will hold a list of directories matching the pckgname. There may be more than one if 
    	// a package is split over multiple jars/paths        
    	ArrayList<File> directories = new ArrayList<File>();
        HashMap<File,String> packageNames = null; 
        String pckgname = null;
        try {        	
            ClassLoader cld = Thread.currentThread().getContextClassLoader();
            if (cld == null) {
                throw new ClassNotFoundException("Can't get class loader.");
            }
            for(Class<?> clazz: classes) {
            	// TODO: this would not work in a non OSGi environment
            	String syspath = getBundlePath(clazz);
            	if(syspath.indexOf("war!")>0 && (syspath.endsWith(".jar") || syspath.endsWith(".jar!/")) ) {
            		getClassesInSamePackageFromWar(result, classes, syspath);
            		continue;
            	} else if(syspath.endsWith(".jar") || syspath.endsWith(".jar!/")) {
	            	getClassesInSamePackageFromJar(result, classes, syspath);
	            	continue;
	            } else if(syspath.endsWith("/")) {
	            	syspath = syspath.substring(0, syspath.length()-1);
	            } 
	            pckgname = clazz.getPackage().getName();
	            String path = pckgname.replace('.', '/');
	            // Ask for all resources for the path
	            Enumeration<URL> resources = cld.getResources(path);
            	File directory = null;
	            while (resources.hasMoreElements()) {
	            	String path2 = resources.nextElement().getPath();	            	
	            	if (!path2.contains(syspath)) {
	            		// needed to get it working on Eclipse 3.5
	            		if(syspath.indexOf("/bin")<1) {
	            			syspath = syspath + "/bin";
		            	}
	            	    directory = new File(URLDecoder.decode(syspath+path2, "UTF-8"));
	            	} else
	            		directory = new File(URLDecoder.decode(path2, "UTF-8"));
	            	directories.add(directory);
	            }
	            if (packageNames == null)
	            	packageNames = new HashMap<File, String>();
	            packageNames.put(directory,pckgname);
            }
        } catch (NullPointerException x) {
            throw new ClassNotFoundException(pckgname + " does not appear to be a valid package (Null pointer exception)");
        } catch (UnsupportedEncodingException encex) {
            throw new ClassNotFoundException(pckgname + " does not appear to be a valid package (Unsupported encoding)");
        } catch (IOException ioex) {
        	logger.error("Erro scanning for classes", ioex);	
            throw new ClassNotFoundException("IOException was thrown when trying to get all resources for " + pckgname);
        }
         
        // For every directory identified capture all the .class files
        for (File directory : directories) {
            if (directory.exists()) {
                // Get the list of the files contained in the package
                String[] files = directory.list();
                for (String file : files) {
                	if(logger.isDebugEnabled())
                		logger.debug("Procesing " + file);
                	// we are only interested in .class files
                    if (file.endsWith(".class")) {
                    	try {
                    		// removes the .class extension
                    		result.add(Class.forName(packageNames.get(directory) + '.' + file.substring(0, file.length() - 6)));
                    	} catch (Throwable e) {
                    		// ignore exception and continue 
                    	}
                    }
                }
            } else {
                throw new ClassNotFoundException(pckgname + " (" + directory.getPath() + ") does not appear to be a valid package");
            }
        }
        return result;
    }
    
    /**
     * This method is necessary for newer versions of JBOSS (> 5.0), were wars are not exploded but 
     * deployed as WAR files.
     * 
     * @param result
     * @param classes
     * @param jarPath
     * @throws IOException
     */
    public static void getClassesInSamePackageFromWar(List<Class<?>> result, Class<?>[] classes, String jarPath)throws IOException {    	
    	String[] paths = jarPath.split("!");
    	String warPath  = paths[0];
    	String warJarPath  = paths[1].replace('\\', '/');    	
    	JarFile warFile = new JarFile(warPath.startsWith("file:")?new URL(warPath).getFile():warPath);    	
    	ZipEntry jarEntry = warFile.getEntry(warJarPath.substring(1));
		// we need to create a local copy temporal of the jar file 
    	// (out of the war file) in order to create a JarFile class.
    	File jarFile = File.createTempFile("tempjar", ".jar");
    	FileOutputStream out = new FileOutputStream(jarFile);
    	copy(warFile.getInputStream(jarEntry), out);
    	out.close();
    	// we scan the jar for classes.
    	getClassesInSamePackageFromJar(result, classes, new JarFile(jarFile));
    	// we try delete temporal file so that we do not leave 
    	// unused resource on the system
    	try {
    		jarFile.delete();    	
    	} catch (Exception e) {
    		if(logger.isDebugEnabled())
    			logger.debug("Could not delete temporal file: " + jarFile.getAbsolutePath());
		}
    }
    
    /**
     * Returns the list of classes in the same directories as Classes in <code>classes</code>.
     * 
     * @param result
     * @param classes
     * @param jarPath
     */
    private static void getClassesInSamePackageFromJar(List<Class<?>> result, Class<?>[] classes, String jarPath) throws IOException {
    	JarFile jarFile = null;    	
    	if(jarPath.endsWith("!/"))
    		jarPath = jarPath.substring(0, jarPath.indexOf("!/"));
    	if(jarPath.startsWith("file:/"))
    		jarPath = jarPath.substring(6);
    	try {
    		jarFile = new JarFile(jarPath);
    		getClassesInSamePackageFromJar(result, classes, jarFile);
    	} catch (IOException e) {
    		logger.error("Could not read jar file!", e);    		
    		result.addAll(Arrays.asList(classes));
    	} finally {
    		try {
    			if(jarFile != null)
    				jarFile.close();
    		} catch (Exception e) {			
			}
    	}
    }
    
    /**
     * Scans a jar file for classes in the same package as classes in array <code>classes</code>
     * 
     * @param result
     * @param classes
     * @param jarFile
     * @throws IOException
     */
    private static void getClassesInSamePackageFromJar(List<Class<?>> result, Class<?>[] classes, JarFile jarFile) throws IOException {
    	if(logger.isDebugEnabled()) 
    		logger.debug("Scanning Hibernate entities on jar file: " + jarFile.getName());
    	try {
    		//ClassLoader cld = Thread.currentThread().getContextClassLoader();
    		Enumeration<JarEntry> en = jarFile.entries();
    		while(en.hasMoreElements()) {
    			JarEntry entry = en.nextElement();
    			String entryName = entry.getName();    		
    			for(Class<?> clazz: classes) {    				
    				String packageName = clazz.getPackage().getName().replace('.', '/');    	                				
    				if(entryName != null && entryName.endsWith(".class") && entryName.startsWith(packageName)) {    					
    					try {
    						Class<?> entryClass = Class.forName(entryName.substring(0,entryName.length()-6).replace('/', '.'));
    						if(entryClass != null)
    							result.add(entryClass);    			
    					} catch (Throwable e) {
							// do nothing, just continue processing classes
						}
    				}
    			}    			
    		}
    	} finally {
    		try {
    			if(jarFile != null)
    				jarFile.close();
    		} catch (Exception e) {			
			}
    	}
    }
    
    /**
     * Returns the location of the 
     * 
     * @param clazz
     * @return
     */
    public static String getBundlePath(Class<?> clazz) {
    	ProtectionDomain pd = clazz.getProtectionDomain();
		if (pd == null)
			return null;
		CodeSource cs = pd.getCodeSource();
		if (cs == null)
			return null;
		URL url = cs.getLocation();
		if (url == null)
			return null;
		String result = url.getFile();
		return result;
    }
    
    /**
     * Copies one stream into the other..
	 * @param is	Stream fuente
	 * @param os	Stream destino*/
	static public void copy(InputStream is, OutputStream os) throws IOException {
		byte[] buf = new byte[BUFFER_SIZE];
		while (true) {
			int tam = is.read(buf);
			if (tam == -1) {
				return;
			}
			os.write(buf, 0, tam);
		}
	}
	
	public static  byte[] bytes(InputStream is) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		copy(is, out);
		return out.toByteArray();
	}

}
