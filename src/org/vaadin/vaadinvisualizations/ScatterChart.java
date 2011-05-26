package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VScatterChart.class)
public class ScatterChart extends ChartAreaVisualizationComponent{



	/**
	 * 
	 */
	private static final long serialVersionUID = -2156717134769267829L;

	public ScatterChart() {
		
		
	}

	public void addXAxisLabel(String xAxisLabel) {

		if (xAxisLabel == null) {
			return;
		}
		addColumn("number", xAxisLabel);
		

	}
	public void addPoint(String pointName) {

		if (pointName == null) {
			return;
		}
		addColumn("number", pointName);
		

	}
	/**
	 * Add a sector to a pie chart.
	 * 
	 * @param name
	 * @param parent
	 * @param tooltip
	 */
	public void add(double[] pointValues) {

		String[] stringPointValues = new String[pointValues.length];

		for (int i=0; i < pointValues.length; i++){
			
			stringPointValues[i] =  Double.toString(pointValues[i]);
		}
		// Insert into table and avoid null values
		addRow(stringPointValues);

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
