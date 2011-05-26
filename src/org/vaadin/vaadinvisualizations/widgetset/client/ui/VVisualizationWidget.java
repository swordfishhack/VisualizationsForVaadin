package org.vaadin.vaadinvisualizations.widgetset.client.ui;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.Selectable;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;

public abstract class VVisualizationWidget extends SimplePanel implements
		Paintable{

	protected static final Object OPTYPE_BOOLEAN = "boolean";

	protected static final Object OPTYPE_INT = "int";

	protected static final Object OPTYPE_DOUBLE = "double";

	protected static final Object OPTYPE_STRING = "string";
	

	public static final String OPT_NAME_PREFIX = "opt_";

	/** Component identifier in UIDL communications. */
	String uidlId;

	/** Reference to the server connection object. */
	ApplicationConnection client;

	boolean immediate = true;
	boolean initComplete = false;

	Runnable onLoadCallback;

	private String[] colNames;

	private String[] colTypes;

	private String[][] rawData;

	private String[] opNames;

	private String[] opTypes;

	private Object[] opValues;

	/**
	 * A callback for Google Visualization API load. All functions (and classes)
	 * in the Google Visualization library needs that it has been loaded. This
	 * callback is used to track when it is safe to call those functions.
	 * 
	 */
	class APILoadCallback implements Runnable {
		public void run() {
			ApplicationConnection.getConsole().log(
					"VVisualizationWidget init complete");

			initComplete = true;

			// Delayed draw
			if (rawData != null) {
				drawVisualization();
			}

		}
	}

	public class VisualizationSelectHandler extends SelectHandler {

		private Selectable selectable;

		VisualizationSelectHandler(Selectable s) {
			ApplicationConnection.getConsole().log(
					"VisualizationSelectHandler create");
			this.selectable = s;
		}

		@Override
		public void onSelect(SelectEvent event) {
			ApplicationConnection.getConsole().log(
					"Select at VisualizationSelectHandler");
			
			JsArray<Selection> selections = selectable.getSelections();
			String[] s = new String[selections.length()];
			for (int i = 0; i < s.length; i++) {
				Selection sel = selections.get(i);
				ApplicationConnection.getConsole().log(
						"Selected: " + sel.toString());
				if (sel.isRow()) {
					int r = sel.getRow();
					ApplicationConnection.getConsole().log("Selected: " + r);
					s[i] = rawData[r][0];
				}
			}
			client.updateVariable(uidlId, "selectedItems", s, immediate);
		}

	}

	public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
		// This call should be made first. Ensure correct implementation,
		// and let the containing layout manage caption, etc.
		if (client.updateComponent(this, uidl, true)) {
			return;
		}

		// Save reference to server connection object to be able to send
		// user interaction later
		this.client = client;

		// Save the UIDL identifier for the component
		uidlId = uidl.getId();

		// Read data from server
		if (uidl.hasAttribute("rowCount") && uidl.hasAttribute("colNames")
				&& uidl.hasAttribute("colTypes")) {
			ApplicationConnection.getConsole().log(
					"VVisualizationWidget data received");

			// We need to store the data until the initialization has been made
			this.rawData = readDataTableFromUIDL(uidl, uidl
					.getIntAttribute("rowCount"));
			this.colNames = uidl.getStringArrayAttribute("colNames");
			this.colTypes = uidl.getStringArrayAttribute("colTypes");
			ApplicationConnection.getConsole().log(
					"VVisualizationWidget data received " + rawData.length
							+ " rows");

		}
		if (uidl.hasAttribute("optionNames")
				&& uidl.hasAttribute("optionTypes")) {
			this.opNames = uidl.getStringArrayAttribute("optionNames");
			this.opTypes = uidl.getStringArrayAttribute("optionTypes");
			this.opValues = new Object[opNames.length];
			for (int i = 0; i < opNames.length; i++) {
				String name = opNames[i];
				String type = opTypes[i];
				if (OPTYPE_BOOLEAN.equals(type)) {
					opValues[i] = new Boolean(uidl
							.getBooleanAttribute(OPT_NAME_PREFIX + name));
				} else if (OPTYPE_INT.equals(type)) {
					opValues[i] = new Integer(uidl
							.getIntAttribute(OPT_NAME_PREFIX + name));
				} else if (OPTYPE_DOUBLE.equals(type)) {
					opValues[i] = new Double(uidl
							.getDoubleAttribute(OPT_NAME_PREFIX + name));
				} else {
					opValues[i] = uidl.getStringAttribute(OPT_NAME_PREFIX
							+ name);
				}
				ApplicationConnection.getConsole().log(
						"VVisualizationWidget option " + name + " (" + type
								+ ") = " + opValues[i]);

			}

		}

		// Draw only if initialized
		if (initComplete) {
			if (rawData != null) {
				drawVisualization();
			}
		} else {
			ApplicationConnection.getConsole().log(
					"VVisualizationWidget draw delayed until API init");
		}

	}

	/**
	 * Converts from String to ColumnType. This cannot be called before the
	 * Google API has been initialized.
	 * 
	 * @param types
	 * @return
	 */
	private ColumnType[] convertColTypes(String[] types) {
		ColumnType[] res = new ColumnType[types.length];
		for (int i = 0; i < types.length; i++) {
			res[i] = ColumnType.valueOf(types[i].toUpperCase());
		}
		return res;
	}

	/**
	 * Creates options specific to visualization type. This cannot be called
	 * before the Google API has been initialized.
	 * 
	 * @return
	 */
	protected abstract AbstractDrawOptions createOptions();

	
	/**
	 * Draws the visualization. This cannot be called before the Google API has
	 * been initialized.
	 * 
	 * @param data
	 * @param options
	 */
	protected abstract void drawChart(AbstractDataTable data,
			AbstractDrawOptions options);

	/**
	 * Convert raw data to Visualization format and draw the visualization. This
	 * cannot be called before the Google API has been initialized.
	 */
	private void drawVisualization() {
		ApplicationConnection.getConsole().log("VVisualizationWidget draw");
		AbstractDrawOptions options = convertOptions(opNames, opTypes, opValues);
		AbstractDataTable data = convertDataTable(convertColTypes(colTypes),
				colNames, rawData);
		drawChart(data, options);
	}

	/**
	 * Convert options to chart specific type.
	 * 
	 * @param opNames
	 * @param opTypes
	 * @param opValues
	 * @return
	 */
	protected AbstractDrawOptions convertOptions(String[] opNames,
			String[] opTypes, Object[] opValues) {
		AbstractDrawOptions ops = createOptions();
		if (opNames == null) {
			return ops;
		}
		for (int i = 0; i < opNames.length; i++) {
			String name = opNames[i];
			String type = opTypes[i];
			Object value = opValues[i];
			ApplicationConnection.getConsole().log("Name " + name + " Type " + type + " Value " + value);
			if (OPTYPE_BOOLEAN.equals(type)) {
				ApplicationConnection.getConsole().log("BOOL");
				ops.set(name, ((Boolean) value).booleanValue());
			} else if (OPTYPE_INT.equals(type)) {
				ApplicationConnection.getConsole().log("INT " + value.toString());
				ops.set(name, Double.valueOf(value.toString()));
			} else if (OPTYPE_DOUBLE.equals(type)) {
				ApplicationConnection.getConsole().log("DOU");
				ops.set(name, ((Double) value).doubleValue());
			}  else {
				ApplicationConnection.getConsole().log("STR " + name + " " + (String) value);
				
				ops.set(name, (String) value);

			}
		}
		return ops;
	}

	/**
	 * Converts a string table to Google DataTable. This cannot be called before
	 * the Google API has been initialized.
	 * 
	 * @param colTypes
	 *            Column types
	 * @param colNames
	 *            Names of the columns
	 * @param table
	 *            Data
	 * @return
	 */
	protected static AbstractDataTable convertDataTable(ColumnType[] colTypes,
			String[] colNames, String[][] table) {

		DataTable nd = DataTable.create();

		for (int i = 0; i < colTypes.length; i++) {
			nd.addColumn(colTypes[i], colNames[i]);
		}
		nd.addRows(table.length);
		for (int row = 0; row < table.length; row++) {
			for (int col = 0; col < table[row].length; col++) {
				if (nd.getColumnType(col) == AbstractDataTable.ColumnType.NUMBER){
					nd.setValue(row, col, Double.parseDouble(table[row][col]));
				} else if (nd.getColumnType(col) == AbstractDataTable.ColumnType.DATE){
					DateTimeFormat dtf = DateTimeFormat.getFormat("yyyy-MM-dd");
					nd.setValue(row, col, dtf.parse(table[row][col]));
					//nd.setValue(row, col, new Date(table[row][col]));
				} else if (nd.getColumnType(col) == AbstractDataTable.ColumnType.BOOLEAN){
					nd.setValue(row, col, Boolean.parseBoolean(table[row][col]));
				} else {
				nd.setValue(row, col, table[row][col]);
				}
			}
		}
		return nd;
	}

	/**
	 * Reads two dimensional table data from UIDL.
	 * 
	 * @param uidl
	 *            The UIDL parent node.
	 * @param rows
	 *            Number of rows to read.
	 * @return
	 */
	private String[][] readDataTableFromUIDL(UIDL uidl, int rows) {
		if (rows < 0) {
			return new String[0][0];
		}
		String[][] table = new String[rows][];
		for (int i = 0; i < rows; i++) {
			table[i] = uidl.getStringArrayAttribute("row-" + i);
		}
		return table;
	}

}
