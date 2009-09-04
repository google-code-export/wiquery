package org.odlabs.wiquery.examples;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class AbstractExamplePage extends WebPage {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param title
	 *            Title of the example page
	 */
	public AbstractExamplePage(String title) {
		super();
		
		add(new Label("exampleTitle", title));
		add(new BookmarkablePageLink<HomePage>("mainPageLink", HomePage.class));
	}
}
