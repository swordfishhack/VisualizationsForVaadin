package org.vaadin.vaadinvisualizations;

@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VOrganizationalChart.class)
public class OrganizationalChart extends VisualizationComponent{



	/**
	 * 
	 */
	private static final long serialVersionUID = 6680294787820292680L;

	public OrganizationalChart() {
		addColumn("string", "Name");
		addColumn("string", "Manager");
		addColumn("string", "Tooltip");
		setOption("size", "large");
	}


	/**
	 * Add an item to organizational chart.
	 * 
	 * @param name
	 * @param parent
	 * @param tooltip
	 */
	public void add(String name, String parent, String tooltip) {

		if (name == null) {
			return;
		}

		// Insert into table and avoid null values
		addRow(new String[] { name, parent != null ? parent : "",
				tooltip != null ? tooltip : "" });

	}

	/**
	 * Remove and item from the organizational chart by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}


	


	

}
