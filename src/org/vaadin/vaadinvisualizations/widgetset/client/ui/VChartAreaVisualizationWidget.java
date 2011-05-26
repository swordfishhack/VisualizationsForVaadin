package org.vaadin.vaadinvisualizations.widgetset.client.ui;

import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.ChartArea;
import com.google.gwt.visualization.client.CommonOptions;
import com.google.gwt.visualization.client.visualizations.corechart.Options;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.UIDL;

public abstract class VChartAreaVisualizationWidget extends VCommonVisualizationWidget {

	public static final String CHART_AREA_OPT_NAME_PREFIX = "chart_area_opt_";
	
	private String[] chartAreaOpNames;
	
	private String[] chartAreaOpTypes;
	
	private Object[] chartAreaOpValues;

	@Override
	public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
		// This call should be made first. Ensure correct implementation,
		// and let the containing layout manage caption, etc.
		if (client.updateComponent(this, uidl, true)) {
			return;
		}

		if (uidl.hasAttribute("chartAreaOptionNames")
				&& uidl.hasAttribute("chartAreaOptionTypes")) {
			this.chartAreaOpNames = uidl.getStringArrayAttribute("chartAreaOptionNames");
			this.chartAreaOpTypes = uidl.getStringArrayAttribute("chartAreaOptionTypes");
			this.chartAreaOpValues = new Object[chartAreaOpNames.length];
			for (int i = 0; i < chartAreaOpNames.length; i++) {
				String name = chartAreaOpNames[i];
				String type = chartAreaOpTypes[i];
				if (OPTYPE_BOOLEAN.equals(type)) {
					chartAreaOpValues[i] = new Boolean(uidl
							.getBooleanAttribute(CHART_AREA_OPT_NAME_PREFIX + name));
				} else if (OPTYPE_INT.equals(type)) {
					chartAreaOpValues[i] = new Integer(uidl
							.getIntAttribute(CHART_AREA_OPT_NAME_PREFIX + name));
				} else if (OPTYPE_DOUBLE.equals(type)) {
					chartAreaOpValues[i] = new Double(uidl
							.getDoubleAttribute(CHART_AREA_OPT_NAME_PREFIX + name));
				} else {
					chartAreaOpValues[i] = uidl.getStringAttribute(CHART_AREA_OPT_NAME_PREFIX
							+ name);
				}
				ApplicationConnection.getConsole().log(
						"VVisualizationWidget chart area option " + name + " (" + type
						+ ") = " + chartAreaOpValues[i]);
			}
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
		
		if (options instanceof Options) {
			Options coreChartOptions = (Options) options;
			coreChartOptions.setChartArea(convertChartArea());
			return coreChartOptions;
		}
		
		return options;
	}

	protected ChartArea convertChartArea() {
		ChartArea chartArea = ChartArea.create();
		if (chartAreaOpNames == null) {
			return chartArea;
		}

		for (int i = 0; i < chartAreaOpNames.length; i++) {
			String name = chartAreaOpNames[i];
			String type = chartAreaOpTypes[i];
			Object value = chartAreaOpValues[i];

			if ("height".equals(name)) {
				setChartAreaHeight(chartArea, type, value);
			} else if ("left".equals(name)) {
				setChartAreaLeft(chartArea, type, value);
			} else if ("top".equals(name)) {
				setChartAreaTop(chartArea, type, value);
			} else if ("width".equals(name)) {
				setChartAreaWidth(chartArea, type, value);
			} else {
				ApplicationConnection.getConsole().log("Name " + name +  " is invalid for chart area. Value: " + value.toString());
			}
		}
		return chartArea;
	}
	
	private void setChartAreaHeight(ChartArea chartArea, String type, Object value) {
		if (OPTYPE_DOUBLE.equals(type)) {
			ApplicationConnection.getConsole().log("DOU" + value.toString());
			chartArea.setHeight(((Double) value).doubleValue());
		} else if (OPTYPE_STRING.equals(type)) {
			ApplicationConnection.getConsole().log("STR " + value.toString());
			chartArea.setHeight(String.valueOf(value));
		} else {
			ApplicationConnection.getConsole().log("Type " + type +  " is invalid for chart area height property. Value: " + value.toString());
		}
	}

	private void setChartAreaLeft(ChartArea chartArea, String type, Object value) {
		if (OPTYPE_DOUBLE.equals(type)) {
			ApplicationConnection.getConsole().log("DOU" + value.toString());
			chartArea.setLeft(((Double) value).doubleValue());
		} else if (OPTYPE_STRING.equals(type)) {
			ApplicationConnection.getConsole().log("STR " + value.toString());
			chartArea.setLeft(String.valueOf(value));
		} else {
			ApplicationConnection.getConsole().log("Type " + type +  " is invalid for chart area left property. Value: " + value.toString());
		}
	}
	
	private void setChartAreaTop(ChartArea chartArea, String type, Object value) {
		if (OPTYPE_DOUBLE.equals(type)) {
			ApplicationConnection.getConsole().log("DOU" + value.toString());
			chartArea.setTop(((Double) value).doubleValue());
		} else if (OPTYPE_STRING.equals(type)) {
			ApplicationConnection.getConsole().log("STR " + value.toString());
			chartArea.setTop(String.valueOf(value));
		} else {
			ApplicationConnection.getConsole().log("Type " + type +  " is invalid for chart area top property. Value: " + value.toString());
		}
	}
	
	private void setChartAreaWidth(ChartArea chartArea, String type, Object value) {
		if (OPTYPE_DOUBLE.equals(type)) {
			ApplicationConnection.getConsole().log("DOU" + value.toString());
			chartArea.setWidth(((Double) value).doubleValue());
		} else if (OPTYPE_STRING.equals(type)) {
			ApplicationConnection.getConsole().log("STR " + value.toString());
			chartArea.setWidth(String.valueOf(value));
		} else {
			ApplicationConnection.getConsole().log("Type " + type +  " is invalid for chart area width property. Value: " + value.toString());
		}
	}
}
