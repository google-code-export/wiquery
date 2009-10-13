package org.odlabs.wiquery.presentation.examples.ui.layout;

import org.odlabs.wiquery.core.options.IComplexOption;
import org.odlabs.wiquery.core.options.LiteralOption;

/**
 * $Id: LayoutTogglerAlign.java
 * <p>
 * Bean for the togglerAlign_closed, togglerAlign_open option for the Layout
 * </p>
 * 
 * @author Julien Roche
 * @since 1.0
 */
public class LayoutTogglerAlign implements IComplexOption {
	public enum PositionEnum {
		BOTTOM		(new LiteralOption("bottom")),
		CENTER		(new LiteralOption("center")),
		LEFT		(new LiteralOption("left")),
		MIDDLE		(new LiteralOption("middle")),
		RIGHT 		(new LiteralOption("right")),
		TOP 		(new LiteralOption("top"));
		
		// Properties
		private LiteralOption literalParam;
		
		PositionEnum(LiteralOption literalParam){
			this.literalParam = literalParam;
		}

		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return literalParam.toString();
		}
	}
	
	// Constants
	/**	Constant of serialization */
	private static final long serialVersionUID = 3404088696595137949L;
	
	// Properties
	private Integer integerParam;
	private PositionEnum positionEnumParam;
	
	/**Constructor
	 * @param integerParam Integer parameter
	 */
	public LayoutTogglerAlign(Integer integerParam) {
		this(integerParam, null);
	}

	/**Constructor
	 * @param positionEnumParam PositionEnum parameter
	 */
	public LayoutTogglerAlign(PositionEnum positionEnumParam) {
		this(null, positionEnumParam);
	}
	
	/**Constructor
	 * @param integerParam Integer parameter
	 * @param positionEnumParam PositionEnum parameter
	 */
	private LayoutTogglerAlign(Integer integerParam, PositionEnum positionEnumParam) {
		super();
		setParam(integerParam, positionEnumParam);
	}

	/**
	 * @return the positionEnumParam
	 */
	public PositionEnum getPositionEnum() {
		return positionEnumParam;
	}
	
	/**
	 * @return the integerParam
	 */
	public Integer getIntegerParam() {
		return integerParam;
	}
	
	/* (non-Javadoc)
	 * @see org.odlabs.wiquery.core.options.IComplexOption#getJavascriptItemOptions()
	 */
	public CharSequence getJavascriptOption() {
		if(integerParam == null && positionEnumParam == null){
			throw new IllegalArgumentException("The LayoutTogglerAlign must have one not null parameter");
		}
		
		CharSequence sequence = null;
		
		if(integerParam != null){
			sequence = integerParam.toString();
		}
		else if(positionEnumParam != null){
			sequence = positionEnumParam.toString();
		}
		else{
			throw new IllegalArgumentException("The LayoutTogglerAlign must have one not null parameter");
		}
		
		return sequence;
	}
	
	/**Set's the PositionEnum parameter
	 * @param positionEnumParam the PositionEnum to set
	 */
	public void setPositionEnumParam(PositionEnum positionEnumParam) {
		setParam(null, positionEnumParam);
	}
	
	/**Set's the integer parameter
	 * @param integerParam Integer parameter
	 */
	public void setIntegerParam(Integer integerParam) {
		setParam(integerParam, null);
	}
	
	/**Method setting the right parameter
	 * @param integerParam integer parameter
	 * @param positionEnumParam DurationEnum parameter
	 */
	private void setParam(Integer integerParam, PositionEnum positionEnumParam) {
		this.integerParam = integerParam;
		this.positionEnumParam = positionEnumParam;
	}
}
