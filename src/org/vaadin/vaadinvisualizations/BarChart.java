package org.vaadin.vaadinvisualizations;




@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VBarChart.class)
public class BarChart extends ChartAreaVisualizationComponent{



	/**
	 * 
	 */
	private static final long serialVersionUID = 3748495958858464672L;

	public BarChart() {
		//addColumn("string", "Sector");
		//addColumn("number", "Number");
		
	}

	public void addXAxisLabel(String xAxisLabel) {

		if (xAxisLabel == null) {
			return;
		}
		addColumn("string", xAxisLabel);
		

	}
	public void addBar(String barName) {

		if (barName == null) {
			return;
		}
		addColumn("number", barName);
		

	}
	/**
	 * Add a sector to a pie chart.
	 * 
	 * @param name
	 * @param parent
	 * @param tooltip
	 */
	public void add(String label, double[] barValues) {

		String[] stringBarValues = new String[barValues.length +1];
		stringBarValues[0] =  label;
		int x = 1;
		for (int i=0; i < barValues.length; i++){
			
			stringBarValues[x++] =  Double.toString(barValues[i]);
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
