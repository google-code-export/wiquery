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
package org.odlabs.wiquery.core.options;

import org.apache.wicket.Component;
import org.apache.wicket.model.IComponentAssignedModel;
import org.apache.wicket.model.IModel;

/**
 * $Id: $
 * <p>
 * Wraps a {@link Integer} to be generated as a JavaScript string.
 * <p>
 * Example:
 * <p>
 * The {@link Integer} <code>1</code> should be rendered as <code>1</code>
 * </p>
 * </p> </p>
 * 
 * @author Lionel Armanet
 * @author Ernesto Reinaldo Barreiro
 * @since 0.5
 */
public class IntegerOption extends AbstractOption<Integer>
{
	private static final long serialVersionUID = -5938430089917100476L;

	/**
	 * Builds a new instance of {@link IntegerOption}.
	 * 
	 * @param value
	 *            the wrapped {@link Integer}
	 */
	public IntegerOption(Integer value)
	{
		super(value);
	}

	/**
	 * Builds a new instance of {@link IntegerOption}.
	 * 
	 * @param value
	 *            the wrapped {@link Integer}
	 */
	public IntegerOption(IModel<Integer> value)
	{
		super(value);
	}

	@Override
	public String toString()
	{
		Integer value = getValue();
		return value != null ? Integer.toString(value) : null;
	}

	public IModelOption<Integer> wrapOnAssignment(Component component)
	{
		if (getModel() instanceof IComponentAssignedModel< ? >)
			return new IntegerOption(
				((IComponentAssignedModel<Integer>) getModel()).wrapOnAssignment(component));
		return this;
	}
}
