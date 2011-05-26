package org.vaadin.vaadinvisualizations.widgetset.client.ui;

import com.vaadin.terminal.gwt.client.ApplicationConnection;

import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.VisualizationUtils;

import com.google.gwt.visualization.client.visualizations.Gauge;
import com.google.gwt.visualization.client.visualizations.Gauge.Options;


public class VGauge extends VVisualizationWidget {

	/** Set the tagname used to statically resolve widget from UIDL. */
	public static final String TAGNAME = "gauge";

	/** Set the CSS class name to allow styling. */
	public static final String CLASSNAME = "v-" + TAGNAME;

	/** Component identifier in UIDL communications. */
	String uidlId;

	/** Reference to the server connection object. */
	ApplicationConnection client;
	
	/** */
	Gauge chart;

	/**
	 * The constructor should first call super() to initialize the component and
	 * then handle any initialization relevant to Vaadin.
	 */
	public VGauge() {
	    // TODO Example code is extending GWT Widget so it must set a root element.
	    // Change to proper element or remove if extending another widget
		// Load the visualization api, passing the onLoadCallback to be called
		// when loading is done.
		VisualizationUtils.loadVisualizationApi(new APILoadCallback(),
				Gauge.PACKAGE);
		ApplicationConnection.getConsole().log("VGauge init");
		
		// This method call of the Paintable interface sets the component
		// style name in DOM tree
		setStyleName(CLASSNAME);
	}

	protected void drawChart(AbstractDataTable data, AbstractDrawOptions options) {
		ApplicationConnection.getConsole().log(
				"VGauge draw " + data.getNumberOfRows()
						+ " with options as follows" + options.toString());
		if (chart != null) {
			remove(chart);
		}
		
		chart = new Gauge(data, (Options) options);
		//chart.addSelectHandler(new VisualizationSelectHandler(chart));
		
		VGauge.this.add(chart);
	}

	/**
	 * Creates default options for this chart type.
	 * 
	 * @return
	 */
	protected Options createOptions() {
		ApplicationConnection.getConsole().log(
				"VGauge createOptions");
		Options ops = Options.create();
		// Default size
		ops.setSize(400, 120);
		return ops;
	}

}
