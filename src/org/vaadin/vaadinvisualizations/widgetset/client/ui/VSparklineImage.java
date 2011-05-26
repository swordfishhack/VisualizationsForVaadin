package org.vaadin.vaadinvisualizations.widgetset.client.ui;

import com.vaadin.terminal.gwt.client.ApplicationConnection;

import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.VisualizationUtils;

import com.google.gwt.visualization.client.visualizations.ImageSparklineChart;
import com.google.gwt.visualization.client.visualizations.ImageSparklineChart.Options;


public class VSparklineImage extends VVisualizationWidget {

	/** Set the tagname used to statically resolve widget from UIDL. */
	public static final String TAGNAME = "sparklineimage";

	/** Set the CSS class name to allow styling. */
	public static final String CLASSNAME = "v-" + TAGNAME;

	/** Component identifier in UIDL communications. */
	String uidlId;

	/** Reference to the server connection object. */
	ApplicationConnection client;
	
	/** */
	ImageSparklineChart chart;

	/**
	 * The constructor should first call super() to initialize the component and
	 * then handle any initialization relevant to Vaadin.
	 */
	public VSparklineImage() {
	    // TODO Example code is extending GWT Widget so it must set a root element.
	    // Change to proper element or remove if extending another widget
		// Load the visualization api, passing the onLoadCallback to be called
		// when loading is done.
		VisualizationUtils.loadVisualizationApi(new APILoadCallback(),
				"imagesparkline");
		ApplicationConnection.getConsole().log("VSparklineImage init");
		
		// This method call of the Paintable interface sets the component
		// style name in DOM tree
		setStyleName(CLASSNAME);
	}

	protected void drawChart(AbstractDataTable data, AbstractDrawOptions options) {
		ApplicationConnection.getConsole().log(
				"VSparklineImage draw " + data.getNumberOfRows()
						+ " with options as follows" + options.toString());
		if (chart != null) {
			remove(chart);
		}
		
		chart = new ImageSparklineChart(data, (Options) options);
		//chart.addSelectHandler(new VisualizationSelectHandler(chart));
		
		VSparklineImage.this.add(chart);
	}

	/**
	 * Creates default options for this chart type.
	 * 
	 * @return
	 */
	protected Options createOptions() {
		ApplicationConnection.getConsole().log(
				"VSparklineImage createOptions");
		Options ops = Options.create();
		// Default size
		ops.setSize(400,240);
		
		return ops;
	}

}
