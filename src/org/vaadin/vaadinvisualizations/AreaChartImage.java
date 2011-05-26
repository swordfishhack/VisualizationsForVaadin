package org.vaadin.vaadinvisualizations;



@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VAreaChartImage.class)
public class AreaChartImage extends VisualizationComponent{


	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8155341285517582831L;

	/**
	 * Create a new Area Chart
	 */
	

	public AreaChartImage() {
		
		
	}
	public void addXAxisLabel(String xAxisLabel) {

		if (xAxisLabel == null) {
			return;
		}
		addColumn("string", xAxisLabel);
		

	}

	public void addArea(String areaName) {

		if (areaName == null) {
			return;
		}
		addColumn("number", areaName);
		

	}
	/**
	 * Add values for a particular label
	 * 
	 * @param label
	 * @param areaValues
	 * 
	 */
	public void add(String label, double[] areaValues) {

		String[] stringAreaValues = new String[areaValues.length +1];
		stringAreaValues[0] =  label;
		int x = 1;
		for (int i=0; i < areaValues.length; i++){
			
			stringAreaValues[x++] =  Double.toString(areaValues[i]);
		}
		// Insert into table and avoid null values
		addRow(stringAreaValues);

	}

	/**
	 * Remove and item from the Area chart by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}

}
