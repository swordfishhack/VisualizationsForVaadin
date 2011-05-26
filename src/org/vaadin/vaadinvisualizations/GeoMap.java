package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VGeoMap.class)
public class GeoMap extends VisualizationComponent{


	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1187614258547274895L;

	public GeoMap() {
		addColumn("string", "Place");
		addColumn("number", "Number");
		addColumn("string", "HoverText");
		
		
	}

	
	public void add(String place, double number, String hoverText) {

		if (place == null) {
			return;
		}

		// Insert into table and avoid null values
		addRow(new String[] { place, Double.toString(number), hoverText });

	}
	
	/**
	 * Remove and item from the geomap by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}


}
