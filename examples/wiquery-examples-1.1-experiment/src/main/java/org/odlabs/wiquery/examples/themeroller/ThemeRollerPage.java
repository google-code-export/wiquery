package org.odlabs.wiquery.examples.themeroller;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.examples.AbstractExamplePage;
import org.odlabs.wiquery.examples.DemoSession;
import org.odlabs.wiquery.examples.WicketApplication;
import org.odlabs.wiquery.examples.themes.Themes;
import org.odlabs.wiquery.examples.themes.UITheme;
import org.odlabs.wiquery.ui.tabs.Tabs;

/**
 * ThemeRollerPage
 */
public class ThemeRollerPage extends AbstractExamplePage {

	private static final long serialVersionUID = 1L;
	
	// Wicket components
	private DropDownChoice<UITheme> themeSelect;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public ThemeRollerPage(final PageParameters parameters) {
		super("Theme Roller example");
		
		/*
		ArrayList<WiQueryCoreThemeResourceReference> themes = new ArrayList<WiQueryCoreThemeResourceReference>();
		themes.add(new WiQueryCoreThemeResourceReference("black-tie"));
		themes.add(new WiQueryCoreThemeResourceReference("blitzer"));
		themes.add(new WiQueryCoreThemeResourceReference("cupertino"));
		themes.add(new WiQueryCoreThemeResourceReference("dark-hive"));
		themes.add(new WiQueryCoreThemeResourceReference("dot-luv"));
		themes.add(new WiQueryCoreThemeResourceReference("eggplant"));
		themes.add(new WiQueryCoreThemeResourceReference("excite-bike"));
		themes.add(new WiQueryCoreThemeResourceReference("flick"));
		themes.add(new WiQueryCoreThemeResourceReference("fusion"));
		themes.add(new WiQueryCoreThemeResourceReference("hot-sneaks"));
		themes.add(new WiQueryCoreThemeResourceReference("humanity"));
		themes.add(new WiQueryCoreThemeResourceReference("le-frog"));
		themes.add(new WiQueryCoreThemeResourceReference("mint-choc"));
		themes.add(new WiQueryCoreThemeResourceReference("overcast"));
		themes.add(new WiQueryCoreThemeResourceReference("pepper-grinder"));
		themes.add(new WiQueryCoreThemeResourceReference("redmond"));
		themes.add(new WiQueryCoreThemeResourceReference("smoothness"));
		themes.add(new WiQueryCoreThemeResourceReference("south-street"));
		themes.add(new WiQueryCoreThemeResourceReference("start"));
		themes.add(new WiQueryCoreThemeResourceReference("sunny"));
		themes.add(new WiQueryCoreThemeResourceReference("swanky-purse"));
		themes.add(new WiQueryCoreThemeResourceReference("trontastic"));
		themes.add(new WiQueryCoreThemeResourceReference("ui-darkness"));
		themes.add(new WiQueryCoreThemeResourceReference("ui-lightness"));
		themes.add(new WiQueryCoreThemeResourceReference("vader"));
		*/
		
		themeSelect = new DropDownChoice<UITheme>(
				"themeSelect", 
				new Model<UITheme>() {
					
					private static final long serialVersionUID = 1L;

					@Override
					public UITheme getObject() {
						return DemoSession.getSession().getTheme();
					}
					
					@Override
					public void setObject(UITheme object) {
						DemoSession.getSession().setTheme(object);
					}
				},
				Themes.themes,
				new ChoiceRenderer<UITheme>("name"));
		themeSelect.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			private static final long serialVersionUID = 1L;

			/* (non-Javadoc)
			 * @see org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior#onUpdate(org.apache.wicket.ajax.AjaxRequestTarget)
			 */
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				WicketApplication.getApp().setTheme(themeSelect.getModelObject());
				setResponsePage(ThemeRollerPage.this);
			}
		});
		add(themeSelect);
		
		// wiQuery examples
		Tabs tabs = new Tabs("tabs");
		add(tabs);
	}
}
