package org.odlabs.wiquery.presentation.examples.ui.layout;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.Options;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;
import org.odlabs.wiquery.ui.draggable.DraggableJavaScriptResourceReference;
import org.odlabs.wiquery.ui.effects.CoreEffectJavaScriptResourceReference;
import org.odlabs.wiquery.ui.effects.DropEffectJavaScriptResourceReference;
import org.odlabs.wiquery.ui.effects.ScaleEffectJavaScriptResourceReference;
import org.odlabs.wiquery.ui.effects.SlideEffectJavaScriptResourceReference;

/**
 * jQuery UI Layout
 * 
 * @author Julien Roche
 *
 */
@WiQueryUIPlugin
public class Layout extends Panel implements IWiQueryPlugin {
	
	/**
	 * Enumeration of layout possible position
	 * @author Julien Roche
	 *
	 */
	public enum LayoutPositionEnum {
		EAST,
		NORTH,
		SOUTH,
		WEST;

		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	/**
	 * Enumeration of pane
	 * @author Julien Roche
	 *
	 */
	public enum PanePositionEnum {
		CENTER,
		EAST,
		NORTH,
		SOUTH,
		WEST;

		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = -279212653488048003L;
	
	/** Properties on the layout parameter (use it into callback functions) : 
	 * pane name  */
	public static final String PANE_NAME = "paneName";
	
	/** Properties on the layout parameter (use it into callback functions) : 
	 * pane element  */
	public static final String PANE_ELEMENT = "paneElement";
	
	/** Properties on the layout parameter (use it into callback functions) : 
	 * pane state  */
	public static final String PANE_STATE = "paneState";
	
	/** Properties on the layout parameter (use it into callback functions) : 
	 * pane options  */
	public static final String PANE_OPTIONS = "paneOptions";
	
	/** Properties on the layout parameter (use it into callback functions) : 
	 * layout name  */
	public static final String LAYOUT_NAME = "layoutName";
	
	// Properties
	private Options options;

