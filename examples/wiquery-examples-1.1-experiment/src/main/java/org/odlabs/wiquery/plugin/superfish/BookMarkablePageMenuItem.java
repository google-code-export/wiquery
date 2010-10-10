/**
 * 
 */
package org.odlabs.wiquery.plugin.superfish;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


/**
 * An AJAX submiting versions of Menu item.
 * 
 * @author Ernesto Reinaldo Barreiro
 *
 */
public abstract class BookMarkablePageMenuItem<C extends Page> extends AbstractMenuItem {

	private static final long serialVersionUID = 1L;

	/**
	 * @param title
	 */
	public BookMarkablePageMenuItem(String title) {
		this(new Model<String>(title));
	}
	
	/**
	 * @param title
	 */
	public BookMarkablePageMenuItem(IModel<String> title) {
		super(title);
	}

	@Override
	protected AbstractLink newLink(String id) {
		return new BookmarkablePageLink<C>(id, getPageClass());
	}

	/**
	 * 
	 * @param target
	 */
	protected abstract Class<C> getPageClass();
}
