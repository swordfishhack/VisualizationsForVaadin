package org.vaadin.vaadinvisualizations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;






@com.vaadin.ui.ClientWidget(org.vaadin.vaadinvisualizations.widgetset.client.ui.VAnnotatedTimeLine.class)
public class AnnotatedTimeLine extends CommonVisualizationComponent{


	


	/**
	 * 
	 */
	private static final long serialVersionUID = -1535700363714366672L;

	public AnnotatedTimeLine() {
		addColumn("date", "Date");
		
		
	}

	public void addLineLabel(String lineLabel) {

		if (lineLabel == null) {
			return;
		}
		addColumn("number", lineLabel);
		addColumn("string", lineLabel+"title");
		addColumn("string", lineLabel+"text");
		
		

	}
	

	public void add(Calendar date, ArrayList<AnnotatedTimeLineEntry> timeLineEntries) {
		
		String[] stringLineValues = new String[(timeLineEntries.size() * 3) +1];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		stringLineValues[0] =  sdf.format(date.getTime());
		
		int x = 1;
		AnnotatedTimeLineEntry atle;
		for (int i=0; i < timeLineEntries.size(); i++){
			atle = timeLineEntries.get(i);
			
			stringLineValues[x++] =  Double.toString(atle.getNumber());
			stringLineValues[x++] =  atle.getTitle();
			stringLineValues[x++] =  atle.getText();
			
			
		}
		// Insert into table and avoid null values
		addRow(stringLineValues);

	}

	/**
	 * Remove and item from the bar chart by name.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		removeMatching(name, 0);
	}

}
