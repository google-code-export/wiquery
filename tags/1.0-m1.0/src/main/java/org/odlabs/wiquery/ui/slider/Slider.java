/*
 * Copyright (c) 2009 WiQuery team
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.odlabs.wiquery.ui.slider;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.core.options.ArrayItemOptions;
import org.odlabs.wiquery.core.options.ICollectionItemOptions;
import org.odlabs.wiquery.core.options.IComplexOption;
import org.odlabs.wiquery.core.options.IntegerItemOptions;
import org.odlabs.wiquery.core.options.Options;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;
import org.odlabs.wiquery.ui.core.JsScopeUiEvent;

/**
 * $Id: Slider.java
 * <p>
 * Creates a slider UI component from this {@link WebMarkupContainer}'s
 * HTML markup.
 * </p>
 * 
 * @author Lionel Armanet
 * @since 1.0
 */
@WiQueryUIPlugin
public class Slider extends WebMarkupContainer implements IWiQueryPlugin {	
	// Constants
	/**	Constant of serialization */
	private static final long serialVersionUID = 3738656024036987661L;
	
	/** Properties on the ui parameter (use it into callback functions) :
	 * DOMElement - the current focused handle */
	public static final String UI_HANDLE = "ui.handle";
	/** Properties on the ui parameter (use it into callback functions) :
	 * Integer - the current handle's value */
	public static final String UI_VALUE = "ui.value";

	/**
	 * Enumeration for the orientation option
	 * @author Lionel Armanet
	 *
	 */
	public static enum Orientation { 
		VERTICAL, 
		HORIZONTAL
	};
	
	// Properties
	private Options options;
	
