package org.odlabs.wiquery;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryAjaxEventBehavior;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.panels.CorePanel;
import org.odlabs.wiquery.panels.DraggablePanel;
import org.odlabs.wiquery.panels.DropablePanel;
import org.odlabs.wiquery.panels.EventsPanel;
import org.odlabs.wiquery.panels.StatementsPanel;
import org.odlabs.wiquery.ui.accordion.Accordion;
import org.odlabs.wiquery.ui.droppable.DroppableBehavior;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	private CorePanel currentPanel;
	
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
    	
		accordion.add(new AjaxFallbackLink<String>("statementsMenu", new Model("Core jQuery statements")) {
		
			@Override
			public void onClick(AjaxRequestTarget target) {
				StatementsPanel statementsPanel = new StatementsPanel("content");
				currentPanel.replaceWith(statementsPanel);
				target.addComponent(statementsPanel, currentPanel.getMarkupId());
			}
		
		});
		accordion.add(new AjaxFallbackLink<String>("eventsMenu", new Model("Events (Both Ajax and non Ajax)")) {
			
			@Override
			public void onClick(AjaxRequestTarget target) {
				EventsPanel eventsPanel = new EventsPanel("content");
				currentPanel.replaceWith(eventsPanel);
				target.addComponent(eventsPanel, currentPanel.getMarkupId());
			}
		
		});
		accordion.add(new AjaxFallbackLink<String>("draggableMenu", new Model("Draggable")) {
			
			@Override
			public void onClick(AjaxRequestTarget target) {
				DraggablePanel draggablePanel = new DraggablePanel("content");
				currentPanel.replaceWith(draggablePanel);
				target.addComponent(draggablePanel, currentPanel.getMarkupId());
			}
		
		});
		accordion.add(new AjaxFallbackLink<String>("droppableMenu", new Model("Droppable")) {
			
			@Override
			public void onClick(AjaxRequestTarget target) {
				DropablePanel dropablePanel = new DropablePanel("content");
				currentPanel.replaceWith(dropablePanel);
				target.addComponent(dropablePanel, currentPanel.getMarkupId());
			}
		
		});		
    }
}
