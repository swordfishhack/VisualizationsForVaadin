package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VColumnChart.class)
public class ColumnChart extends ChartAreaVisualizationComponent{


	/**
	 * 
	 */
	private static final long serialVersionUID = 660268425750904935L;

	/**
	 * 
	 */
	

	public ColumnChart() {
		
		
	}

	public void addXAxisLabel(String xAxisLabel) {

		if (xAxisLabel == null) {
			return;
		}
		addColumn("string", xAxisLabel);
		

	}
	public void addColumn(String columnName) {

		if (columnName == null) {
			return;
		}
		addColumn("number", columnName);
		

	}
	/**
	 * Add a sector to a pie chart.
	 * 
	 * @param name
	 * @param parent
	 * @param tooltip
	 */
	public void add(String label, double[] columnValues) {

		String[] stringBarValues = new String[columnValues.length +1];
		stringBarValues[0] =  label;
		int x = 1;
		for (int i=0; i < columnValues.length; i++){
			
			stringBarValues[x++] =  Double.toString(columnValues[i]);
		}
		// Insert into table and avoid null values
		addRow(stringBarValues);

	}

	/**
	 * Remove and item from the bar chart by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}

}
