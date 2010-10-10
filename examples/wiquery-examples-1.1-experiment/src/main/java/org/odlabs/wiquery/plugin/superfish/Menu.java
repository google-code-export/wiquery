package org.odlabs.wiquery.plugin.superfish;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.odlabs.wiquery.core.commons.CoreJavaScriptResourceReference;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.Options;
import org.odlabs.wiquery.plugin.menu.IMenu;
import org.odlabs.wiquery.plugin.menu.IMenuItem;
import org.odlabs.wiquery.plugin.superfish.js.HoverIntentJavaScriptResourceReference;
import org.odlabs.wiquery.plugin.superfish.js.SuperfishJavaScriptResourceReference;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;

/**
 * This component is based on this Menu
 * 
 * http://www.dynamicdrive.com/style/csslibrary/item/jquery_multi_level_css_menu_2/
 * 
 *
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
@WiQueryUIPlugin
public class Menu extends Panel implements IMenu, IWiQueryPlugin {

	List<IMenuItem> items = new ArrayList<IMenuItem>();
	
	
	protected static final ResourceReference CSS = new ResourceReference(Menu.class, "css/superfish.css");	
	protected static final ResourceReference NAVIGATIONBAR_CSS = new ResourceReference(Menu.class, "css/superfish-navbar.css");
	protected static final ResourceReference VERTICAL_CSS = new ResourceReference(Menu.class, "css/superfish-vertical.css");
	
	
	private static final long serialVersionUID = 1L;

	private WebMarkupContainer menu;
	
	public static enum Speed {
		SLOW, NORMAL, FAST;
		
		/**
		 * @return a non null String containing the effect speed value.
		 */
		public String getJavaScriptStatement() {
			return this.name().toLowerCase();
		}
	}
	
	/**
	 * The options.
	 */
	private Options options;
	
	private RepeatingView itemsView;
	
	/**
	 * Constructor.
	 * 
	 * @param id
	 */
	public Menu(String id) {
		super(id);
		
		options = new Options();
		
		setRenderBodyOnly(true);
		
		menu = new WebMarkupContainer("menu");				
		menu.setOutputMarkupId(true);
		
		add(menu);		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#contribute(org.odlabs.wiquery.core.commons.WiQueryResourceManager)
	 */
	public void contribute(WiQueryResourceManager wiQueryResourceManager) {
		wiQueryResourceManager.addJavaScriptResource(CoreJavaScriptResourceReference.get());
		// if HoverIntent scanning is disable then we do not include the JavaScript either. 		
		if(!isDisableHI())
			wiQueryResourceManager.addJavaScriptResource(HoverIntentJavaScriptResourceReference.get());
		wiQueryResourceManager.addJavaScriptResource(SuperfishJavaScriptResourceReference.get());
		wiQueryResourceManager.addCssResource(newMenuCss());
	}
	
	@Override
	protected void onBeforeRender() {
		if(itemsView == null) {
			itemsView = new RepeatingView("items");
			menu.add(itemsView);
			for(IMenuItem item: items) {
				if(item instanceof Component) {
					WebMarkupContainer child = new WebMarkupContainer(itemsView.newChildId());
					itemsView.add(child);
					child.add((Component)item);
				}				
			}
		}
		super.onBeforeRender();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#statement()
	 */
	public JsStatement statement() {
		return new JsQuery(menu).$().chain("superfish", options.getJavaScriptOptions());
	}
	
	/**
	 *  Flag to enable/disable drop shadows 
	 * 
	 * @param dropShadows
	 *            true to drop shadow, false otherwise. Use null 
	 *            to un-set it and use default value.
	 * @return instance of the current component
	 */
	public Menu setDropShadows(Boolean dropShadows) {
		if(dropShadows == null) {
			options.removeOption("dropShadows");
		} else {
			options.put("dropShadows", dropShadows);
		}
		
		return this;
	}
	
	/**
	 *  If set to true, arrow mark-up generated automatically = cleaner source 
	 *  code at expense of initialization performance  
	 * 
	 * @param autoArrows
	 *            true to auto-generate arrows, false otherwise.
	 *            Use null to un-set it and use default value.
	 * @return instance of the current component
	 */
	public Menu setAutoArrows(Boolean autoArrows) {
		if(autoArrows == null) {
			options.removeOption("autoArrows");
		} else {			
			options.put("autoArrows", autoArrows);
		}
		return this;
	}
	
	/**
	 * Sets the animation e.g. animation: {opacity:'show'}
	 * 
	 * @param animation
	 * @return
	 */
	public Menu setAnimation(String animation) {
		if(animation == null) {
			options.removeOption("animation");
		} else {			
			options.put("animation", animation);
		}
		return this;
	}
	
	
	
	/**
	 * Set to true to disable hoverIntent detection
	 * 
	 * @param disableHI Set to true to disable hoverIntent detection.
	 * @return instance of the current component
	 */
	public Menu setDisableHI(Boolean disableHI) {
		if(disableHI == null) {
			options.removeOption("disableHI");
		} else {			
			options.put("disableHI", disableHI);
		}
		return this;
	}
	
	/**
	 * Sets speed of the animation. Equivalent to second parameter of jQuery’s .animate() method
	 * @param speed
	 * @return
	 */
	public Menu setSpeed(Speed speed) {
		if(speed == null) {
			options.removeOption("speed");
		} else {			
			options.putLiteral("speed", speed.getJavaScriptStatement());
		}
		return this;
	}
	
	
	/**
	 * @return Gets the disableHI option.
	 */
	public boolean  isDisableHI() {
		try {
			Boolean disableHI = options.getBoolean("disableHI");
			return (disableHI != null)?disableHI.booleanValue(): false;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * The delay in milliseconds that the mouse can remain outside a sub-menu without it closing.
	 * 
	 * @param delay The delay in milliseconds. Use null to un-set it and use default value.
	 * @return instance of the current component.
	 */
	public Menu setDelay(Integer delay) {
		if(delay == null){
			options.removeOption("delay");
		} else {
			options.put("delay", delay);
		}
		return this;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	protected ResourceReference newMenuCss() {
		return CSS;
	}
	
	
	public IMenu addItem(IMenuItem item) {
		items.add(item);
		return this;
	}
	
	public IMenu removeItem(IMenuItem item) {
		items.add(item);
		return this;
	}
	
	public boolean isOnTop() {
		return true;
	}
	
}
