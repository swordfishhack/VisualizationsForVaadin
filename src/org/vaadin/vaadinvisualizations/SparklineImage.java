package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VSparklineImage.class)
public class SparklineImage extends VisualizationComponent{



	/**
	 * 
	 */
	private static final long serialVersionUID = 5833632209853766026L;

	public SparklineImage() {
		
		
	}

	
	public void addLine(String lineName) {

		if (lineName == null) {
			return;
		}
		addColumn("number", lineName);
		

	}
	/**
	 * Add a sector to a sparkline chart.
	 * 
	 * @param name
	 * @param parent
	 * @param tooltip
	 */
	public void add(double[] columnValues) {

		String[] stringBarValues = new String[columnValues.length];
		
		
		for (int i=0; i < columnValues.length; i++){
			
			stringBarValues[i] =  Double.toString(columnValues[i]);
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
