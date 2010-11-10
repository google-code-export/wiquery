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
package org.odlabs.wiquery.ui.dialog.util;

import java.util.Locale;

import junit.framework.TestCase;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test on {@link DialogUtilsBehavior}
 * @author Julien Roche
 *
 */
public class DialogUtilsBehaviorTestCase extends TestCase {
	// Properties
	private DialogUtilsBehavior dialogUtilsBehavior;

	/**
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		new WicketTester(new WebApplication() {
			@Override
			public Class<? extends Page> getHomePage() {
				return null;
			}
		});
		
		dialogUtilsBehavior = new DialogUtilsBehavior();
		
		WebMarkupContainer anId = new WebMarkupContainer("anId"){
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 * @see org.apache.wicket.Component#getLocale()
			 */
			@Override
			public Locale getLocale() {
				return Locale.FRENCH;
			}
		};
		anId.setMarkupId(anId.getId());
		anId.add(dialogUtilsBehavior);
	}

	/**
	 * Test method for {@link org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior#errorDialog(java.lang.String)}.
	 */
	@Test
	public void testErrorDialog() {
		Assert.assertNotNull(dialogUtilsBehavior.errorDialog("a message"));
		Assert.assertEquals(
				dialogUtilsBehavior.errorDialog("a message").render().toString(), 
				"$.ui.dialog.wiquery.errorDialog(2, 'fr', \"a message\", 'resources/org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior/cancel.png');");
	}

	/**
	 * Test method for {@link org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior#questionDialog(java.lang.String)}.
	 */
	@Test
	public void testQuestionDialog() {
		Assert.assertNotNull(dialogUtilsBehavior.questionDialog("a message"));
		Assert.assertEquals(
				dialogUtilsBehavior.questionDialog("a message").render().toString(), 
				"$.ui.dialog.wiquery.questionDialog(2, 'fr', \"a message\", 'resources/org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior/questionmark.png');");
	}

	/**
	 * Test method for {@link org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior#simpleDialog(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSimpleDialog() {
		Assert.assertNotNull(dialogUtilsBehavior.simpleDialog("a title", "a message"));
		Assert.assertEquals(
				dialogUtilsBehavior.simpleDialog("a title", "a message").render().toString(), 
				"$.ui.dialog.wiquery.simpleDialog(2, 'fr', 'a title', \"a message\");");
	}

	/**
	 * Test method for {@link org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior#waitDialog()}.
	 */
	@Test
	public void testWaitDialog() {
		Assert.assertNotNull(dialogUtilsBehavior.waitDialog());
		WaitDialogStatements st = dialogUtilsBehavior.waitDialog();
		
		Assert.assertNotNull(st.getClose());
		Assert.assertNotNull(st.getOpen());
		
		Assert.assertEquals(st.getClose().render().toString(), "$('#dialog2').dialog('close');");
		Assert.assertEquals(st.getOpen().render().toString(), 
				"$.ui.dialog.wiquery.waitDialog(2, 'fr', 'resources/org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior/wait.gif');");
	}

	/**
	 * Test method for {@link org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior#warningDialog(java.lang.String)}.
	 */
	@Test
	public void testWarningDialog() {
		Assert.assertNotNull(dialogUtilsBehavior.warningDialog("a message"));
		Assert.assertEquals(
				dialogUtilsBehavior.warningDialog("a message").render().toString(), 
				"$.ui.dialog.wiquery.warningDialog(2, 'fr', \"a message\", 'resources/org.odlabs.wiquery.ui.dialog.util.DialogUtilsBehavior/warning.png');");
	}
}
