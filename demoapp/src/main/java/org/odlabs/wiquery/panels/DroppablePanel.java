package org.odlabs.wiquery.panels;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.plugin.ChilliPanel;
import org.odlabs.wiquery.ui.draggable.DraggableBehavior;
import org.odlabs.wiquery.ui.droppable.DroppableAjaxBehavior;
import org.odlabs.wiquery.ui.droppable.DroppableBehavior;

/**
 * @author lionel
 */
public class DroppablePanel extends Panel {

	private static final long serialVersionUID = 1L;
	
	public DroppablePanel(String id) {
		super(id);
		ChilliPanel chilliPlugin = new ChilliPanel("examples");
		add(chilliPlugin);
		
		Label label = new Label("example1", "Drag me !");
		chilliPlugin.add(label);
		label.add(new DraggableBehavior());
		
		WebMarkupContainer dropzone = new WebMarkupContainer("dropzone");
		DroppableBehavior droppableBehavior = new DroppableBehavior();
		droppableBehavior.setOnDrop(JsScope.quickScope("alert('dropped');"));
		droppableBehavior.setAccept(".draggable");
		dropzone.add(droppableBehavior);
		chilliPlugin.add(dropzone);

		label = new Label("example2", "Drag me !");
		chilliPlugin.add(label);
		label.add(new DraggableBehavior());
		WebMarkupContainer ajaxDropzone = new WebMarkupContainer("ajaxDropzone");
		chilliPlugin.add(ajaxDropzone);
		DroppableAjaxBehavior ajaxDroppableBehavior = new DroppableAjaxBehavior() {
		
			private static final long serialVersionUID = 1L;
			
			@Override
			public void onDrop(Component component, AjaxRequestTarget target) {
				target.appendJavascript("alert('Ajax drop for id=" + component.getMarkupId() +"');");
			}
		
		};
		ajaxDroppableBehavior.setAccept(".draggable");
		ajaxDropzone.add(ajaxDroppableBehavior);
	}

}

