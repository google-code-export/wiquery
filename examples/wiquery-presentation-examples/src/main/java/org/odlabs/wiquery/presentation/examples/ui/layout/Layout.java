package org.odlabs.wiquery.presentation.examples.ui.layout;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
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
 * Missing functionalities
 * <ul>
 * 	<li>option : paneSelector</li>
 * 	<li>option : size</li>
 * 	<li>option : slideTrigger_open</li>
 * 	<li>option : slideTrigger_closed</li>
 * 	<li>option : togglerAlign_open</li>
 * 	<li>option : togglerAlign_closed</li>
 * 	<li>option : fxName</li>
 * 	<li>option : fxSpeed</li>
 * 	<li>option : fxSettings</li>
 * </ul>
 * 
 * @author Julien Roche
 *
 */
@WiQueryUIPlugin
public class Layout extends WebMarkupContainer implements IWiQueryPlugin {
	
	/**
	 * Enumeration of layout possible position
	 * @author Julien Roche
	 *
	 */
	public enum LayoutPosition {
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
	private Options optionsEast;
	private Options optionsNorth;
	private Options optionsSouth;
	private Options optionsWest;

	/**
	 * Constructor
	 * @param id Wicket identifiant
	 */
	public Layout(String id) {
		super(id);
		
		options = new Options();
		optionsEast = new Options();
		optionsNorth = new Options();
		optionsSouth = new Options();
		optionsWest = new Options();
		
		setOutputMarkupId(true);
		
		Panel layoutCenter = getLayoutCenterComponent("layoutCenter");
		Panel layoutEast = getLayoutEastComponent("layoutEast");
		Panel layoutNorth = getLayoutNorthComponent("layoutNorth");
		Panel layoutSouth = getLayoutSouthComponent("layoutSouth");
		Panel layoutWest = getLayoutWestComponent("layoutWest");
		
		layoutCenter.add(new AttributeModifier("class", true, new Model<String>("ui-layout-center")));
		layoutEast.add(new AttributeModifier("class", true, new Model<String>("ui-layout-east")));
		layoutNorth.add(new AttributeModifier("class", true, new Model<String>("ui-layout-north")));
		layoutSouth.add(new AttributeModifier("class", true, new Model<String>("ui-layout-south")));
		layoutWest.add(new AttributeModifier("class", true, new Model<String>("ui-layout-west")));
		
		layoutCenter.setVisible(!(layoutCenter instanceof EmptyPanel));
		layoutEast.setVisible(!(layoutEast instanceof EmptyPanel));
		layoutNorth.setVisible(!(layoutNorth instanceof EmptyPanel));
		layoutSouth.setVisible(!(layoutSouth instanceof EmptyPanel));
		layoutWest.setVisible(!(layoutWest instanceof EmptyPanel));
		
		add(layoutCenter);
		add(layoutNorth);
		add(layoutSouth);
		add(layoutEast);		
		add(layoutWest);
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

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#statement()
	 */
	public JsStatement statement() {
		if(optionsEast.isEmpty() && optionsNorth.isEmpty() && 
				optionsSouth.isEmpty() && optionsWest.isEmpty()) {
			return new JsQuery(this).$().chain("layout",
					options.getJavaScriptOptions());
			
		} else {
			return new JsQuery(this).$().chain("layout",
					"defaults:", options.getJavaScriptOptions(),
					"east:", optionsEast.getJavaScriptOptions(),
					"north:", optionsNorth.getJavaScriptOptions(),
					"south:", optionsSouth.getJavaScriptOptions(),
					"west:", optionsWest.getJavaScriptOptions());
		}		
	}

	/*---- Options section ---*/
	
	/**
	 * When this is enabled, the layout will apply basic styles directly to 
	 * resizers & buttons. This is intended for quick mock-ups, so that you 
	 * can 'see' your layout immediately. 
	 * @return instance of the current component
	 */
	public Layout setApplyDefaultStyles(boolean applyDefaultStyles) {
		options.put("applyDefaultStyles", applyDefaultStyles);
		return this;
	}

	/**
	 * Returns the component's applyDefaultStyles.
	 */
	public boolean isApplyDefaultStyles() {
		if(this.options.containsKey("applyDefaultStyles")){
			return options.getBoolean("applyDefaultStyles");
		}
		
		return false;
	}
	
	/**
	 * See setApplyDefaultStyles, but for the center section
	 * @return instance of the current component
	 */
	public Layout setApplyDefaultStylesCenterLayout(boolean applyDefaultStyles) {
		options.put("center__applyDefaultStyles", applyDefaultStyles);
		return this;
	}

	/**
	 * Returns the component's applyDefaultStyles for the center section.
	 */
	public boolean isApplyDefaultStylesCenterLayout() {
		if(this.options.containsKey("center__applyDefaultStyles")){
			return options.getBoolean("center__applyDefaultStyles");
		}
		
		return false;
	}
	
	/**
	 * See setApplyDefaultStyles, but for the east section
	 * @return instance of the current component
	 */
	public Layout setApplyDefaultStylesEastLayout(boolean applyDefaultStyles) {
		options.put("east__applyDefaultStyles", applyDefaultStyles);
		return this;
	}

	/**
	 * Returns the component's applyDefaultStyles for the east section.
	 */
	public boolean isApplyDefaultStylesEastLayout() {
		if(this.options.containsKey("east__applyDefaultStyles")){
			return options.getBoolean("east__applyDefaultStyles");
		}
		
		return false;
	}
	
	/**
	 * See setApplyDefaultStyles, but for the north section
	 * @return instance of the current component
	 */
	public Layout setApplyDefaultStylesNorthLayout(boolean applyDefaultStyles) {
		options.put("north__applyDefaultStyles", applyDefaultStyles);
		return this;
	}

	/**
	 * Returns the component's applyDefaultStyles for the north section.
	 */
	public boolean isApplyDefaultStylesNorthLayout() {
		if(this.options.containsKey("north__applyDefaultStyles")){
			return options.getBoolean("north__applyDefaultStyles");
		}
		
		return false;
	}
	
	/**
	 * See setApplyDefaultStyles, but for the south section
	 * @return instance of the current component
	 */
	public Layout setApplyDefaultStylesSouthLayout(boolean applyDefaultStyles) {
		options.put("south__applyDefaultStyles", applyDefaultStyles);
		return this;
	}

	/**
	 * Returns the component's applyDefaultStyles for the south section.
	 */
	public boolean isApplyDefaultStylesSouthLayout() {
		if(this.options.containsKey("south__applyDefaultStyles")){
			return options.getBoolean("south__applyDefaultStyles");
		}
		
		return false;
	}
	
	/**
	 * See setApplyDefaultStyles, but for the west section
	 * @return instance of the current component
	 */
	public Layout setApplyDefaultStylesWestLayout(boolean applyDefaultStyles) {
		options.put("west__applyDefaultStyles", applyDefaultStyles);
		return this;
	}

	/**
	 * Returns the component's applyDefaultStyles for the west section.
	 */
	public boolean isApplyDefaultStylesWestLayout() {
		if(this.options.containsKey("west__applyDefaultStyles")){
			return options.getBoolean("west__applyDefaultStyles");
		}
		
		return false;
	}
	
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
	 * Can a pane be closed? 
	 * 
	 * @return instance of the current component
	 */
	public Layout setClosable(boolean closable) {
		options.put("closable", closable);
		return this;
	}

	/**
	 * Returns the component's closable  .
	 */
	public boolean isClosable() {
		if(this.options.containsKey("closable")){
			return options.getBoolean("closable");
		}
		
		return true;
	}
	
	/**
	 * Selector string for INNER divs/elements. These elements will be 'ignored' 
	 * when calculations are done to auto-size the content element. This may be 
	 * necessary if there are elements inside the pane that are absolutely-positioned 
	 * and intended to 'overlay' other elements.
	 * 
	 * Same class-name could be used for elements inside all panes
	 * 
	 * @return instance of the current component
	 */
	public Layout setContentIgnoreSelector(String contentIgnoreSelector) {
		options.putLiteral("contentIgnoreSelector", contentIgnoreSelector);
		return this;
	}

	/**
	 * Returns the component's contentIgnoreSelector .
	 */
	public String getContentIgnoreSelector() {
		if(this.options.containsKey("contentIgnoreSelector")){
			return options.getLiteral("contentIgnoreSelector");
		}
		
		return "ui-layout-ignore";
	}
	
	/**
	 * Selector string for INNER div/element. This div will auto-size so only it 
	 * scrolls, and not the entire pane.
	 * 
	 * Same class-name could be used for divs inside all panes.
	 * 
	 * (MUST be a 'child' of one of the panes)
	 * 
	 * @return instance of the current component
	 */
	public Layout setContentSelector (String contentSelector) {
		options.putLiteral("contentSelector", contentSelector);
		return this;
	}

	/**
	 * Returns the component's contentSelector .
	 */
	public String getContentSelector() {
		if(this.options.containsKey("contentSelector")){
			return options.getLiteral("contentSelector");
		}
		
		return ".ui-layout-content";
	}
	
	/**
	 * If a hotkey is specified, it is automatically enabled. It does not matter 
	 * whether 'cursor hotkeys' are also enabled – those are separate.
	 * You can specify any of the following values:
	 * <ul>
	 * 	<li>letter from A to Z</li>
	 * 	<li>number from 0 to 9</li>
	 * 	<li>Javascript charCode value for the key</li>
	 * </ul>
	 * 
	 * The customHotkeys option must be set separately for each pane, but the 
	 * customHotkeyModifier option can be set once, as the 'default' for all panes.
	 * 
	 * @return instance of the current component
	 */
	public Layout setCustomHotkey (String customHotkey) {
		options.putLiteral("customHotkey", customHotkey);
		return this;
	}

	/**
	 * Returns the component's customHotkey .
	 */
	public String getCustomHotkey() {
		if(this.options.containsKey("customHotkey")){
			return options.getLiteral("customHotkey");
		}
		
		return "";
	}
	
	/**
	 * If 'true', then 'cursor hotkeys' are enabled. Can be set per-pane if desired.
	 * These default hotkeys cannot be changed - only enabled or disabled.
	 * The cursor/arrow key must be pressed in combination with CTRL -or- SHIFT
	 * <ul>
	 * 	<li>Toggle North-pane:  CTRL+Up   or   SHIFT+Up</li>
	 * 	<li>Toggle South-pane:  CTRL+Down   or   SHIFT+Down</li>
	 * 	<li>Toggle West-pane:   CTRL+Left   or   SHIFT+Left</li>
	 * 	<li>Toggle East-pane:    CTRL+Right   or   SHIFT+Right</li> 
	 * </ul>
	 * 
	 * The SHIFT+ARROW combinations are ignored if pressed while the cursor is in 
	 * a form field, allowing users to 'select text' — eg: SHIFT+Right in a TEXTAREA
	 * 
	 * @return instance of the current component
	 */
	public Layout setEnableCursorHotkey(boolean enableCursorHotkey) {
		options.put("enableCursorHotkey", enableCursorHotkey);
		return this;
	}

	/**
	 * Returns the component's enableCursorHotkey.
	 */
	public boolean isEnableCursorHotkey() {
		if(this.options.containsKey("enableCursorHotkey")){
			return options.getBoolean("enableCursorHotkey");
		}
		
		return true;
	}
	
	/**
	 * If true, the toggler-button is hidden when a pane is 'slid-open'. This 
	 * makes sense because the user only needs to 'mouse-off' to close the pane. 
	 * 
	 * @return instance of the current component
	 */
	public Layout setHideTogglerOnSlide(boolean hideTogglerOnSlide) {
		options.put("hideTogglerOnSlide", hideTogglerOnSlide);
		return this;
	}

	/**
	 * Returns the component's hideTogglerOnSlide.
	 */
	public boolean isHideTogglerOnSlide() {
		if(this.options.containsKey("hideTogglerOnSlide")){
			return options.getBoolean("hideTogglerOnSlide");
		}
		
		return false;
	}
	
	/**
	 * If 'true', then pane is 'closed' when layout is created  
	 * 
	 * @return instance of the current component
	 */
	public Layout setInitClosed(boolean initClosed) {
		options.put("initClosed", initClosed);
		return this;
	}

	/**
	 * Returns the component's initClosed.
	 */
	public boolean isInitClosed() {
		if(this.options.containsKey("initClosed")){
			return options.getBoolean("initClosed");
		}
		
		return false;
	}
	
	/**
	 * If 'true', then pane is 'hidden' when layout is created - no resizer or 
	 * spacing is visible, as if the pane does not exist!  
	 * 
	 * @return instance of the current component
	 */
	public Layout setInitHidden(boolean initHidden) {
		options.put("initHidden", initHidden);
		return this;
	}

	/**
	 * Returns the component's initHidden.
	 */
	public boolean isInitHidden() {
		if(this.options.containsKey("initHidden")){
			return options.getBoolean("initHidden");
		}
		
		return false;
	}
	
	/**
	 * Used for auto-generated classNames for each 'resizer-bar'
	 * 
	 * @return instance of the current component
	 */
	public Layout setResizerClass(String resizerClass) {
		options.putLiteral("resizerClass", resizerClass);
		return this;
	}

	/**
	 * Returns the component's resizerClass .
	 */
	public String getResizerClass() {
		if(this.options.containsKey("resizerClass")){
			return options.getLiteral("resizerClass");
		}
		
		return "ui-layout-resizer";
	}
	
	/**
	 * This is the cursor when the mouse is over the 'resizer-bar'. However, if 
	 * the mouse is over the 'toggler-button' inside the resizer bar, then the 
	 * cursor is a 'pointer' - ie, the togglerCursor instead of the resizerCursor. 
	 * 
	 * @return instance of the current component
	 */
	public Layout setResizerCursor(String resizerCursor) {
		options.putLiteral("resizerCursor", resizerCursor);
		return this;
	}

	/**
	 * Returns the component's resizerCursor  .
	 */
	public String getResizerCursor() {
		if(this.options.containsKey("resizerCursor")){
			return options.getLiteral("resizerCursor");
		}
		
		return "resizer-p";
	}
	
	/**
	 * Tip when resizer-bar can be 'dragged' to resize a pane
	 * 
	 * @return instance of the current component
	 */
	public Layout setResizerTip(String resizerTip) {
		options.putLiteral("resizerTip", resizerTip);
		return this;
	}

	/**
	 * Returns the component's resizerTip  .
	 */
	public String getResizerTip() {
		if(this.options.containsKey("resizerTip")){
			return options.getLiteral("resizerTip");
		}
		
		return "Resize";
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
	 * When open, can a pane be resized? 
	 * 
	 * @return instance of the current component
	 */
	public Layout setResizable(boolean resizable) {
		options.put("resizable", resizable);
		return this;
	}

	/**
	 * Returns the component's closable  .
	 */
	public boolean isResizable() {
		if(this.options.containsKey("resizable")){
			return options.getBoolean("resizable");
		}
		
		return true;
	}
	
	/**
	 * Spacing between pane and adjacent pane - when pane is 'closed'
	 * 
	 * @return instance of the current component
	 */
	public Layout setSpacingClosed(int spacingClosed) {
		options.put("spacing_closed", spacingClosed);
		return this;
	}

	/**
	 * Returns the component's spacing_closed.
	 */
	public int getSpacingClosed() {
		if(this.options.containsKey("spacing_closed")){
			return options.getInt("spacing_closed");
		}
		
		return 6;
	}
	
	/**
	 * Spacing between pane and adjacent pane - when pane is 'open'
	 * 
	 * @return instance of the current component
	 */
	public Layout setSpacingOpen(int spacingOpen) {
		options.put("spacing_open", spacingOpen);
		return this;
	}

	/**
	 * Returns the component's spacing_open.
	 */
	public int getSpacingOpen() {
		if(this.options.containsKey("spacing_open")){
			return options.getInt("spacing_open");
		}
		
		return 6;
	}
	
	/**
	 * The default functionality of bookmarks is broken when using a layout because 
	 * the position and scrolling of pane elements are altered after the page 
	 * loads. Enabling this option (enabled by default) causes the bookmark to 
	 * be re-applied after the layout is created, causing the 'pane' containing 
	 * the bookmark/anchor to be scrolled to bring it into view.
	 * 
	 * This option should be left enabled in most cases, but if content in the l
	 * ayout-panes is never bookmarked, then you could disabled it.
	 * @return instance of the current component
	 */
	public Layout setScrollToBookmarkOnLoad(boolean scrollToBookmarkOnLoad) {
		options.put("scrollToBookmarkOnLoad", scrollToBookmarkOnLoad);
		return this;
	}

	/**
	 * Returns the component's scrollToBookmarkOnLoad.
	 */
	public boolean isScrollToBookmarkOnLoad() {
		if(this.options.containsKey("scrollToBookmarkOnLoad")){
			return options.getBoolean("scrollToBookmarkOnLoad");
		}
		
		return true;
	}
	
	/**
	 * If 'true', then when moused-over, the pane's zIndex is raised and overflow 
	 * is set to 'visible'. This allows pop-ups and drop-downs to overlap adjacent 
	 * panes.
	 * 
	 * WARNING: Enable this only for panes that do not scroll!
	 * @return instance of the current component
	 */
	public Layout setShowOverflowOnHover(boolean showOverflowOnHover) {
		options.put("showOverflowOnHover", showOverflowOnHover);
		return this;
	}

	/**
	 * Returns the component's showOverflowOnHover .
	 */
	public boolean isShowOverflowOnHover() {
		if(this.options.containsKey("showOverflowOnHover")){
			return options.getBoolean("showOverflowOnHover");
		}
		
		return false;
	}
	
	/**
	 * When closed, can a pane 'slide open' over adjacent panes? 
	 * 
	 * @return instance of the current component
	 */
	public Layout setSlidable(boolean slidable) {
		options.put("slidable", slidable);
		return this;
	}

	/**
	 * Returns the component's closable  .
	 */
	public boolean isSlidable() {
		if(this.options.containsKey("slidable")){
			return options.getBoolean("slidable");
		}
		
		return true;
	}
	
	/**
	 * Used for auto-generated classNames for each 'toggler-button'
	 * 
	 * @return instance of the current component
	 */
	public Layout setTogglerClass(String togglerClass) {
		options.putLiteral("togglerClass", togglerClass);
		return this;
	}

	/**
	 * Returns the component's togglerClass .
	 */
	public String getTogglerClass() {
		if(this.options.containsKey("togglerClass")){
			return options.getLiteral("togglerClass");
		}
		
		return "ui-layout-toggler";
	}
	
	/**
	 * Usually a background-image is set in CSS to customize a toggler-button. 
	 * However, you can also put text inside a toggler by using these options. 
	 * The text is wrapped in a SPAN, which is then added inside the toggler DIV. 
	 * The SPAN classes identify them as either 'closed' content
	 * 
	 * @return instance of the current component
	 */
	public Layout setTogglerContentClosed(String togglerContentClosed) {
		options.putLiteral("togglerContent_closed", togglerContentClosed);
		return this;
	}

	/**
	 * Returns the component's togglerContent_closed .
	 */
	public String getTogglerContentClosed() {
		if(this.options.containsKey("togglerContent_closed")){
			return options.getLiteral("togglerContent_closed");
		}
		
		return "";
	}
	
	/**
	 * Usually a background-image is set in CSS to customize a toggler-button. 
	 * However, you can also put text inside a toggler by using these options. 
	 * The text is wrapped in a SPAN, which is then added inside the toggler DIV. 
	 * The SPAN classes identify them as either 'open' content
	 * 
	 * @return instance of the current component
	 */
	public Layout setTogglerContentOpen(String togglerContentOpen) {
		options.putLiteral("togglerContent_open", togglerContentOpen);
		return this;
	}

	/**
	 * Returns the component's togglerContent_open .
	 */
	public String getTogglerContentOpen() {
		if(this.options.containsKey("togglerContent_open")){
			return options.getLiteral("togglerContent_open");
		}
		
		return "";
	}
	
	/**
	 * Length of toggler-button when pane is 'closed'
	 * 
	 * @return instance of the current component
	 */
	public Layout setTogglerLengthClose(int togglerLengthClose) {
		options.put("togglerLength_closed", togglerLengthClose);
		return this;
	}

	/**
	 * Returns the component's togglerLength_closed.
	 */
	public int getTogglerLengthClose() {
		if(this.options.containsKey("togglerLength_closed")){
			return options.getInt("togglerLength_closed");
		}
		
		return 50;
	}
	
	/**
	 * Length of toggler-button when pane is 'open'
	 * 
	 * @return instance of the current component
	 */
	public Layout setTogglerLengthOpen(int togglerLengthOpen) {
		options.put("togglerLength_open", togglerLengthOpen);
		return this;
	}

	/**
	 * Returns the component's togglerLength_open.
	 */
	public int getTogglerLengthOpen() {
		if(this.options.containsKey("togglerLength_open")){
			return options.getInt("togglerLength_open");
		}
		
		return 50;
	}
	
	/**
	 * Tip on toggler when pane is 'closed'
	 * 
	 * @return instance of the current component
	 */
	public Layout setTogglerTipClose(String togglerTipClose) {
		options.putLiteral("togglerTip_closed", togglerTipClose);
		return this;
	}

	/**
	 * Returns the component's togglerTip_closed.
	 */
	public String getTogglerTipClose() {
		if(this.options.containsKey("togglerTip_closed")){
			return options.getLiteral("togglerTip_closed");
		}
		
		return "Close";
	}
	
	/**
	 * Tip on toggler when pane is 'open'
	 * 
	 * @return instance of the current component
	 */
	public Layout setTogglerTipOpen(String togglerTipOpen) {
		options.putLiteral("togglerTip_open", togglerTipOpen);
		return this;
	}

	/**
	 * Returns the component's togglerTip_open.
	 */
	public String getTogglerTipOpen() {
		if(this.options.containsKey("togglerTip_open")){
			return options.getLiteral("togglerTip_open");
		}
		
		return "Open";
	}
	
	/*---- Events section ---*/
	
	/**Set's the callback when the event is triggered when the component is close
	 * (alias for the end event)
	 * @param onClose
	 * @return instance of the current behavior
	 */
	public Layout setOnCloseEvent(JsScopeLayoutEvent onClose) {
		this.options.put("onclose", onClose);
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
	 * @param onCloseStart
	 * @return instance of the current behavior
	 */
	public Layout setOnCloseStartEvent(JsScopeLayoutEvent onCloseStart) {
		this.options.put("onclose_start", onCloseStart);
		return this;
	}
	
	/**Set's the callback when the event is triggered when the component is hide
	 * (alias for the end event)
	 * @param onHide
	 * @return instance of the current behavior
	 */
	public Layout setOnHideEvent(JsScopeLayoutEvent onHide) {
		this.options.put("onhide", onHide);
		return this;
	}
	
	/**Set's the callback when the event is triggered when the component is 
	 * ending to be hidden
	 * @param onHideEnd
	 * @return instance of the current behavior
	 */
	public Layout setOnHideEndEvent(JsScopeLayoutEvent onHideEnd) {
		this.options.put("onhide_end", onHideEnd);
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
	
	/**Set's the callback when the event is triggered when the component is open
	 * (alias for the end event)
	 * @param onOpen
	 * @return instance of the current behavior
	 */
	public Layout setOnOpenEvent(JsScopeLayoutEvent onOpen) {
		this.options.put("onopen", onOpen);
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
	 * @param onOpenStart
	 * @return instance of the current behavior
	 */
	public Layout setOnOpenStartEvent(JsScopeLayoutEvent onOpenStart) {
		this.options.put("onopen_start", onOpenStart);
		return this;
	}
	
	/**Set's the callback when the event is triggered when the component is resize
	 * (alias for the end event)
	 * @param onResize
	 * @return instance of the current behavior
	 */
	public Layout setOnResizeEvent(JsScopeLayoutEvent onResize) {
		this.options.put("onresize", onResize);
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
	
	/**Set's the callback when the event is triggered when the component is show
	 * (alias for the end event)
	 * @param onShow
	 * @return instance of the current behavior
	 */
	public Layout setOnShowEvent(JsScopeLayoutEvent onShow) {
		this.options.put("onshow", onShow);
		return this;
	}
	
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
	
	/**Method to add a close button
	 * @param selector
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement addCloseBtn(String selector, LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain(
				"addCloseBtn", selector, "'" + layoutPosition  + "'");
	}

	/**Method to add a close button within the ajax request
	 * @param ajaxRequestTarget
	 * @param selector
	 * @param layoutPosition
	 */
	public void addCloseBtn(AjaxRequestTarget ajaxRequestTarget, 
			String selector, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(
				this.addCloseBtn(selector, layoutPosition).render().toString());
	}
	
	/**Method to add an open button
	 * @param selector
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement addOpenBtn(String selector, LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain(
				"addOpenBtn", selector, "'" + layoutPosition  + "'");
	}

	/**Method to add an open button within the ajax request
	 * @param ajaxRequestTarget
	 * @param selector
	 * @param layoutPosition
	 */
	public void addOpenBtn(AjaxRequestTarget ajaxRequestTarget, 
			String selector, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(
				this.addOpenBtn(selector, layoutPosition).render().toString());
	}
	
	/**Method to add a pin button
	 * @param selector
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement addPinBtn(String selector, LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain(
				"addPinBtn", selector, "'" + layoutPosition  + "'");
	}

	/**Method to add a pin button within the ajax request
	 * @param ajaxRequestTarget
	 * @param selector
	 * @param layoutPosition
	 */
	public void addPinBtn(AjaxRequestTarget ajaxRequestTarget, 
			String selector, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(
				this.addPinBtn(selector, layoutPosition).render().toString());
	}
	
	/**Method to add a toggle button
	 * @param selector
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement addToggleBtn(String selector, LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain(
				"addToggleBtn", selector, "'" + layoutPosition  + "'");
	}

	/**Method to add a toggle button within the ajax request
	 * @param ajaxRequestTarget
	 * @param selector
	 * @param layoutPosition
	 */
	public void addToggleBtn(AjaxRequestTarget ajaxRequestTarget, 
			String selector, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(
				this.addToggleBtn(selector, layoutPosition).render().toString());
	}
	
	/**Method allowing overflow
	 * @param elemOrPane
	 * @return the associated JsStatement
	 */
	public JsStatement allowOverflow(String elemOrPane) {
		return new JsQuery(this).$().chain("layout").chain(
				"allowOverflow", elemOrPane);
	}

	/**Method allowing overflow within the ajax request
	 * @param ajaxRequestTarget
	 * @param elemOrPane
	 */
	public void addToggleBtn(AjaxRequestTarget ajaxRequestTarget, 
			String elemOrPane) {
		ajaxRequestTarget.appendJavascript(
				this.allowOverflow(elemOrPane).render().toString());
	}
	
	/**Method to close
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement close(LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain("close", "'" + layoutPosition  + "'");
	}

	/**Method to close within the ajax request
	 * @param ajaxRequestTarget
	 * @param layoutPosition
	 */
	public void close(AjaxRequestTarget ajaxRequestTarget, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(this.close(layoutPosition).render().toString());
	}
	
	/**Method to hide
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement hide(LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain("hide", "'" + layoutPosition  + "'");
	}

	/**Method to hide within the ajax request
	 * @param ajaxRequestTarget
	 * @param layoutPosition
	 */
	public void hide(AjaxRequestTarget ajaxRequestTarget, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(this.hide(layoutPosition).render().toString());
	}
	
	/**Method to open
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement open(LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain("open", "'" + layoutPosition  + "'");
	}

	/**Method to open within the ajax request
	 * @param ajaxRequestTarget
	 * @param layoutPosition
	 */
	public void open(AjaxRequestTarget ajaxRequestTarget, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(this.open(layoutPosition).render().toString());
	}
	
	/**Method disabling overflow
	 * @param elemOrPane
	 * @return the associated JsStatement
	 */
	public JsStatement resetOverflow(String elemOrPane) {
		return new JsQuery(this).$().chain("layout").chain(
				"resetOverflow", elemOrPane);
	}

	/**Method disabling overflow within the ajax request
	 * @param ajaxRequestTarget
	 * @param elemOrPane
	 */
	public void resetOverflow(AjaxRequestTarget ajaxRequestTarget, 
			String elemOrPane) {
		ajaxRequestTarget.appendJavascript(
				this.resetOverflow(elemOrPane).render().toString());
	}
	
	/**Method to resizeContent
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement resizeContent(LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain("resizeContent", "'" + layoutPosition  + "'");
	}

	/**Method to resizeContent within the ajax request
	 * @param ajaxRequestTarget
	 * @param layoutPosition
	 */
	public void resizeContent(AjaxRequestTarget ajaxRequestTarget, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(this.resizeContent(layoutPosition).render().toString());
	}
	
	/**Method to show
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement show(LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain("show", "'" + layoutPosition  + "'");
	}

	/**Method to show within the ajax request
	 * @param ajaxRequestTarget
	 * @param layoutPosition
	 */
	public void show(AjaxRequestTarget ajaxRequestTarget, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(this.show(layoutPosition).render().toString());
	}
	
	/**Method to show
	 * @param layoutPosition
	 * @param openPane
	 * @return the associated JsStatement
	 */
	public JsStatement show(LayoutPosition layoutPosition, boolean openPane) {
		return new JsQuery(this).$().chain("layout").chain("show", 
				"'" + layoutPosition  + "'", Boolean.toString(openPane));
	}

	/**Method to show within the ajax request
	 * @param ajaxRequestTarget
	 * @param layoutPosition
	 * @param openPane
	 */
	public void show(AjaxRequestTarget ajaxRequestTarget, 
			LayoutPosition layoutPosition, boolean openPane) {
		ajaxRequestTarget.appendJavascript(
				this.show(layoutPosition, openPane).render().toString());
	}
	
	/**Method to sizePane
	 * @param layoutPosition
	 * @param sizeInPixel Size in pixel
	 * @return the associated JsStatement
	 */
	public JsStatement sizePane(LayoutPosition layoutPosition, int sizeInPixel) {
		return new JsQuery(this).$().chain("layout").chain("sizePane", 
				"'" + layoutPosition  + "'", Integer.toString(sizeInPixel));
	}

	/**Method to sizePane within the ajax request
	 * @param ajaxRequestTarget
	 * @param layoutPosition
	 * @param sizeInPixel Size in pixel
	 */
	public void sizePane(AjaxRequestTarget ajaxRequestTarget, 
			LayoutPosition layoutPosition, int sizeInPixel) {
		ajaxRequestTarget.appendJavascript(
				this.sizePane(layoutPosition, sizeInPixel).render().toString());
	}
	
	/**Method to toggle
	 * @param layoutPosition
	 * @return the associated JsStatement
	 */
	public JsStatement toggle(LayoutPosition layoutPosition) {
		return new JsQuery(this).$().chain("layout").chain("toggle", "'" + layoutPosition  + "'");
	}

	/**Method to toggle within the ajax request
	 * @param ajaxRequestTarget
	 * @param layoutPosition
	 */
	public void toggle(AjaxRequestTarget ajaxRequestTarget, LayoutPosition layoutPosition) {
		ajaxRequestTarget.appendJavascript(this.toggle(layoutPosition).render().toString());
	}
}
