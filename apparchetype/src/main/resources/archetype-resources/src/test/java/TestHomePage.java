#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import junit.framework.TestCase;

import org.apache.wicket.util.tester.WicketTester;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage extends TestCase {
	private WicketTester tester;

	@Override
	public void setUp() {
		this.tester = new WicketTester(new WicketApplication());
	}

	public void testRenderMyPage() {
		// start and render the test page
		this.tester.startPage(HomePage.class);

		// assert rendered page class
		this.tester.assertRenderedPage(HomePage.class);

	}
}
