package org.odlabs.wiquery.examples.position;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.odlabs.wiquery.examples.AbstractExamplePage;
import org.odlabs.wiquery.ui.position.PositionBehavior;
import org.odlabs.wiquery.ui.position.PositionOffset;
import org.odlabs.wiquery.ui.position.PositionBehavior.Collision;
import org.odlabs.wiquery.ui.position.PositionBehavior.Position;

/**
 * PositionPage
 */
public class PositionPage extends AbstractExamplePage {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public PositionPage(final PageParameters parameters) {
		super("Position example");
		
		WebMarkupContainer position1 = new WebMarkupContainer("position1");
		position1.setMarkupId(position1.getId());
		add(position1);
		
		WebMarkupContainer position2 = new WebMarkupContainer("position2");
		position2.setMarkupId(position2.getId());
		add(position2);
		
		WebMarkupContainer position3 = new WebMarkupContainer("position3");
		position3.setMarkupId(position3.getId());
		add(position3);
		
		WebMarkupContainer position4 = new WebMarkupContainer("position4");
		position4.setMarkupId(position4.getId());
		add(position4);
		
		position1.add(new PositionBehavior()
			.setMy(Position.CENTER)
			.setAt(Position.CENTER)
			.setOf("#targetElement"));
		
		position2.add(new PositionBehavior()
			.setMy(Position.LEFT_TOP)
			.setAt(Position.LEFT_TOP)
			.setOf("#targetElement"));
		
		position3.add(new PositionBehavior()
			.setMy(Position.RIGHT_BOTTOM)
			.setOffset(new PositionOffset(3, -3))
			.setCollision(Collision.FIT));
		
		position4.add(new PositionBehavior()
			.setMy(Position.LEFT_BOTTOM)
			.setOffset(new PositionOffset(3, -3))
			.setCollision(Collision.FIT));
	}
}
