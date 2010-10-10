/**
 * 
 */
package org.odlabs.wiquery.examples.code;

import java.io.IOException;
import java.io.InputStream;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.odlabs.wiquery.examples.code.SourceInfo.FORMAT;

import de.java2html.Java2Html;
import de.java2html.JavaSourceConversionSettings;


/**
 * @author  Ernesto Reinaldo Barreiro
 *
 */
public class CodeReaderPanel extends Panel {

	private static final long serialVersionUID = 1L;

	private SourceInfo sourceInfo;
	
	
	
	/**
	 * @param id
	 */
	public CodeReaderPanel(String id, SourceInfo sourceInfo) {
		super(id);
		this.sourceInfo = sourceInfo;
		Label title = new Label("title", sourceInfo.getDisplaName());
		add(title);
		Label code = new Label("code", new AbstractReadOnlyModel<String>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				try {
					String resourceName = CodeReaderPanel.this.sourceInfo.getResourceName();
					Class<?> context = CodeReaderPanel.this.sourceInfo.getContext();
					FORMAT format = CodeReaderPanel.this.sourceInfo.getFormat();
					JavaSourceConversionSettings settings = JavaSourceConversionSettings.getDefault();					
					settings.getConversionOptions().setShowLineNumbers(true);
					if(format.equals(FORMAT.JAVA) || format.equals(FORMAT.HTML)|| format.equals(FORMAT.XML)) {
						InputStream in = context.getResourceAsStream(resourceName);
						if(in != null)
							return Java2Html.convertToHtml(new String(FileUtils.bytes(in)),settings);
						return new StringBuffer().append("File ").append(resourceName).append(" not found!").toString();
					}
					return new String(FileUtils.bytes(context.getResourceAsStream(resourceName)));
				} catch (IOException e) {
					return e.toString();
				}
				
			}
		});	
		code.setEscapeModelStrings(false);
		code.setRenderBodyOnly(true);
		add(code);
	}
}
