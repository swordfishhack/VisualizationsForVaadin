package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VPieChartImage.class)
public class PieChartImage extends VisualizationComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6627206033656030716L;

	public PieChartImage() {
		addColumn("string", "Sector");
		addColumn("number", "Number");
		
	}

	public void add(String sector, double number) {

		if (sector == null) {
			return;
		}

		// Insert into table and avoid null values
		addRow(new String[] { sector, Double.toString(number) });

	}
	
	/**
	 * Remove and item from the pie chart by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}

}
