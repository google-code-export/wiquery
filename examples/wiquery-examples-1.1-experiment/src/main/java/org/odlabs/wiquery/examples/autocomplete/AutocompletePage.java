package org.odlabs.wiquery.examples.autocomplete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;
import org.odlabs.wiquery.core.options.ArrayItemOptions;
import org.odlabs.wiquery.core.options.LiteralOption;
import org.odlabs.wiquery.examples.AbstractExamplePage;
import org.odlabs.wiquery.ui.autocomplete.Autocomplete;
import org.odlabs.wiquery.ui.autocomplete.AutocompleteAjaxComponent;
import org.odlabs.wiquery.ui.autocomplete.AutocompleteComponent;
import org.odlabs.wiquery.ui.autocomplete.AutocompleteSource;

/**
 * AutocompletePage
 */
public class AutocompletePage extends AbstractExamplePage {

	/**
	 * Bean for a user
	 * @author Julien Roche
	 *
	 */
	public class UserBean implements Serializable {
		// Constants
		/**	Constant of serialization */
		private static final long serialVersionUID = 5835935588925589134L;
		
		// Properties
		private String name;
		private Integer age;
		
		public UserBean(String name, Integer age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof UserBean){
				return ((UserBean) obj).getName().equalsIgnoreCase(this.name);
			}
			
			return false;
		}


		public Integer getAge() {
			return age;
		}
		
		public String getName() {
			return name;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public void setName(String name) {
			this.name = name;
		}

		/**
		 * {@inheritDoc}
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return this.name;
		}
	}

	// Constantes
	/** Constant of serialization */
	private static final long serialVersionUID = 1L;
	
	/** Collection of languages */
	private static final List<String> languages = new ArrayList<String>(
				Arrays.asList(
						"asp", "c", "c++", "coldfusion", "groovy", "haskell", "java", 
						"javascript", "perl", "php", "python", "ruby", "scala")
			);
	
	// Wicket components
	private AutocompleteComponent<UserBean> autocompleteComponent;
	private AutocompleteAjaxComponent<String> autocompleteAjaxComponent;
	
	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public AutocompletePage(final PageParameters parameters) {
		super("Autocomplete example");
		
		// Autocomplete
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
		
		// AutocompleteComponent
		Form<UserBean> form = new Form<UserBean>("form");
		add(form);
		form.add(new FeedbackPanel("feedback"));
		form.add(new SubmitLink("submit"){
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.apache.wicket.markup.html.form.SubmitLink#onSubmit()
			 */
			@Override
			public void onSubmit() {
				UserBean userBean = autocompleteComponent.getModelObject();
				
				if(userBean == null){
					info("No user was specified");
					
				} else {
					info("The user '" 
							+ userBean.getName() 
							+ "' is "
							+ userBean.getAge()
							+ " years old");
				}
			}
		});
		
		autocompleteComponent = new AutocompleteComponent<UserBean>(
				"autocompleteComponent", 
				new Model<UserBean>(new UserBean("patrick", 33)), 
				Model.ofList(Arrays.asList(
						new UserBean("bob", 5),
						new UserBean("thomas", 8),
						new UserBean("teddy", 17),
						new UserBean("patrick", 33),
						new UserBean("kevin", 56),
						new UserBean("john", 19),
						new UserBean("chris", 77)))){
							private static final long serialVersionUID = 1L;

							/**
							 * {@inheritDoc}
							 * @see org.odlabs.wiquery.ui.autocomplete.AutocompleteComponent#getValueOnSearchFail(java.lang.String)
							 */
							@Override
							public UserBean getValueOnSearchFail(String input) {
								return Strings.isEmpty(input) ? null : new UserBean(input, 42);
							}
		};
		form.add(autocompleteComponent);
		
		// AutocompleteAjaxComponent
		Form<String> formAjax = new Form<String>("formAjax");
		final FeedbackPanel feedbackAjax = new FeedbackPanel("feedbackAjax");
		feedbackAjax.setOutputMarkupId(true);
		add(formAjax);
		formAjax.add(feedbackAjax);
		formAjax.add(new AjaxSubmitLink("submitAjax", formAjax) {
			private static final long serialVersionUID = 1L;
			
			/**
			 * {@inheritDoc}
			 * @see org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink#onSubmit(org.apache.wicket.ajax.AjaxRequestTarget, org.apache.wicket.markup.html.form.Form)
			 */
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				String langague = autocompleteAjaxComponent.getModelObject();
				
				if(langague == null){
					info("No language was specified");
					
				} else {
					info("The language selected was :  '" + langague);
				}
				
				target.addComponent(feedbackAjax);
			}
		});
		
		autocompleteAjaxComponent = new AutocompleteAjaxComponent<String>("autocompleteAjaxComponent", new Model<String>()) {
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.ui.autocomplete.AutocompleteAjaxComponent#getValues(java.lang.String)
			 */
			@Override
			public List<String> getValues(String term) {
				ArrayList<String> values = new ArrayList<String>();
				for(String l : languages){
					if(l.contains(term)){
						values.add(l);
					}
				}
				return values;
			}
			
			/**
			 * {@inheritDoc}
			 * @see org.odlabs.wiquery.ui.autocomplete.AutocompleteAjaxComponent#getValueOnSearchFail(java.lang.String)
			 */
			@Override
			public String getValueOnSearchFail(String input) {
				return input;
			}
		};
		formAjax.add(autocompleteAjaxComponent);
	}
}
