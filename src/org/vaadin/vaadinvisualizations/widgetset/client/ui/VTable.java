package org.vaadin.vaadinvisualizations.widgetset.client.ui;

import com.vaadin.terminal.gwt.client.ApplicationConnection;

import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.VisualizationUtils;

import com.google.gwt.visualization.client.visualizations.Table;
import com.google.gwt.visualization.client.visualizations.Table.Options;

import com.google.gwt.visualization.client.formatters.ArrowFormat;


public class VTable extends VVisualizationWidget {
	public static final int ARROW_FORMATTER = 1;
	AbstractDataTable data;
	
	/** Set the tagname used to statically resolve widget from UIDL. */
	public static final String TAGNAME = "table";

	/** Set the CSS class name to allow styling. */
	public static final String CLASSNAME = "v-" + TAGNAME;

	/** Component identifier in UIDL communications. */
	String uidlId;

	/** Reference to the server connection object. */
	ApplicationConnection client;
	
	/** */
	Table chart;

	/**
	 * The constructor should first call super() to initialize the component and
	 * then handle any initialization relevant to Vaadin.
	 */
	public VTable() {
	    // TODO Example code is extending GWT Widget so it must set a root element.
	    // Change to proper element or remove if extending another widget
		// Load the visualization api, passing the onLoadCallback to be called
		// when loading is done.
		VisualizationUtils.loadVisualizationApi(new APILoadCallback(),
				Table.PACKAGE);
		ApplicationConnection.getConsole().log("VTable init");
		
		// This method call of the Paintable interface sets the component
		// style name in DOM tree
		setStyleName(CLASSNAME);
	}

	protected void drawChart(AbstractDataTable data, AbstractDrawOptions options) {
		ApplicationConnection.getConsole().log(
				"VTable draw " + data.getNumberOfRows()
						+ " with options as follows" + options.toString());
		if (chart != null) {
			remove(chart);
		}
		
		//createFormatter (1,1,data);
		chart = new Table(data, (Options) options);
		chart.addSelectHandler(new VisualizationSelectHandler(chart));
		
		VTable.this.add(chart);
	}

	/**
	 * Creates default options for this chart type.
	 * 
	 * @return
	 */
	protected Options createOptions() {
		ApplicationConnection.getConsole().log(
				"VTable createOptions");
		Options ops = Options.create();
		// Default size
		ops.setHeight("400px");
		ops.setWidth("400px");
		
		
		return ops;
	}
	
	protected void createFormatter(int formatType, int column, AbstractDataTable data) {
		ApplicationConnection.getConsole().log(
				"VTable createFormatter");
		if (formatType == ARROW_FORMATTER){
			ArrowFormat formatter = createFormatter();

			formatter.format((DataTable) data,column);
		    
		}
		
	}
	private ArrowFormat createFormatter() {
	    ArrowFormat.Options options = ArrowFormat.Options.create();
	    options.setBase(1.5);
	    return ArrowFormat.create(options);
	  }



}
