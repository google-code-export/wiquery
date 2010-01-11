package com.kodcu.web;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.kodcu.web.tablesorter.TablePage;

public class HomePage extends WebPage {

       private static final long serialVersionUID = 1L;     

        /**
         * Constructor that is invoked when page is invoked without a session.
         *
         * @param parameters
         *            Page parameters
         */
        public HomePage(final PageParameters parameters) {
                super();

                BookmarkablePageLink simpleFlot = new BookmarkablePageLink("SimpleFlot", FlotPage.class);
                add(simpleFlot);

                BookmarkablePageLink simpleFlotSeries = new BookmarkablePageLink("SimpleFlotSeries", FlotSeriesPage.class);
                add(simpleFlotSeries);

                BookmarkablePageLink advancedFlot = new BookmarkablePageLink("AdvancedFlot", AdvancedFlotPage.class);
                add(advancedFlot);

                BookmarkablePageLink flotOverview = new BookmarkablePageLink("FlotOverview", OverviewFlotPage.class);
                add(flotOverview);
                
                BookmarkablePageLink sortTable = new BookmarkablePageLink("SortTable", TablePage.class);
                add(sortTable);
                
        }
}