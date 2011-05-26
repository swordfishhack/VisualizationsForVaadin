package org.vaadin.vaadinvisualizations.widgetset.client.ui;

import com.vaadin.terminal.gwt.client.ApplicationConnection;

import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.VisualizationUtils;


import com.google.gwt.visualization.client.visualizations.MotionChart;
import com.google.gwt.visualization.client.visualizations.MotionChart.Options;



public class VMotionChart extends VVisualizationWidget {

	/** Set the tagname used to statically resolve widget from UIDL. */
	public static final String TAGNAME = "motionchart";

	/** Set the CSS class name to allow styling. */
	public static final String CLASSNAME = "v-" + TAGNAME;

	/** Component identifier in UIDL communications. */
	String uidlId;

	/** Reference to the server connection object. */
	ApplicationConnection client;
	
	/** */
	MotionChart chart;

	/**
	 * The constructor should first call super() to initialize the component and
	 * then handle any initialization relevant to Vaadin.
	 */
	public VMotionChart() {
	    // TODO Example code is extending GWT Widget so it must set a root element.
	    // Change to proper element or remove if extending another widget
		// Load the visualization api, passing the onLoadCallback to be called
		// when loading is done.
		VisualizationUtils.loadVisualizationApi(new APILoadCallback(),
				MotionChart.PACKAGE);
		ApplicationConnection.getConsole().log("VMotionChart init");
		
		// This method call of the Paintable interface sets the component
		// style name in DOM tree
		setStyleName(CLASSNAME);
	}

	protected void drawChart(AbstractDataTable data, AbstractDrawOptions options) {
		ApplicationConnection.getConsole().log(
				"VMotionChart draw " + data.getNumberOfRows()
						+ " with options as follows" + options.toString());
		if (chart != null) {
			remove(chart);
		}
		
		chart = new MotionChart(data, (Options) options);
		//chart.addSelectHandler(new VisualizationSelectHandler(chart));
		
		VMotionChart.this.add(chart);
	}

	/**
	 * Creates default options for this chart type.
	 * 
	 * @return
	 */
	protected Options createOptions() {
		ApplicationConnection.getConsole().log(
				"VMotionChart createOptions");
		Options ops = Options.create();
		ops.setSize(600,400);		
		return ops;
	}

}
