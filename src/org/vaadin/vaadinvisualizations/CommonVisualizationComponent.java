package org.vaadin.vaadinvisualizations;

import java.util.Map;

import org.vaadin.vaadinvisualizations.widgetset.client.ui.VCommonVisualizationWidget;

import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;

public class CommonVisualizationComponent extends VisualizationComponent {

	private static final String COMMON_OPT_NAME_PREFIX = VCommonVisualizationWidget.COMMON_OPT_NAME_PREFIX;
	private static final String COLORS =  VCommonVisualizationWidget.COLORS;
	private String[] colors = null;
	
	/**
	 * The colors to use for the chart elements. 
	 * 
	 * @param colors An array of strings, where each element is an HTML color string
	 */
	public void setColors(String... colors){
		this.colors = colors;
	}
	
	@Override
	protected void paintOptions(Map<String, Object> ops, PaintTarget target, String attributeNamePrefix, String optionNames, String optionTypes)
		throws PaintException {
		
		if (colors != null){
			target.addAttribute(COMMON_OPT_NAME_PREFIX + COLORS, colors);
		}
		super.paintOptions(ops, target, attributeNamePrefix, optionNames, optionTypes);
	}
}
