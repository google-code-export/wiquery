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
package org.odlabs.wiquery.utils;

import org.apache.wicket.protocol.http.WebApplication;
import org.odlabs.wiquery.core.commons.WiQueryInstantiationListener;

/**
 * $Id$
 * <p>
 * Utility class to ease {@link WiQueryInstantiationListener} integration.
 * Configures a simple default WiQuery application. If you want to tune
 * your wiQuery application or if don't want to use inheritance you should
 * prefer the use of {@link WiQueryInstantiationListener}.
 * </p>
 * 
 * @see WiQueryInstantiationListener
 * @author Lionel Armanet
 * @since 0.5
 */
public abstract class WiQueryWebApplication extends WebApplication  {

	/**
	 * The wiquery listener used to manage WiQuery components
	 */
	private WiQueryInstantiationListener wiqueryPluginInstantiationListener;

	/**
	 * Adds WiQuery's instantiation listener to this application.
	 */
	@Override
	protected void init() {
		// we add a component instantiation listener to create plugin managers
		// each time a plugin is created
		wiqueryPluginInstantiationListener = new WiQueryInstantiationListener();
		addComponentInstantiationListener(wiqueryPluginInstantiationListener);
		super.init();
	}

}
