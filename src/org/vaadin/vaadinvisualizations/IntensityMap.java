package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VIntensityMap.class)
public class IntensityMap extends VisualizationComponent{


	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1187614258547274895L;

	public IntensityMap(String[] tabs) {
		addColumn("string", "Place");
		for (int i=0; i<tabs.length;i++){
			addColumn("number", tabs[i]);
		}
		
		
	}

	
	public void add(String place, double[] number) {

		if (place == null) {
			return;
		}
		String[] stringLineValues = new String[number.length +1];
		stringLineValues[0] = place;
		int x = 1;
		
		for (int i=0; i < number.length; i++){
			
			
			stringLineValues[x++] =  Double.toString(number[i]);
			
			
			
		}
		// Insert into table and avoid null values
		addRow(stringLineValues);
		

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
