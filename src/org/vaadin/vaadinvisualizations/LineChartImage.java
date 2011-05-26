package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VLineChartImage.class)
public class LineChartImage extends VisualizationComponent{


	

	/**
	 * 
	 */
	private static final long serialVersionUID = -9186066434150075732L;

	public LineChartImage() {
		
		
	}

	public void addXAxisLabel(String xAxisLabel) {

		if (xAxisLabel == null) {
			return;
		}
		addColumn("string", xAxisLabel);
		

	}
	public void addLine(String lineName) {

		if (lineName == null) {
			return;
		}
		addColumn("number", lineName);
		

	}
	/**
	 * Add a sector to a line chart.
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
	 * Remove and item from the line chart by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}

}
