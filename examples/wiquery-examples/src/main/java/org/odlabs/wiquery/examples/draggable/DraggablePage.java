package org.odlabs.wiquery.examples.draggable;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.examples.AbstractExamplePage;
import org.odlabs.wiquery.ui.draggable.DraggableBehavior;
import org.odlabs.wiquery.ui.draggable.DraggableContainment;
import org.odlabs.wiquery.ui.draggable.DraggableRevert;

/**
 * DraggablePage
 */
public class DraggablePage extends AbstractExamplePage {

	private static final long serialVersionUID = 1L;
	
	// Wicket components
	private CheckBox revertPosition;
	private CheckBox containmentConstraint;
	private DraggableBehavior draggableBehavior;
	private WebMarkupContainer dragPanel;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public DraggablePage(final PageParameters parameters) {
		super("Draggable example");
		
		draggableBehavior = new DraggableBehavior();
		
		dragPanel = new WebMarkupContainer("dragPanel");
		dragPanel.add(draggableBehavior);
		add(dragPanel);
		
		// Options
		revertPosition = new CheckBox("revertPosition", new Model<Boolean>(false));
		revertPosition.setOutputMarkupPlaceholderTag(true);
		revertPosition.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			private static final long serialVersionUID = 1L;
			
			/* (non-Javadoc)
			 * @see org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior#onUpdate(org.apache.wicket.ajax.AjaxRequestTarget)
			 */
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				draggableBehavior.setRevert(new DraggableRevert(revertPosition.getModelObject()));				
				target.addComponent(dragPanel);
			}
		});
		add(revertPosition);
		
		containmentConstraint = new CheckBox("containmentConstraint", new Model<Boolean>(false));
		containmentConstraint.setOutputMarkupPlaceholderTag(true);
		containmentConstraint.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			private static final long serialVersionUID = 1L;
			
			/* (non-Javadoc)
			 * @see org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior#onUpdate(org.apache.wicket.ajax.AjaxRequestTarget)
			 */
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				if(containmentConstraint.getModelObject()){
					draggableBehavior.setContainment(new DraggableContainment("parent"));
				} else {
					draggableBehavior.setContainment(new DraggableContainment("window"));
				}
				
				target.addComponent(dragPanel);
			}
		});
		add(containmentConstraint);
	}
}