	/**
	 * Constructor
	 * @param id Wicket identifiant
	 */
	public Layout(String id) {
		super(id);
		
		options = new Options();		
		setOutputMarkupId(true);
		
		initialize(getLayoutCenterComponent("layoutCenter"), "paneCenter", 
				PanePositionEnum.CENTER);
		
		initialize(getLayoutEastComponent("layoutEast"), "paneEast", 
				PanePositionEnum.EAST);
		
		initialize(getLayoutNorthComponent("layoutNorth"), "paneNorth", 
				PanePositionEnum.NORTH);
		
		initialize(getLayoutSouthComponent("layoutSouth"), "paneSouth", 
				PanePositionEnum.SOUTH);
		
		initialize(getLayoutWestComponent("layoutWest"), "paneWest", 
				PanePositionEnum.WEST);
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#contribute(org.odlabs.wiquery.core.commons.WiQueryResourceManager)
	 */
	public void contribute(WiQueryResourceManager wiQueryResourceManager) {
		wiQueryResourceManager
		.addJavaScriptResource(DraggableJavaScriptResourceReference.get());
		
		wiQueryResourceManager
				.addJavaScriptResource(CoreEffectJavaScriptResourceReference.get());
		wiQueryResourceManager
			.addJavaScriptResource(SlideEffectJavaScriptResourceReference.get());
		wiQueryResourceManager
			.addJavaScriptResource(DropEffectJavaScriptResourceReference.get());
		wiQueryResourceManager
			.addJavaScriptResource(ScaleEffectJavaScriptResourceReference.get());
		
		wiQueryResourceManager.addCssResource(
				LayoutStyleSheetResourceReference.get());
		wiQueryResourceManager.addJavaScriptResource(
				LayoutJavascriptResourceReference.get());
	}
	
	/**
	 * Method to override to specify the Center Wicket component
	 * @param wicketId Wicket identifiant
	 * @return the component
	 */
	public Panel getLayoutCenterComponent(String wicketId) {
		return new EmptyPanel(wicketId);
	}
	
	/**
	 * Method to override to specify the East Wicket component
	 * @param wicketId Wicket identifiant
	 * @return the component
	 */
	public Panel getLayoutEastComponent(String wicketId) {
		return new EmptyPanel(wicketId);
	}
	
	/**
	 * Method to override to specify the North Wicket component
	 * @param wicketId Wicket identifiant
	 * @return the component
	 */
	public Panel getLayoutNorthComponent(String wicketId) {
		return new EmptyPanel(wicketId);
	}
	
	/**
	 * Method to override to specify the South Wicket component
	 * @param wicketId Wicket identifiant
	 * @return the component
	 */
	public Panel getLayoutSouthComponent(String wicketId) {
		return new EmptyPanel(wicketId);
	}
	
	/**
	 * Method to override to specify the West Wicket component
	 * @param wicketId Wicket identifiant
	 * @return the component
	 */
	public Panel getLayoutWestComponent(String wicketId) {
		return new EmptyPanel(wicketId);
	}

	/**Method retrieving the options of the component
	 * @return the options
	 */
	protected Options getOptions() {
		return options;
	}
	
	/**
	 * Initialization of a pane
	 * @param paneCore Pane to initialize
	 * @param containerParentId Wicket identifiant of the parent container
	 * @param panePositionEnum Postion of the pane
	 */
	protected void initialize(Panel paneCore, 
			String containerParentId,
			PanePositionEnum panePositionEnum) {
		WebMarkupContainer paneParent = new WebMarkupContainer(containerParentId);
		
		paneParent.setOutputMarkupId(true);
		paneParent.setVisible(!(paneCore instanceof EmptyPanel));
		paneParent.add(paneCore);
		
		setPaneSelector(panePositionEnum, "#" + paneParent.getMarkupId(true));
		
		add(paneParent);
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#statement()
	 */
	public JsStatement statement() {
		return new JsQuery(this).$().chain("layout",
				options.getJavaScriptOptions());		
	}

	/*---- Options section ---*/
	
	/**
	 * This is used as a prefix when generating classNames for 'custom buttons'. 
	 * 
	 * @return instance of the current component
	 */
	public Layout setButtonClass(String buttonClass) {
		options.putLiteral("buttonClass", buttonClass);
		return this;
	}

	/**
	 * Returns the component's buttonClass .
	 */
	public String getButtonClass() {
		if(this.options.containsKey("buttonClass")){
			return options.getLiteral("buttonClass");
		}
		
		return "ui-layout-button";
	}

	/**
	 * Maximum-size limit when resizing a pane (0 = as small as pane can go) 
	 * 
	 * @return instance of the current component
	 */
	public Layout setMaxSize(int maxSize) {
		options.put("maxSize", maxSize);
		return this;
	}

	/**
	 * Returns the component's maxSize.
	 */
	public int getMaxSize() {
		if(this.options.containsKey("maxSize")){
			return options.getInt("maxSize");
		}
		
		return 0;
	}
	
	/**
	 * Minimum-size limit when resizing a pane (0 = as small as pane can go) 
	 * 
	 * @return instance of the current component
	 */
	public Layout setMinSize(int minSize) {
		options.put("minSize", minSize);
		return this;
	}

	/**
	 * Returns the component's minSize.
	 */
	public int getMinSize() {
		if(this.options.containsKey("minSize")){
			return options.getInt("minSize");
		}
		
		return 50;
	}
	
	/**
	 * Default values are: ".ui-layout-north", ".ui-layout-west", etc.
	 * Any valid jQuery selector string can be used – classNames, IDs, etc. 
	 * 
	 * @return instance of the current component
	 */
	public Layout setPaneSelector(PanePositionEnum pane, String selector) {
		options.putLiteral(pane + "__paneSelector", selector);
		return this;
	}
	
	/**
	 * Returns the component's paneSelector.
	 */
	public String getPaneSelector(PanePositionEnum pane) {
		if(this.options.containsKey(pane + "__paneSelector")){
			return options.getLiteral(pane + "__paneSelector");
		}
		
		return ".ui-layout-PANE";
	}
	
	/*---- Events section ---*/
	

	/**Set's the callback when the event is triggered when the component is 
	 * ending to be showed
	 * @param onShowEnd
	 * @return instance of the current behavior
	 */
	public Layout setOnShowEndEvent(JsScopeLayoutEvent onShowEnd) {
		this.options.put("onshow_end", onShowEnd);
		return this;
	}
	
	/**Set's the callback when the event is triggered when the component is 
	 * starting to be showed
	 * @param onShowStart
	 * @return instance of the current behavior
	 */
	public Layout setOnShowStartEvent(JsScopeLayoutEvent onShowStart) {
		this.options.put("onshow_start", onShowStart);
		return this;
	}
	
	/*---- Methods section ---*/	
	
	
	/**Method to toggle
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement toggle(LayoutPositionEnum layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain("toggle", "'" + layoutPosition  + "'");
	}

	/**Method to toggle within the ajax request
	 * @param ajaxRequestTarget
	 * @param layoutPosition
	 */
	public void toggle(AjaxRequestTarget ajaxRequestTarget, LayoutPositionEnum layoutPosition) {
		ajaxRequestTarget.appendJavascript(this.toggle(layoutPosition).render().toString());
	}
}
