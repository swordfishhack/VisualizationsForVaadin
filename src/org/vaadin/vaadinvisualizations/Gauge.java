package org.vaadin.vaadinvisualizations;



@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VGauge.class)
public class Gauge extends VisualizationComponent{

	



	/**
	 * 
	 */
	private static final long serialVersionUID = 8878150019828721980L;

	public Gauge() {
		addColumn("string", "Label");
		addColumn("number", "Number");
		
	}

	public void add(String label, double number) {

		if (label == null) {
			return;
		}

		// Insert into table and avoid null values
		addRow(new String[] { label, Double.toString(number) });

	}
	

}
