package org.odlabs.wiquery.presentation.examples.ui.layout;

import org.odlabs.wiquery.core.options.IComplexOption;
import org.odlabs.wiquery.core.options.LiteralOption;

/**
 * $Id: LayoutFxSpeed.java
 * <p>
 * Bean for the fxSpeed option for the Layout
 * </p>
 * 
 * @author Julien Roche
 * @since 1.0
 */
public class LayoutFxSpeed implements IComplexOption {
	public enum DurationEnum {
		FAST		(new LiteralOption("fast")),
		NORMAL 		(new LiteralOption("normal")),
		SLOW 		(new LiteralOption("slow"));
		
		// Properties
		private LiteralOption literalParam;
		
		DurationEnum(LiteralOption literalParam){
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
	private DurationEnum durationEnumParam;
	
	/**Constructor
	 * @param integerParam Integer parameter
	 */
	public LayoutFxSpeed(Integer integerParam) {
		this(integerParam, null);
	}

	/**Constructor
	 * @param durationEnumParam DurationEnum parameter
	 */
	public LayoutFxSpeed(DurationEnum durationEnumParam) {
		this(null, durationEnumParam);
	}
	
	/**Constructor
	 * @param integerParam Integer parameter
	 * @param durationEnumParam DurationEnum parameter
	 */
	private LayoutFxSpeed(Integer integerParam, DurationEnum durationEnumParam) {
		super();
		setParam(integerParam, durationEnumParam);
	}

	/**
	 * @return the durationEnumParam
	 */
	public DurationEnum getDurationEnumParam() {
		return durationEnumParam;
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
		if(integerParam == null && durationEnumParam == null){
			throw new IllegalArgumentException("The LayoutFxSpeed must have one not null parameter");
		}
		
		CharSequence sequence = null;
		
		if(integerParam != null){
			sequence = integerParam.toString();
		}
		else if(durationEnumParam != null){
			sequence = durationEnumParam.toString();
		}
		else{
			throw new IllegalArgumentException("The LayoutFxSpeed must have one not null parameter");
		}
		
		return sequence;
	}
	
	/**Set's the DurationEnum parameter
	 * @param durationEnumParam the DurationEnum to set
	 */
	public void setDurationEnumParam(DurationEnum durationEnumParam) {
		setParam(null, durationEnumParam);
	}
	
	/**Set's the integer parameter
	 * @param integerParam Integer parameter
	 */
	public void setIntegerParam(Integer integerParam) {
		setParam(integerParam, null);
	}
	
	/**Method setting the right parameter
	 * @param integerParam integer parameter
	 * @param durationEnumParam DurationEnum parameter
	 */
	private void setParam(Integer integerParam, DurationEnum durationEnumParam) {
		this.integerParam = integerParam;
		this.durationEnumParam = durationEnumParam;
	}
}
