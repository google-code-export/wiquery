package org.objetdirect.wiqueryplugins.core.javascript;

import org.odlabs.wiquery.core.javascript.JsStatement;

/**
 * 
 * @author Altug Bilgin ALTINTAS
 *
 */

public class JsStatementWrapper  {
	
	private JsStatement statement;
	
	public JsStatementWrapper(JsStatement statement) {
		this.statement = statement;
	}
	
	/**
     * Gets the statement.
     * 
     * delete the ";" end the end of the render.
     * @return return pure statement
     */
    public CharSequence getStatement() {
    	CharSequence sequence =  statement.render();     	
    	// trim ";" 
    	CharSequence newSequence = sequence.subSequence(0, sequence.length()-1);    	
    	return newSequence; 	
    }

}
