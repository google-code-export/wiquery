package com.kodcu.web.tablesorter;

import org.apache.wicket.markup.html.WebMarkupContainer;

public class TablePage extends ParentPage { 

	

	public TablePage() {
		
		WebMarkupContainer wc = new WebMarkupContainer("left");
		ThePanel thePanel = new ThePanel("thePanel");
		wc.add(thePanel);
		add(wc);
	}

}
