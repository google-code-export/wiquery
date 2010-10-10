package org.odlabs.wiquery.examples;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebRequestCycle;
import org.odlabs.wiquery.examples.themes.Themes;
import org.odlabs.wiquery.examples.themes.UITheme;

/**
 * 
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
 *
 */
public class HeaderPanel extends Panel {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HeaderPanel(String id) {
    	super(id);
      	
    	Form<Void> form = new Form<Void>("form");
    	add(form);
    	
    	DropDownChoice<UITheme> theme = new DropDownChoice<UITheme>("theme", Themes.themes) {
    		
    		private static final long serialVersionUID = 1L;

			@Override
    		protected boolean wantOnSelectionChangedNotifications() {
    			return true;
    		}
    		
    		@Override
    		protected void onSelectionChanged(UITheme newSelection) {
    			WebRequestCycle.get().setResponsePage(getPage());
    		}
    	};    
    	theme.setModel(new Model<UITheme>() {
    		
    		private static final long serialVersionUID = 1L;

			@Override
    		public UITheme getObject() {
    			return DemoSession.getSession().getTheme();
    		}
			
			@Override
			public void setObject(UITheme object) {
				DemoSession.getSession().setTheme(object);
			}
    	});
    	theme.setNullValid(false);
    	form.add(theme);
    }
}
