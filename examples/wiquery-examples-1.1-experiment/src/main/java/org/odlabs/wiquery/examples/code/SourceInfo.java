package org.odlabs.wiquery.examples.code;

import java.io.Serializable;

/**
 * 
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class SourceInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static enum FORMAT {
		JAVA,
		HTML,
		XML,
		HTML_UNESCAPED,
	}
	
	private Class<?> context;
	
	public SourceInfo(Class<?> context) {
		this(context, FORMAT.JAVA, context.getSimpleName()+".java", context.getSimpleName()+".txt");
	}
	
	public SourceInfo(Class<?> context, FORMAT format, String displaName,
			String resourceName) {
		super();
		this.context = context;
		this.format = format;
		this.displaName = displaName;
		this.resourceName = resourceName;
	}

	private FORMAT format;
	private String displaName; 
	private String resourceName;
	
	

	public Class<?> getContext() {
		return context;
	}

	public void setContext(Class<?> context) {
		this.context = context;
	}

	public FORMAT getFormat() {
		return format;
	}

	public void setFormat(FORMAT format) {
		this.format = format;
	}

	public String getDisplaName() {
		return displaName;
	}

	public void setDisplaName(String displaName) {
		this.displaName = displaName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

}
