/**
 * 
 */
package org.odlabs.wiquery.examples.code;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

/**
 * @author  Ernesto Reinaldo Barreiro
 *
 */
public class ListOfCodePanel extends Panel {

	private static final long serialVersionUID = 1L;

	/**	
	 * @param id
	 */
	public ListOfCodePanel(String id, List<SourceInfo> code) {
		super(id);
		RepeatingView links = new RepeatingView("links");
		int index = 0;
		for(SourceInfo info: code) {
			WebMarkupContainer link = new FileLinkPanel(links.newChildId(), info.getDisplaName(), index);			
			links.add(link);		
			index++;
		}
		add(links);
	}
}
