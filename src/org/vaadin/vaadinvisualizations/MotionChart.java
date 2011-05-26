package org.vaadin.vaadinvisualizations;


import java.util.ArrayList;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VMotionChart.class)
public class MotionChart extends VisualizationComponent{


	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7782950307194498863L;

	public MotionChart(ArrayList<MotionColumn> motionColumns) {
		addColumn("string", "Entity");
		addColumn("date", "Time");
		for (MotionColumn column: motionColumns){
			addColumn(column.getColumnType(), column.getColumnName());
			
		}
		
		
	}

	
	/**
	 * Add a sector to a MotionChart chart.
	 * 
	 * @param entity
	 * @param name
	 * @param values
	 * 
	 * values should contain either a string or a double
	 */
	public void add(String entity, String time, String[] values) {

		String[] stringBarValues = new String[values.length + 2];
		stringBarValues[0] = entity;
		stringBarValues[1] = time;

		int x = 2;
		for (int i = 0; i < values.length; i++) {
			stringBarValues[x++] = (String) values[i];

		}
		// Insert into table and avoid null values
		addRow(stringBarValues);

	}

	/**
	 * Remove and item from the motion chart by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}

}
