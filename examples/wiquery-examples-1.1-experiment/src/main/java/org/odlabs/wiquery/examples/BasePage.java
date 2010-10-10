package org.odlabs.wiquery.examples;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.examples.code.SourceInfo;
import org.odlabs.wiquery.examples.code.SourceInfo.FORMAT;
import org.odlabs.wiquery.plugin.layout.Layout;
import org.odlabs.wiquery.plugin.layout.Layout.PanePositionEnum;

/**
 * Base page.
 */
public abstract class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public BasePage() {
    	//add(CSSPackageResource.getHeaderContribution(DefaultStyle.CSS_MAIN));
    	//add(CSSPackageResource.getHeaderContribution(Styles.CSS_MAIN));
    	Layout layout = new Layout("layout", true) {
        	
        	private static final long serialVersionUID = 1L;

       
        	
        	@Override
        	public Panel getLayoutNorthComponent(String wicketId) {
        		return new HeaderPanel(wicketId);
        	}
        	
        	@Override
        	public Panel getLayoutCenterComponent(final String wicketId) {
        		return new IndicatorPanel(wicketId, creaAyuda()) {
        			
        			private static final long serialVersionUID = 1L;

					@Override
        			protected Component newContents(String id) {
        				return BasePage.this.getLayoutCenterComponent(id);
        			}
        		};        		
        	}
        	
        };
        add(layout);
        layout.setResizable(PanePositionEnum.NORTH, false)
        .setClosable(PanePositionEnum.NORTH, false)
        .setSpacingOpen(PanePositionEnum.NORTH, 0)
        .setMinSize(PanePositionEnum.NORTH, 80)
        .setMaxSize(PanePositionEnum.NORTH, 82);
        
    }
    
    /**
	 * En este metodo se crea la venatana emergente que contine las explicaciones
	 * del ccodigo.
	 */
	private  List<SourceInfo> creaAyuda() {
		List<SourceInfo> codeInfos = new ArrayList<SourceInfo>();
		addThisSourceCode(codeInfos);
		addSourceCode(codeInfos);		
		return codeInfos;
	}
	
	/**
	 * Use this method to add INFO pages. 
	 * 
	 * @param codeInfos
	 */
	private void addThisSourceCode(List<SourceInfo> codeInfos) {
		codeInfos.add(new SourceInfo(BasePage.class));
		codeInfos.add(new SourceInfo(BasePage.class, FORMAT.HTML, "BasePage.html", "BasePage.html"));
	}
	
	/**
	 * Use this method to add INFO pages. 
	 * 
	 * @param codeInfos
	 */
	protected void addSourceCode(List<SourceInfo> codeInfos) {
	
	}
	
    protected abstract Panel getLayoutCenterComponent(String wicketId);
}
