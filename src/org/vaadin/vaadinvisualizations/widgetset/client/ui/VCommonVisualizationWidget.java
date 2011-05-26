package org.vaadin.vaadinvisualizations.widgetset.client.ui;

import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.CommonOptions;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.UIDL;

public abstract class VCommonVisualizationWidget extends VVisualizationWidget {

	public static final String COMMON_OPT_NAME_PREFIX = "common_opt_";
	
	public static final String COLORS = "colors";
	
	private String[] colors = null;
	
	@Override
	public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
		// This call should be made first. Ensure correct implementation,
		// and let the containing layout manage caption, etc.
		if (client.updateComponent(this, uidl, true)) {
			return;
		}
		
		if (uidl.hasAttribute(COMMON_OPT_NAME_PREFIX + COLORS)){
			ApplicationConnection.getConsole().log("VCommonVisualizationWidget data received");
			this.colors = uidl.getStringArrayAttribute(COMMON_OPT_NAME_PREFIX + COLORS);
		}
		super.updateFromUIDL(uidl, client);
	}
	
	@Override
	protected AbstractDrawOptions convertOptions(String[] opNames,
			String[] opTypes, Object[] opValues) {
		
		AbstractDrawOptions options = super.convertOptions(opNames, opTypes, opValues);
		
		if (!(options instanceof CommonOptions)){
			ApplicationConnection.getConsole().error("Unexpected options type received in VCommonVisualizationWidget");
			return options;
		}
		
		CommonOptions commonOptions = (CommonOptions)options;
		if (colors != null){
			commonOptions.setColors(colors);
		}
		return commonOptions;
	}
}
