package org.odlabs.wiquery.demo.filters;

import org.apache.wicket.Application;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.WicketApplication;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryAjaxEventBehavior;
import org.odlabs.wiquery.demo.dashboard.DashBoard;
import org.odlabs.wiquery.ui.themes.ThemeUiHelper;
import org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference;

public class FiltersPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public FiltersPanel(String id) {
		super(id);
//		WiQueryCoreHeaderContributor.setTheme(new WiQueryCoreThemeResourceReference("mintchoc"));
		Label title = new Label("filters-title", Model.of("Filters"));
		ThemeUiHelper.headerComponent(title);
		add(title);
		
		Button toggleTodos = new Button("filter-toggle-todos");
		add(toggleTodos);
		ThemeUiHelper.buttonRounded(toggleTodos);

		Button toggleProgress = new Button("filter-toggle-progress");
		ThemeUiHelper.buttonRounded(toggleProgress);
		add(toggleProgress);

		Button toggleDone = new Button("filter-toggle-done");
		ThemeUiHelper.buttonRounded(toggleDone);
		add(toggleDone);

		toggleTodos.add(new ToggleCategoryBehavior(this, "todos"));
		toggleProgress.add(new ToggleCategoryBehavior(this, "progress"));
		toggleDone.add(new ToggleCategoryBehavior(this, "done"));
		
		Label options = new Label("options-title", Model.of("Options"));
		ThemeUiHelper.headerComponent(options);
		add(options);
		
		Button themeDefault = new Button("filter-theme-default");
		themeDefault.add(new WiQueryAjaxEventBehavior(MouseEvent.CLICK) {

			@Override
			protected void onEvent(AjaxRequestTarget target) {
				WicketApplication wicketApplication = (WicketApplication) Application.get();
				wicketApplication.setTheme(new WiQueryCoreThemeResourceReference("fusion"));
				setResponsePage(DashBoard.class);
			}
			
		});
		ThemeUiHelper.buttonRounded(themeDefault);
		add(themeDefault);
		
		Button themeMintchoc = new Button("filter-theme-mintchoc");
		themeMintchoc.add(new WiQueryAjaxEventBehavior(MouseEvent.CLICK) {

			@Override
			protected void onEvent(AjaxRequestTarget target) {
				WicketApplication wicketApplication = (WicketApplication) Application.get();
				wicketApplication.setTheme(new WiQueryCoreThemeResourceReference("mintchoc"));
				setResponsePage(DashBoard.class);
			}
			
		});
		ThemeUiHelper.buttonRounded(themeMintchoc);
		add(themeMintchoc);		
		
	}

}
