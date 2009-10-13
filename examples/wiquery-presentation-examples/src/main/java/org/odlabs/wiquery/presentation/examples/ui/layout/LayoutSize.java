package org.odlabs.wiquery.presentation.examples.ui.layout;

import org.odlabs.wiquery.core.options.IComplexOption;
import org.odlabs.wiquery.core.options.LiteralOption;

/**
 * $Id: LayoutSize.java
 * <p>
 * Bean for the size option for the Layout
 * </p>
 * 
 * @author Julien Roche
 * @since 1.0
 */
public class LayoutSize implements IComplexOption {
	public enum SizeEnum {
		AUTO 		(new LiteralOption("auto"));
		
		// Properties
		private LiteralOption literalParam;
		
		SizeEnum(LiteralOption literalParam){
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
	private SizeEnum sizeEnumParam;
	
	/**Constructor
	 * @param integerParam Integer parameter
	 */
	public LayoutSize(Integer integerParam) {
		this(integerParam, null);
	}

	/**Constructor
	 * @param sizeEnumParam SizeEnum parameter
	 */
	public LayoutSize(SizeEnum sizeEnumParam) {
		this(null, sizeEnumParam);
	}
	
	/**Constructor
	 * @param integerParam Integer parameter
	 * @param sizeEnumParam SizeEnum parameter
	 */
	private LayoutSize(Integer integerParam, SizeEnum sizeEnumParam) {
		super();
		setParam(integerParam, sizeEnumParam);
	}

	/**
	 * @return the sizeEnumParam
	 */
	public SizeEnum getSizeEnumParam() {
		return sizeEnumParam;
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
		if(integerParam == null && sizeEnumParam == null){
			throw new IllegalArgumentException("The LayoutSize must have one not null parameter");
		}
		
		CharSequence sequence = null;
		
		if(integerParam != null){
			sequence = integerParam.toString();
		}
		else if(sizeEnumParam != null){
			sequence = sizeEnumParam.toString();
		}
		else{
			throw new IllegalArgumentException("The LayoutSize must have one not null parameter");
		}
		
		return sequence;
	}
	
	/**Set's the SizeEnum parameter
	 * @param sizeEnumParam the SizeEnum to set
	 */
	public void setDurationEnumParam(SizeEnum sizeEnumParam) {
		setParam(null, sizeEnumParam);
	}
	
	/**Set's the integer parameter
	 * @param integerParam Integer parameter
	 */
	public void setIntegerParam(Integer integerParam) {
		setParam(integerParam, null);
	}
	
	/**Method setting the right parameter
	 * @param integerParam integer parameter
	 * @param sizeEnumParam SizeEnum parameter
	 */
	private void setParam(Integer integerParam, SizeEnum sizeEnumParam) {
		this.integerParam = integerParam;
		this.sizeEnumParam = sizeEnumParam;
	}
}
