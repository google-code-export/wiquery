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
package org.odlabs.wiquery.core.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.wicket.Application;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.javascript.IJavascriptCompressor;
import org.apache.wicket.javascript.NoOpJavascriptCompressor;
import org.apache.wicket.markup.html.resources.JavascriptResourceReference;
import org.odlabs.wiquery.core.commons.compressed.WiQueryYUICompressedStyleSheetResource;
import org.odlabs.wiquery.core.commons.listener.WiQueryPluginRenderingListener;

/**
 * $Id$
 * 
 * <p>
 * Bean to get the wiQuery settings
 * </p>
 * 
 * @author Julien Roche
 * @since 1.1
 */
public class WiQuerySettings implements Serializable {
	// Constants
	/** Constant of serialization */
	private static final long serialVersionUID = 4047364411001306905L;

	/**
	 * Get {@link WiQuerySettings} for current thread.
	 * 
	 * @return The settings
	 */
	public static WiQuerySettings get() {
		WiQuerySettings instance = Application.get().getMetaData(
				WiQueryInitializer.WIQUERY_INSTANCE_KEY);

		if (instance == null) {
			throw new WicketRuntimeException(
					"There is no WiQueryInstantiationListener attached to the application "
							+ Thread.currentThread().getName());
		}

		return instance;
	}

	// Properties
	private boolean autoImportJQueryResource;
	private boolean enableResourcesMerging;
	private List<WiQueryPluginRenderingListener> listeners;
	private JavascriptResourceReference jQueryCoreResourceReference;
	private boolean minifiedResources;

	/**
	 * Default constructor
	 */
	public WiQuerySettings() {
		super();

		setAutoImportJQueryResource(true);
		setEnableResourcesMerging(false);
		setJQueryCoreResourceReference(null);
		listeners = new ArrayList<WiQueryPluginRenderingListener>();

		IJavascriptCompressor compressor = Application.get()
				.getResourceSettings().getJavascriptCompressor();
		setMinifiedResources(compressor != null
				&& !(compressor instanceof NoOpJavascriptCompressor));
	}

	/**
	 * Method adding a {@link WiQueryPluginRenderingListener}
	 * 
	 * @param listener
	 * @return the state
	 */
	public boolean addListener(WiQueryPluginRenderingListener listener) {
		return listeners.add(listener);
	}

	/**
	 * @return the list of listener from the listeners option
	 */
	public ListIterator<WiQueryPluginRenderingListener> getListeners() {
		return listeners.listIterator();
	}

	/**
	 * @return the state of the autoImportJQueryResource option
	 */
	public boolean isAutoImportJQueryResource() {
		return autoImportJQueryResource;
	}

	/**
	 * @return the state of the enableResourcesMerging option
	 */
	public boolean isEnableResourcesMerging() {
		return enableResourcesMerging;
	}

	/**
	 * <p>
	 * When true wiquery delivers minimized versions js/css files, when false
	 * wiquery delivers normal (non-minimized) versions. The default value
	 * depends on whether an {@link IJavascriptCompressor} is used or not.
	 * </p>
	 * <p>
	 * This setting also enables the {@link WiQueryYUICompressedStyleSheetResource} to be used.
	 * </p>
	 * <p>
	 * Always provide the normal (non-minimized) version, wiquery will reference
	 * to the minimized version when
	 * {@link WiQuerySettings#isCompressedJavascript()} is true.
	 * </p>
	 * <p>
	 * The filename format for the 2 versions is:
	 * <ul>
	 * <li>Normal version: <i>foo.js</i> / <i>foo.css</i></li>
	 * <li>Minimized version: <i>foo.min.js</i> / <i>foo.min.css</i></li>
	 * </ul>
	 * </p>
	 * 
	 * @return the state of the minifiedResources option.
	 */
	public boolean isMinifiedResources() {
		return minifiedResources;
	}

	/**
	 * Set the autoImportJQueryResource option
	 * 
	 * @param autoImportJQueryResource
	 */
	public void setAutoImportJQueryResource(boolean autoImportJQueryResource) {
		this.autoImportJQueryResource = autoImportJQueryResource;
	}

	/**
	 * Set the enableResourcesMerging option
	 * 
	 * @param enableResourcesMerging
	 */
	public void setEnableResourcesMerging(boolean enableResourcesMerging) {
		this.enableResourcesMerging = enableResourcesMerging;
	}

	/**
	 * @return the {@link JavascriptResourceReference} where we can find the
	 *         jQuery core
	 */
	public JavascriptResourceReference getJQueryCoreResourceReference() {
		return jQueryCoreResourceReference;
	}

	/**
	 * Set the jQuery core to use
	 * 
	 * @param jQueryCoreResourceReference
	 */
	public void setJQueryCoreResourceReference(
			JavascriptResourceReference jQueryCoreResourceReference) {
		this.jQueryCoreResourceReference = jQueryCoreResourceReference;
	}

	/**
	 * Sets the minifiedResources option
	 * 
	 * @param minifiedResources
	 * @see #isMinifiedResources()
	 */
	public void setMinifiedResources(boolean minifiedResources) {
		this.minifiedResources = minifiedResources;
	}
}
