package org.odlabs.wiquery.demo.filters;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.ui.behavior.IconBehavior;
import org.odlabs.wiquery.ui.themes.ThemeUiHelper;

public class FiltersPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public FiltersPanel(String id) {
		super(id);
		Label title = new Label("filters-title", Model.of("Filters"));
		ThemeUiHelper.headerComponent(title);
		add(title);
		
		Button toggleTodos = new Button("filter-toggle-todos");
		add(toggleTodos);
		ThemeUiHelper.buttonRounded(toggleTodos);
		toggleTodos.add(new IconBehavior());

		Button toggleProgress = new Button("filter-toggle-progress");
		ThemeUiHelper.buttonRounded(toggleProgress);
		add(toggleProgress);

		Button toggleDone = new Button("filter-toggle-done");
		ThemeUiHelper.buttonRounded(toggleDone);
		add(toggleDone);

		toggleTodos.add(new ToggleCategoryBehavior(this, "todos"));
		toggleProgress.add(new ToggleCategoryBehavior(this, "progress"));
		toggleDone.add(new ToggleCategoryBehavior(this, "done"));
	}

}
