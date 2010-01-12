package com.kodcu.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.target.coding.QueryStringUrlCodingStrategy;
import org.odlabs.wiquery.utils.WiQueryWebApplication;

import com.kodcu.web.tablesorter.TablePage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see org.odlabs.Start#main(String[])
 */
public class WicketApplication extends WiQueryWebApplication {

    @Override
    protected void init() {
        super.init();

        this.mountBookmarkablePageWithUrlCoding("/flot", FlotPage.class);
        this.mountBookmarkablePageWithUrlCoding("/flotserie", FlotSeriesPage.class);

        this.mountBookmarkablePageWithUrlCoding("/advflot", AdvancedFlotPage.class);
        this.mountBookmarkablePageWithUrlCoding("/overflot", OverviewFlotPage.class);
        
        this.mountBookmarkablePageWithUrlCoding("/table", TablePage.class);
    }

    /**
     * Constructor
     */
    public WicketApplication() {
    }

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    private void mountBookmarkablePageWithUrlCoding(String path,
            Class pageClass) {
        mount(new QueryStringUrlCodingStrategy(path, pageClass));
    }
}
