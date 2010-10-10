package org.odlabs.wiquery.examples.code;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 */
public class FileLinkPanel extends Panel {
	private static final long serialVersionUID = 1L;

	private int index;
	
	/**
	 * @param id
	 */
	public FileLinkPanel(String id, String name, int index) {
		super(id);
		this.index = index;
		AjaxLink<Void> ajaxLink = new AjaxLink<Void>("sourceFile") {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				CodeTabPanel codeTabPanel = findParent(CodeTabPanel.class);
				codeTabPanel.setActiveFile(FileLinkPanel.this.getIndex(), target);
			}
		};
		add(ajaxLink);
		ajaxLink.add(new Label("label", name));
	}
	
	public int getIndex() {
		return index;
	}

}
