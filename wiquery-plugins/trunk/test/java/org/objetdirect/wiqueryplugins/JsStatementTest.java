package org.objetdirect.wiqueryplugins;

import org.apache.wicket.util.tester.WicketTester;
import org.objetdirect.wiqueryplugins.ui.flot.AdvancedFlot;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.testng.annotations.Test;

public class JsStatementTest extends WicketTester {

	
	@Test
	public void testStatement(){
		AdvancedFlot advancedFlot = new AdvancedFlot("MyId");	
		JsStatement statement = 
			advancedFlot.statement();
		
		
		
	}
}
