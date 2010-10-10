package org.odlabs.wiquery.examples.code;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.plugin.layout.Layout;

/**
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class CodeTabPanel extends Panel {

	private static final long serialVersionUID = 1L;
	
	private int active = 0;

	private List<SourceInfo> code;
	
	/**
	 * @param id
	 */
	public CodeTabPanel(String id, List<SourceInfo> code) {
		super(id);
	
		setOutputMarkupId(true);
		this.code = code;
			
	}
	
	@Override
	protected void onBeforeRender() {
		Layout layout = new Layout("layout", false) {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public Panel getLayoutWestComponent(String wicketId) {
				return new ListOfCodePanel(wicketId, code);
			}
			public Panel getLayoutCenterComponent(String wicketId) {
				return new CodeReaderPanel(wicketId, code.get(CodeTabPanel.this.getActive()));
			}
		};
		addOrReplace(layout);
		super.onBeforeRender();
	}
	
	public void setActiveFile(int active, AjaxRequestTarget target) {
		this.active = active;
		if(target != null) {
			target.addComponent(this);
		}
	}

	public int getActive() {
		return active;
	}
}
