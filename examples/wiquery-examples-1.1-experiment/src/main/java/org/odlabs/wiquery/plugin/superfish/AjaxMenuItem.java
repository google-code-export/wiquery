/**
 * 
 */
package org.odlabs.wiquery.plugin.superfish;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


/**
 * @author Ernesto Reinaldo Barreiro
 *
 */
public abstract class AjaxMenuItem extends AbstractMenuItem {

	private static final long serialVersionUID = 1L;

	/**
	 * @param title
	 */
	public AjaxMenuItem(String title) {
		this(new Model<String>(title));
	}
	
	/**
	 * @param title
	 */
	public AjaxMenuItem(IModel<String> title) {
		super(title);
	}

	@Override
	protected AbstractLink newLink(String id) {
		return new AjaxLink<Void>(id) {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				AjaxMenuItem.this.onClick(target);
			}
		};
	}

	public abstract void onClick(AjaxRequestTarget target);
}
