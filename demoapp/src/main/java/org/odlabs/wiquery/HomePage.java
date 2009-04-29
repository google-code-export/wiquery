package org.odlabs.wiquery;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.panels.CorePanel;
import org.odlabs.wiquery.panels.DialogPanel;
import org.odlabs.wiquery.panels.DraggablePanel;
import org.odlabs.wiquery.panels.DropablePanel;
import org.odlabs.wiquery.panels.EventsPanel;
import org.odlabs.wiquery.panels.ResizablePanel;
import org.odlabs.wiquery.panels.StatementsPanel;
import org.odlabs.wiquery.panels.TabPanel;
import org.odlabs.wiquery.ui.accordion.Accordion;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	private Panel currentPanel;
	
    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {
    	// simple toggle script
    	JsQuery jsq = new JsQuery();
    	jsq.$(".source .toggle").chain("bind", "'click'", JsScope.quickScope("$(this).parent().toggleClass('visible')").render());
    	jsq.contribute(this);
    	
    	// left menu
    	Accordion accordion = new Accordion("leftMenu");
		add(accordion);
		// content
    	this.currentPanel = new CorePanel("content");
    	currentPanel.setOutputMarkupId(true);
		add(currentPanel);
    	
		accordion.add(new MenuItem("statementsMenu", new Model<String>("Core jQuery statements")) {

			@Override
			public Panel getContent() {
				return new StatementsPanel("content");
			}
			
		});
		accordion.add(new MenuItem("eventsMenu", new Model<String>("Events (Both Ajax and non Ajax)")) {

			@Override
			public Panel getContent() {
				return new EventsPanel("content");
			}
			
		});
		accordion.add(new MenuItem("draggableMenu", new Model<String>("Draggable")) {

			@Override
			public Panel getContent() {
				return new DraggablePanel("content");
			}
			
		});
		accordion.add(new MenuItem("droppableMenu", new Model<String>("Droppable")) {

			@Override
			public Panel getContent() {
				return new DropablePanel("content");
			}
			
		});
		accordion.add(new MenuItem("resizableMenu", new Model<String>("Resizable")) {

			@Override
			public Panel getContent() {
				return new ResizablePanel("content");
			}
			
		});
		accordion.add(new MenuItem("tabsMenu", new Model<String>("Tabs")) {

			@Override
			public Panel getContent() {
				return new TabPanel("content");
			}
			
		});
		accordion.add(new MenuItem("dialogMenu", new Model<String>("Dialog")) {

			@Override
			public Panel getContent() {
				return new DialogPanel("content");
			}
			
		});
    }
    
    private abstract class MenuItem extends AjaxFallbackLink<String> {
    	
		public MenuItem(String id, IModel<String> model) {
			super(id, model);
		}
    	
		@Override
		public void onClick(AjaxRequestTarget target) {
			Panel panel = this.getContent();
			currentPanel.replaceWith(panel);
			currentPanel = panel;
			target.addComponent(panel, currentPanel.getMarkupId());
		}
		
		public abstract Panel getContent();
    	
    }
}
