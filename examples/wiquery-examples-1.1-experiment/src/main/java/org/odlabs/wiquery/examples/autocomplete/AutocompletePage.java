package org.odlabs.wiquery.examples.autocomplete;

import org.apache.wicket.PageParameters;
import org.odlabs.wiquery.core.options.ArrayItemOptions;
import org.odlabs.wiquery.core.options.LiteralOption;
import org.odlabs.wiquery.examples.AbstractExamplePage;
import org.odlabs.wiquery.ui.autocomplete.Autocomplete;
import org.odlabs.wiquery.ui.autocomplete.AutocompleteSource;

/**
 * AutocompletePage
 */
public class AutocompletePage extends AbstractExamplePage {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public AutocompletePage(final PageParameters parameters) {
		super("Autocomplete example");
		
		ArrayItemOptions<LiteralOption> array = new ArrayItemOptions<LiteralOption>();
		array.add(new LiteralOption("c++"));
		array.add(new LiteralOption("java"));
		array.add(new LiteralOption("php"));
		array.add(new LiteralOption("coldfusion"));
		array.add(new LiteralOption("javascript"));
		array.add(new LiteralOption("asp"));
		array.add(new LiteralOption("ruby"));
		array.add(new LiteralOption("python"));
		array.add(new LiteralOption("c"));
		array.add(new LiteralOption("scala"));
		array.add(new LiteralOption("groovy"));
		array.add(new LiteralOption("haskell"));
		array.add(new LiteralOption("perl"));
		
		Autocomplete<String> autocomplete = new Autocomplete<String>("autocomplete");
		autocomplete.setSource(new AutocompleteSource(array));
		add(autocomplete);
	}
}