	/** Constructor
	 * @param id Markup identifiant
	 * @param min Minimum value
	 * @param max Maximum value
	 */
	public Slider(String id, Number min, Number max) {
		super(id);
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#contribute(org.odlabs.wiquery.core.commons.WiQueryResourceManager)
	 */
	public void contribute(WiQueryResourceManager wiQueryResourceManager) {
		wiQueryResourceManager.addJavaScriptResource(SliderJavaScriptResourceReference.get());
	}

	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.core.commons.IWiQueryPlugin#statement()
	 */
	public JsStatement statement() {
		return new JsQuery(this).$().chain("slider", options.getJavaScriptOptions());
	}

	/**Method retrieving the options of the component
	 * @return the options
	 */
	protected Options getOptions() {
		return options;
	}
	
	/*---- Options section ---*/
	
	/**Whether to slide handle smoothly when user click outside handle on the bar.
	 * @param animate
	 */
	public void setAnimate(boolean animate) {
		this.options.put("animate", animate);
	}
	
	/**
	 * @return the animate option value
	 */
	public boolean getAnimate() {
		return this.options.getBoolean("animate");
	}
	
	/**Sets the maximum value of the slider.
	 * @param max
	 */
	public void setMax(int max) {
		this.options.put("max", max);
	}

	/**
	 * @return the max option value
	 */
	public int getMax() {
		return this.options.getInt("max");
	}
	
	/**Sets the minimum  value of the slider.
	 * @param min
	 */
	public void setMin(int min) {
		this.options.put("min", min);
	}

	/**
	 * @return the min option value
	 */
	public int getMin() {
		return this.options.getInt("min");
	}
	
	/**Normally you don't need to set this option because the plugin detects 
	 * the slider orientation automatically. If the orientation is not correctly 
	 * detected you can set this option to 'horizontal' or 'vertical'.
	 * @param orientation
	 */
	public void setOrientation(Orientation orientation) {
		this.options.putLiteral("orientation", orientation.toString().toLowerCase());
	}
	
	/**
	 * @return the orientation option value
	 */
	public Orientation getOrientation() {
		return Orientation.valueOf(this.options.getLiteral("orientation").toUpperCase());
	}
	
	/**If set to true, the slider will detect if you have two handles and create
	 * a stylable range element between these two. Two other possible values are
	 * 'min' and 'max'. A min range goes from the slider min to one handle. A 
	 * max range goes from one handle to the slider max.
	 * @param range
	 */
	public void setRange(SliderRange range) {
		this.options.put("range", range);
	}
	
	/**
	 * @return the range option value
	 */
	public SliderRange getRange() {
		IComplexOption range = this.options.getComplexOption("range");
		if(range != null && range instanceof SliderRange){
			return (SliderRange) range;
		}
		
		return null;
	}
	
	/**Sets the size or amount of each interval or step the slider takes between 
	 * min and max. The full specified value range of the slider (max - min) 
	 * needs to be evenly divisible by the step.
	 * @param step
	 */
	public void setStep(int step) {
		this.options.put("step", step);
	}

	/**
	 * @return the value option value
	 */
	public int getStep() {
		return this.options.getInt("step");
	}
	
	/**Sets the current value of the slider
	 * (Determines the value of the slider, if there's only one handle. If there
	 *  is more than one handle, determines the value of the first handle.)
	 * @param value
	 */
	public void setValue(int value) {
		this.options.put("value", value);
	}

	/**
	 * @return the value option value
	 */
	public int getValue() {
		return this.options.getInt("value");
	}
	
	/**This option can be used to specify multiple handles. If range is set to 
	 * true, the length of 'values' should be 2.
	 * @param values
	 */
	public void setValues(ArrayItemOptions<IntegerItemOptions> values) {
		this.options.put("values", values);
	}
	
	/**
	 * @return the values option value
	 */
	public ICollectionItemOptions getValues() {
		return this.options.getListItemOptions("values");
	}
	
	/*---- Events section ---*/
	
	/**This event is triggered on slide stop, or if the value is changed 
	 * programmatically (by the value method). Takes arguments event and ui. 
	 * Use event.orginalEvent to detect whether the value changed by mouse, 
	 * keyboard, or programmatically. Use ui.value (single-handled sliders) to 
	 * obtain the value of the current handle, $(this).slider('values', index) 
	 * to get another handle's value.
	 * @param change
	 */
	public void setChangeEvent(JsScopeUiEvent change) {
		this.options.put("change", change);
	}
	
	/**Set's the callback when when the user starts sliding.
	 * @param start
	 */
	public void setStartEvent(JsScopeUiEvent start) {
		this.options.put("start", start);
	}
	
	/**This event is triggered on every mouse move during slide. Use ui.value 
	 * (single-handled sliders) to obtain the value of the current handle, 
	 * $(..).slider('value', index) to get another handles' value. 
	 * @param start
	 */
	public void setSlideEvent(JsScopeUiEvent slide) {
		this.options.put("slide", slide);
	}
	
	/**Set's the callback when when the user stops sliding.
	 * @param stop
	 */
	public void setStopEvent(JsScopeUiEvent stop) {
		this.options.put("stop", stop);
	}
	
	/*---- Methods section ---*/
	
	/**Method to destroy the slider
	 * This will return the element back to its pre-init state.
	 * @return the associated JsStatement
	 */
	public JsStatement destroy() {
		return new JsQuery(this).$().chain("slider", "'destroy'");
	}

	/**Method to destroy the slider within the ajax request
	 * @param ajaxRequestTarget
	 */
	public void destroy(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript(this.destroy().render().toString());
	}
	
	/**Method to disable the slider
	 * @return the associated JsStatement
	 */
	public JsStatement disable() {
		return new JsQuery(this).$().chain("slider", "'disable'");
	}

	/**Method to disable the slider within the ajax request
	 * @param ajaxRequestTarget
	 */
	public void disable(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript(this.disable().render().toString());
	}
	
	/**Method to enable the slider
	 * @return the associated JsStatement
	 */
	public JsStatement enable() {
		return new JsQuery(this).$().chain("slider", "'enable'");
	}

	/**Method to enable the slider within the ajax request
	 * @param ajaxRequestTarget
	 */
	public void enable(AjaxRequestTarget ajaxRequestTarget) {
		ajaxRequestTarget.appendJavascript(this.enable().render().toString());
	}
	
	/**Method to set the current value of the slider
	 * @param value
	 * @return the associated JsStatement
	 */
	public JsStatement value(int value) {
		return new JsQuery(this).$().chain("slider", "'value'", Integer.toString(value));
	}

	/**Method to set the current value of the slider within the ajax request
	 * @param ajaxRequestTarget
	 * @param value
	 */
	public void value(AjaxRequestTarget ajaxRequestTarget, int value) {
		ajaxRequestTarget.appendJavascript(this.value(value).render().toString());
	}
	
	/**Method to set the values of the slider. For multiple handle or range sliders.
	 * @param index
	 * @param value
	 * @return the associated JsStatement
	 */
	public JsStatement values(int index, int value) {
		return new JsQuery(this).$().chain("slider", "'values'"
				, Integer.toString(index), Integer.toString(value));
	}

	/**Method to set the current values of the slider within the ajax request
	 * @param ajaxRequestTarget
	 * @param index
	 * @param value
	 */
	public void values(AjaxRequestTarget ajaxRequestTarget, int index, int value) {
		ajaxRequestTarget.appendJavascript(this.values(index, value).render().toString());
	}
}