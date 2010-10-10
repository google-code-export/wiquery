/**
 * 
 */
package org.odlabs.wiquery.plugin.superfish;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


/**
 * An AJAX submiting versions of Menu item.
 * 
 * @author Ernesto Reinaldo Barreiro
 *
 */
public abstract class AjaxSubmitMenuItem extends AbstractMenuItem {

	private static final long serialVersionUID = 1L;

	/**
	 * @param title
	 */
	public AjaxSubmitMenuItem(String title) {
		this(new Model<String>(title));
	}
	
	/**
	 * @param title
	 */
	public AjaxSubmitMenuItem(IModel<String> title) {
		super(title);
	}

	@Override
	protected AbstractLink newLink(String id) {
		return new AjaxSubmitLink(id) {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				AjaxSubmitMenuItem.this.onSubmit(target, form);
			}
			
		
		};
	}

	/**
	 * 
	 * @param target
	 */
	protected abstract void onSubmit(AjaxRequestTarget target, Form<?> form);
}
