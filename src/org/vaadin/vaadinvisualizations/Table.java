package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VTable.class)
public class Table extends VisualizationComponent{



	/**
	 * 
	 */
	private static final long serialVersionUID = -7060265529960551794L;

	public Table() {
		
		
	}

	public void addTableColumn(String columnName, String columnType) {

		
		addColumn(columnType, columnName);
		

	}
	

	public void add(String[] columnValues) {

// Insert into table and avoid null values
		addRow(columnValues);

	}

	/**
	 * Remove and item from the line chart by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}

}
