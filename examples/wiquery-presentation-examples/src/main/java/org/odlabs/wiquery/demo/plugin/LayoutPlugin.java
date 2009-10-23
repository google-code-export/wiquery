package org.odlabs.wiquery.demo.plugin;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;
import org.odlabs.wiquery.core.commons.IWiQueryPlugin;
import org.odlabs.wiquery.core.commons.WiQueryResourceManager;
import org.odlabs.wiquery.core.javascript.JsQuery;
import org.odlabs.wiquery.core.javascript.JsStatement;
import org.odlabs.wiquery.ui.commons.WiQueryUIPlugin;
import org.odlabs.wiquery.ui.draggable.DraggableJavaScriptResourceReference;
import org.odlabs.wiquery.ui.resizable.ResizableJavaScriptResourceReference;

@WiQueryUIPlugin
public class LayoutPlugin extends WebMarkupContainer implements IWiQueryPlugin {

	public enum LayoutPosition {
		EAST,
		NORTH,
		SOUTH,
		WEST,
		CENTER;

		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	public LayoutPlugin(String id) {
		super(id);
	}

	public void contribute(WiQueryResourceManager wiQueryResourceManager) {
		wiQueryResourceManager.addJavaScriptResource(DraggableJavaScriptResourceReference.get());
		wiQueryResourceManager.addJavaScriptResource(ResizableJavaScriptResourceReference.get());
		wiQueryResourceManager.addCssResource(LayoutPlugin.class, "jquery.layout.css");
		wiQueryResourceManager.addJavaScriptResource(LayoutPlugin.class, "jquery.layout.min.js");
	}

	public JsStatement statement() {
		return new JsQuery(this).$().chain("layout", "{ applyDefaultStyles: true }");
	}
	
	public void add(Component component, LayoutPosition layoutPosition) {
		component.add(new AttributeModifier("class", true, new Model<String>("ui-layout-" + layoutPosition)));
		this.add(component);
	}

}
