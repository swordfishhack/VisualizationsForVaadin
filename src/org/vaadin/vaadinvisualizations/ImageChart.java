package org.vaadin.vaadinvisualizations;



@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VImageChart.class)
public class ImageChart extends VisualizationComponent{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 384703639683556031L;

	/**
	 * Create a new Image Chart
	 */
	

	public ImageChart() {
		
		
	}

	public void addAColumn(String columnType, String columnName) {

		
		addColumn(columnType, columnName);
		

	}
	
	/**
	 * Add values for a particular label
	 * 
	 * @param label
	 * @param areaValues
	 * 
	 */
	public void add(String label, String[] values) {
		
		addRow(values);

	}

	/**
	 * Remove and item from the Image chart by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}

}
