package org.odlabs.wiquery.plugin.layout;

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
import org.odlabs.wiquery.ui.mouse.MouseJavascriptResourceReference;
import org.odlabs.wiquery.ui.widget.WidgetJavascriptResourceReference;

/**
 * 
 * @author Julien Roche 
 * @author Ernesto Reinaldo Barreiro (reiern70@gmail.com)
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
	
	/** Constant of serialization */
	private static final long serialVersionUID = 1;
	
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
	 * This flag allows to use the same Layout component either as a top 
	 * layout (topLevel = true), .i.e. the body of the page is a layout, 
	 * or as a component nested inside another Wicket component.
	 */
	private boolean topLevel;
	
	/**
	 * Constructor
	 * @param id Wicket identifiant
	 */
	public Layout(String id, boolean topLevel) {
		super(id);
		this.topLevel = topLevel;
		options = new Options();	
		if(!topLevel)
			setOutputMarkupId(true);		
		else 
			setRenderBodyOnly(true);
		
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
		wiQueryResourceManager.addJavaScriptResource(WidgetJavascriptResourceReference.get());
		wiQueryResourceManager.addJavaScriptResource(MouseJavascriptResourceReference.get());
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
		paneCore.setRenderBodyOnly(true);
		
		setPaneSelector(panePositionEnum, "#" + paneParent.getMarkupId(true));
		
		add(paneParent);
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#statement()
	 */
	public JsStatement statement() {
		if(!topLevel)
			return new JsQuery(this).$().chain("layout",
				options.getJavaScriptOptions());		
		else 
			return new JsStatement().$(null, "body").chain("layout",
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
	
	public Layout setMaxSize(PanePositionEnum pane, int maxSize) {
		options.put(pane+"__maxSize", maxSize);
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
	 * 
	 * @param closable
	 * @return
	 */
	public Layout setClosable(boolean closable) {
		options.put("closable", closable);
		return this;
	}
	
	/**
	 * 
	 * @param pane
	 * @param closable
	 * @return
	 */
	public Layout setClosable(PanePositionEnum pane, boolean closable) {
		options.put(pane + "__closable", closable);
		return this;
	}
	
	/**
	 * 
	 * @param closable
	 * @return
	 */
	public Layout setResizable(boolean closable) {
		options.put("resizable", closable);
		return this;
	}
	
	
	/**
	 * 
	 * @param pane
	 * @param closable
	 * @return
	 */
	public Layout setResizable(PanePositionEnum pane, boolean closable) {
		options.put(pane + "__resizable", closable);
		return this;
	}
	 
	
	/**
	 * 
	 * @param pane
	 * @param spacing
	 * @return
	 */
	public Layout setSpacingClosed(int spacing) {
		options.put("spacing_closed", spacing);
		return this;
	}
	
	/**
	 * 
	 * @param pane
	 * @param spacing
	 * @return
	 */
	public Layout setSpacingClosed(PanePositionEnum pane, int spacing) {
		options.put(pane + "__spacing_closed", spacing);
		return this;
	}
	
	
	/**
	 * 
	 * @param pane
	 * @param spacing
	 * @return
	 */
	public Layout setSpacingOpen(int spacing) {
		options.put("spacing_open", spacing);
		return this;
	}
	
	/**
	 * 
	 * @param pane
	 * @param spacing
	 * @return
	 */
	public Layout setSpacingOpen(PanePositionEnum pane, int spacing) {
		options.put(pane + "__spacing_open", spacing);
		return this;
	}
	
	/**
	 * If 'true', then all panes are 'closed' when layout is created 
	 * 
	 * @param pane
	 * @param spacing
	 * @return
	 */
	public Layout setInitClosed(boolean initClosed) {
		options.put("initClosed", initClosed);
		return this;
	}
	
	/**
	 * If 'true', then pane is 'closed' when layout is created 
	 * 
	 * @param pane
	 * @param spacing
	 * @return
	 */
	public Layout setInitClosed(PanePositionEnum pane, boolean initClosed) {
		options.put(pane + "__initClosed", initClosed);
		return this;
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

	public Layout setMinSize(PanePositionEnum pane, int minSize) {
		options.put(pane+"__minSize", minSize);
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
	
	/**Set's the callback when the event is triggered when the component is 
	 * ending to be opened
	 * @param onOpenEnd
	 * @return instance of the current behavior
	 */
	public Layout setOnOpenEndEvent(JsScopeLayoutEvent onOpenEnd) {
		this.options.put("onopen_end", onOpenEnd);
		return this;
	}
	
	/**Set's the callback when the event is triggered when the component is 
	 * starting to be opened
	 * @param onShowStart
	 * @return instance of the current behavior
	 */
	public Layout setOnOpenStartEvent(JsScopeLayoutEvent onOpenStart) {
		this.options.put("onopen_start", onOpenStart);
		return this;
	}
	
	 
	
	/**Set's the callback when the event is triggered when the component is 
	 * ending to be resized
	 * @param onResizeEnd
	 * @return instance of the current behavior
	 */
	public Layout setOnResizeEndEvent(JsScopeLayoutEvent onResizeEnd) {
		this.options.put("onresize_end", onResizeEnd);
		return this;
	}
	
	/**Set's the callback when the event is triggered when the component is 
	 * starting to be resized
	 * @param onResizeStart
	 * @return instance of the current behavior
	 */
	public Layout setOnResizeStartEvent(JsScopeLayoutEvent onResizeStart) {
		this.options.put("onresize_start", onResizeStart);
		return this;
	}
	
	/**Set's the callback when the event is triggered when the component is 
	 * ending to be hidden
	 * @param onOnHideEnd
	 * @return instance of the current behavior
	 */
	public Layout setOnHideEndEvent(JsScopeLayoutEvent onOnHideEnd) {
		this.options.put("onhide_end", onOnHideEnd);
		return this;
	}
	
	/**Set's the callback when the event is triggered when the component is 
	 * starting to be hidden
	 * @param onHideStart
	 * @return instance of the current behavior
	 */
	public Layout setOnHideStartEvent(JsScopeLayoutEvent onHideStart) {
		this.options.put("onhide_start", onHideStart);
		return this;
	}
	 
	/**Set's the callback when the event is triggered when the component is 
	 * ending to be closed
	 * @param onCloseEnd
	 * @return instance of the current behavior
	 */
	public Layout setOnCloseEndEvent(JsScopeLayoutEvent onCloseEnd) {
		this.options.put("onclose_end", onCloseEnd);
		return this;
	}
	
	/**Set's the callback when the event is triggered when the component is 
	 * starting to be closed
	 * @param onShowStart
	 * @return instance of the current behavior
	 */
	public Layout setOnCloseStartEvent(JsScopeLayoutEvent onCloseStart) {
		this.options.put("onclose_start", onCloseStart);
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
