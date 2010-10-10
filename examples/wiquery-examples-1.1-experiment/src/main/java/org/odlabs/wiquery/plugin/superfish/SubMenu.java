package org.odlabs.wiquery.plugin.superfish;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.plugin.menu.IMenu;
import org.odlabs.wiquery.plugin.menu.IMenuItem;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;

/**
 * A sub menu of the main Menu.
 * 
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
@WiQueryUIPlugin
public class SubMenu extends Panel implements IMenuItem, IMenu {

	List<IMenuItem> items = new ArrayList<IMenuItem>();


	private static final long serialVersionUID = 1L;	
	
	private RepeatingView itemsView;
	
	/**
	 * Constructor.
	 * 
	 * @param title
	 */
	public SubMenu(String title) {
		this(new Model<String>(title));
	}
	
	/**
	 * Constructor.
	 * 
	 * @param id
	 */
	public SubMenu(IModel<String> title) {
		super("item", title);				
		setRenderBodyOnly(true);		
		add(new Label("title", title).setRenderBodyOnly(true));		
	}
	
	@Override
	protected void onBeforeRender() {
		if(itemsView == null) {
			itemsView = new RepeatingView("items");
			add(itemsView);
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
	

	public String newChildId() {
		return itemsView.newChildId();
	}
	
	public IMenu addItem(IMenuItem item) {
		items.add(item);
		return this;
	}
	
	public IMenu removeItem(IMenuItem item) {
		items.remove(item);
		return this;
	}
	
	public boolean isOnTop() {
		return false;
	}	
}
