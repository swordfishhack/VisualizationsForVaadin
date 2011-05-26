package org.vaadin.vaadinvisualizations;

import java.util.HashMap;
import java.util.Map;

import org.vaadin.vaadinvisualizations.widgetset.client.ui.VChartAreaVisualizationWidget;

import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;

public class ChartAreaVisualizationComponent extends
		CommonVisualizationComponent {

	private static final String CHART_AREA_OPT_NAME_PREFIX = VChartAreaVisualizationWidget.CHART_AREA_OPT_NAME_PREFIX;

	private Map<String, Object> chartAreaOptions = new HashMap<String, Object>();

	/**
	 * Set the chart area height.
	 * 
	 * @param value
	 */
	public void setChartAreaHeight(String value) {
		this.chartAreaOptions.put("height", value);
	}

	/**
	 * Set the chart area height.
	 * 
	 * @param value
	 */
	public void setChartAreaHeight(double value) {
		this.chartAreaOptions.put("height", value);
	}

	/**
	 * Set the chart area left.
	 * 
	 * @param value
	 */
	public void setChartAreaLeft(double value) {
		this.chartAreaOptions.put("left", value);
	}

	/**
	 * Set the chart area left.
	 * 
	 * @param value
	 */
	public void setChartAreaLeft(String value) {
		this.chartAreaOptions.put("left", value);
	}

	/**
	 * Set the chart area top.
	 * 
	 * @param value
	 */
	public void setChartAreaTop(double value) {
		this.chartAreaOptions.put("top", value);
	}

	/**
	 * Set the chart area top.
	 * 
	 * @param value
	 */
	public void setChartAreaTop(String value) {
		this.chartAreaOptions.put("top", value);
	}

	/**
	 * Set the chart area width.
	 * 
	 * @param value
	 */
	public void setChartAreaWidth(double value) {
		this.chartAreaOptions.put("width", value);
	}

	/**
	 * Set the chart area width.
	 * 
	 * @param value
	 */
	public void setChartAreaWidth(String value) {
		this.chartAreaOptions.put("width", value);
	}


	@Override
	public void paintContent(PaintTarget target) throws PaintException {
		super.paintContent(target);

		// Paint chart area options
		paintOptions(chartAreaOptions, target, CHART_AREA_OPT_NAME_PREFIX,
				"chartAreaOptionNames", "chartAreaOptionTypes");
	}
}
