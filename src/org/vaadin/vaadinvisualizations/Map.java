package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VMap.class)
public class Map extends VisualizationComponent{


	

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7234375706930933466L;

	public Map() {
		
		
			addColumn("number", "Lat");
			addColumn("number", "Lon");
			addColumn("string", "Name");
		
		
		
	}

	
	public void add(double lat, double lon, String name) {

		
		// Insert into table and avoid null values
		addRow(new String[] {Double.toString(lat), Double.toString(lon), name });
		

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
