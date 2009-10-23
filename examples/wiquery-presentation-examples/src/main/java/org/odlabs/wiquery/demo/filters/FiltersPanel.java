package org.odlabs.wiquery.demo.filters;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.ui.themes.ThemeUiHelper;

public class FiltersPanel extends Panel {

	public FiltersPanel(String id) {
		super(id);
		Button button = new Button("filter-hide-todos");
		ThemeUiHelper.buttonRounded(button);
		add(button);
	}

}
