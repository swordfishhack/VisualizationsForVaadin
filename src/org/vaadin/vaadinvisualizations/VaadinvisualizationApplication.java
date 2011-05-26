package org.vaadin.vaadinvisualizations;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class VaadinvisualizationApplication extends Application {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4026843589770527876L;
	private PieChart pc;
	private TextField segment;
	private TextField number;
	private TextField tooltip;
	// a holder for properties that relate to a node 
	private Item properties;
	private HashMap nodeProperties = new HashMap();
	// the selected Node
	private String selectedNode;
	

	@Override
	public void init() {
		Window w = new Window("VaadinVisualization Application");
		HorizontalLayout h;
		w.addComponent(h = new HorizontalLayout());
		h.addComponent(segment = new TextField("Segment"));
		h.addComponent(number = new TextField("Number"));
		h.addComponent(tooltip = new TextField("Tooltip"));
		h.addComponent(new Button("Add", new Button.ClickListener() {



			/**
			 * 
			 */
			private static final long serialVersionUID = -4683577178172048889L;

			public void buttonClick(ClickEvent event) {
				pc.add((String) segment.getValue(), Double.parseDouble((String) number.getValue()));
				
			}
		}));
		h.addComponent(new Button("Remove", new Button.ClickListener() {

		

			/**
			 * 
			 */
			private static final long serialVersionUID = 7568634854146933264L;

			public void buttonClick(ClickEvent event) {
				pc.remove((String) segment.getValue());
			}
		}));
		
		PieChart pc = new PieChart();
				
		pc.setSizeFull();
		
		pc.addListener(new PieChart.SelectionListener() {

			public void selectionChanged(List<String> selectedItems) {
				if (selectedItems.get(0).equalsIgnoreCase("")){
					
				
				   getMainWindow().showNotification("Node : " + selectedNode + " deselected.");
				} else {
					getMainWindow().showNotification("Node : " + selectedItems.get(0) + " selected.");
					selectedNode = selectedItems.get(0);
					
				}
			}

		});
		pc.add("Work", 7);
		pc.add("Play", 3);
		pc.add("Eat", 1.5);
		pc.add("Sleep", 6);
		pc.add("Do Vaadin", 7);
		pc.setOption("width", 600);
		pc.setOption("height", 400);
		pc.setChartAreaWidth(400);
		pc.setChartAreaHeight(200);
		pc.setChartAreaLeft(50);
		pc.setChartAreaTop(50);
		pc.setOption("title", "My Daily Activities");
		pc.setColors("red", "green", "#0000ff", "orange", "slategray");
		pc.setOption("legend", "right");
		pc.setOption("is3D", true);
		//pc.setOption("is3D", true);
		w.addWindow(createSubWindow(pc, "Pie Chart", "536px","436px"));

				
		// Add a barChart
		BarChart bc = new BarChart();
		bc.setOption("is3D", true);
				
		bc.addXAxisLabel("Year");
		bc.addBar("Expenses");
		bc.addBar("Sales");
		bc.setChartAreaWidth(400);
		bc.setChartAreaHeight(200);
		bc.setChartAreaLeft(50);
		bc.setChartAreaTop(50);
		bc.add("2004", new double[]{100,200});
		bc.add("2005", new double[]{75,100});
		bc.add("2006", new double[]{32,234});
		bc.add("2007", new double[]{25,2534});
		bc.add("2008", new double[]{2343,12});
		bc.setColors("orange", "slategray");
		bc.setSizeFull();
		//w.addComponent(bc);
		w.addWindow(createSubWindow(bc, "Bar Chart", "536px","436px"));
		
		// Add a AreaChart
		AreaChart ac = new AreaChart();
		ac.setOption("legend", "bottom");
		
		
		ac.addXAxisLabel("Year");
		ac.addArea("Expenses");
		ac.addArea("Sales");
		ac.setChartAreaWidth(400);
		ac.setChartAreaHeight(200);
		ac.setChartAreaLeft(50);
		ac.setChartAreaTop(50);
		ac.add("2004", new double[]{100,200});
		ac.add("2005", new double[]{75,100});
		ac.add("2006", new double[]{32,234});
		ac.add("2007", new double[]{25,2534});
		ac.add("2008", new double[]{2343,12});
		ac.setColors("orange", "slategray");
		ac.setSizeFull();
		//w.addComponent(ac);
		w.addWindow(createSubWindow(ac, "Area Chart", "536px","436px"));
		
		// Add a columnChart
		ColumnChart cc = new ColumnChart();
		bc.setOption("is3D", true);
		
		
		cc.addXAxisLabel("Year");
		cc.addColumn("Expenses");
		cc.addColumn("Sales");
		cc.setChartAreaWidth(400);
		cc.setChartAreaHeight(200);
		cc.setChartAreaLeft(50);
		cc.setChartAreaTop(50);
		cc.add("2004", new double[]{100,200});
		cc.add("2005", new double[]{75,100});
		cc.add("2006", new double[]{32,234});
		cc.add("2007", new double[]{25,2534});
		cc.add("2008", new double[]{2343,12});
		
		//cc.setColors("orange", "slategray");
		cc.setSizeFull();
		//w.addComponent(cc);
		w.addWindow(createSubWindow(cc, "Column Chart", "536px","436px"));
		
		/*
		// Add a gauge
		Gauge g = new Gauge();
		g.setOption("redFrom", 90);
		g.setOption("redTo", 100);
		g.setOption("yellowFrom", 75);
		g.setOption("yellowTo", 90);
		g.setOption("minorTicks", 5);
		
		g.add("Memory", 80);
		g.add("CPU", 55);
		g.add("Network", 68);
		
		
		g.setSizeFull();
		//w.addComponent(g);
		w.addWindow(createSubWindow(g, "Gauges", "536px","436px"));
		*/
		// Add a columnChart
		LineChart lc = new LineChart();
		lc.setOption("legend", "bottom");
		lc.setOption("title", "Company Performance");
		
		
		lc.addXAxisLabel("Year");
		lc.addLine("Expenses");
		lc.addLine("Sales");
		lc.setChartAreaWidth(400);
		lc.setChartAreaHeight(200);
		lc.setChartAreaLeft(50);
		lc.setChartAreaTop(50);
		lc.add("2004", new double[]{100,200});
		lc.add("2005", new double[]{75,100});
		lc.add("2006", new double[]{32,234});
		lc.add("2007", new double[]{25,2534});
		lc.add("2008", new double[]{2343,12});
		lc.setColors("orange", "slategray");
		lc.setSizeFull();
		//w.addComponent(lc);
		w.addWindow(createSubWindow(lc, "Line Chart", "536px","436px"));
		
		// Add a scatterChart
		ScatterChart sc = new ScatterChart();
		sc.setOption("titleX", "Age");
		sc.setOption("titleY", "Weight and Height");
		
		
		sc.addXAxisLabel("Age");
		sc.addPoint("Weight");
		sc.addPoint("Height");
		sc.setChartAreaWidth(400);
		sc.setChartAreaHeight(200);
		sc.setChartAreaLeft(50);
		sc.setChartAreaTop(50);
		sc.add(new double[]{6,20,110});
		sc.add(new double[]{7,25, 115});
		sc.add(new double[]{8,30,120});
		sc.add(new double[]{9,35,130});
		sc.add(new double[]{10,40, 138});
		sc.setColors("orange", "slategray", "#cc0");
		sc.setSizeFull();
		//w.addComponent(sc);
		w.addWindow(createSubWindow(sc, "Scatter Chart", "536px","436px"));
		
		// Add an annotatedTimeLine
		AnnotatedTimeLine atl = new AnnotatedTimeLine();
		atl.setOption("displayAnnotations", true);
		atl.setOption("wmode", "transparent");
		
		atl.setColors("orange", "slategray");
		atl.addLineLabel("Sold Pencils");
		atl.addLineLabel("Sold Pens");
		// a time line can have multiple entries as above 'Sold Pencils' and 'Sold Pens'
		// for each distinct entry you have to set a value for each of the above entries
		
		ArrayList<AnnotatedTimeLineEntry> timeLineEntries = new ArrayList<AnnotatedTimeLineEntry>();
		
		timeLineEntries.add(new AnnotatedTimeLineEntry(30000,"","")); // Sold Pencils
		timeLineEntries.add(new AnnotatedTimeLineEntry(40645, "", "")); // Sold Pens
							
		atl.add(new GregorianCalendar(2008,0,1), timeLineEntries);
		
		timeLineEntries = new ArrayList<AnnotatedTimeLineEntry>();
		
		timeLineEntries.add(new AnnotatedTimeLineEntry(14045,"","")); // Sold Pencils
		timeLineEntries.add(new AnnotatedTimeLineEntry(20374, "", "")); // Sold Pens
							
		atl.add(new GregorianCalendar(2008,0,2), timeLineEntries);
		timeLineEntries = new ArrayList<AnnotatedTimeLineEntry>();
		
		timeLineEntries.add(new AnnotatedTimeLineEntry(55022,"","")); // Sold Pencils
		timeLineEntries.add(new AnnotatedTimeLineEntry(50766, "", "")); // Sold Pens
							
		atl.add(new GregorianCalendar(2008,0,3), timeLineEntries);
		timeLineEntries = new ArrayList<AnnotatedTimeLineEntry>();
		
		timeLineEntries.add(new AnnotatedTimeLineEntry(75284,"","")); // Sold Pencils
		timeLineEntries.add(new AnnotatedTimeLineEntry(14334, "Out of Stock", "Ran out of stock at 4pm")); // Sold Pens
							
		atl.add(new GregorianCalendar(2008,0,4), timeLineEntries);
		timeLineEntries = new ArrayList<AnnotatedTimeLineEntry>();
				
		timeLineEntries = new ArrayList<AnnotatedTimeLineEntry>();
		timeLineEntries.add(new AnnotatedTimeLineEntry(41476,"Bought Pens","Bought 200k Pens")); // Sold Pencils
		timeLineEntries.add(new AnnotatedTimeLineEntry(66467, "", "")); // Sold Pens
							
		atl.add(new GregorianCalendar(2008,0,5), timeLineEntries);
		timeLineEntries = new ArrayList<AnnotatedTimeLineEntry>();
		
		timeLineEntries = new ArrayList<AnnotatedTimeLineEntry>();
		timeLineEntries.add(new AnnotatedTimeLineEntry(33322,"Closed Shop","Had enough of pencils business")); // Sold Pencils
		timeLineEntries.add(new AnnotatedTimeLineEntry(39463, "Pens look good", "Swapping to pens wholesale")); // Sold Pens
							
		atl.add(new GregorianCalendar(2008,2,15), timeLineEntries);
		
				
		
		
		
		atl.setSizeFull();
		//w.addComponent(atl);
		w.addWindow(createSubWindow(atl, "Annotated Time Line", "536px","436px"));
		/*
		OrganizationalChart oc = new OrganizationalChart();
		oc.setSizeFull();
		oc.setOption("size", "medium");
		oc.setOption("allowCollapse", false);
		oc.add("CEO", "", "CEO Bert Big");
		oc.add("CIO", "CEO", "CIO Charly IT");
		oc.add("CFO", "CEO", "CFO Funny Muny");
		oc.add("Strategy", "CIO", "Strategy Willy Wonder");
		
		oc.addListener(new OrganizationalChart.SelectionListener() {

			private static final long serialVersionUID = 1L;

			public void selectionChanged(List<String> selectedItems) {
				if (selectedItems.get(0).equalsIgnoreCase("")){
					
				
				   getMainWindow().showNotification("Node : " + selectedNode + " deselected.");
				} else {
					getMainWindow().showNotification("Node : " + selectedItems.get(0) + " selected.");
					selectedNode = selectedItems.get(0);
					
				}
			}

		});
		
		w.addWindow(createSubWindow(oc, "Organizational Chart", "536px","436px"));
		
		
		// Create a geomap
		GeoMap gm = new GeoMap();
		
		gm.setSizeFull();
		
		gm.add("Germany", 200, "Germany");
		gm.add("United States", 700, "USA");
		
		gm.setOption("dataMode", "regions");
		gm.setOption("width", "556px");
		gm.setOption("height", "347px");
		
		w.addWindow(createSubWindow(gm, "GeoMap", "536px","636px"));
		
		// Create an intensity map
		String[] tabs= {"Population", "Area"};
		
		IntensityMap im = new IntensityMap(tabs);
		
		im.setSizeFull();
		double[] nums ={1324,9640821};
		
		im.add("CN", nums);
		
		double[] morenums ={1133,3287263};
		
		im.add("IN", morenums);
		
		
		
		w.addWindow(createSubWindow(im, "IntensityMap", "636px","636px"));
		
		// Create a map
		Map map = new Map();
		
		map.setSizeFull();
		
		map.add(37.4232, -122.0853, "Work");
		map.add(37.4289, -122.1697, "University");
		map.setOption("showTip", true);
	
		
		
		
		w.addWindow(createSubWindow(map, "Map", "536px","436px"));
		*/
		// Create a MotionChart
/*		ArrayList<MotionColumn> mcs = new ArrayList<MotionColumn>();
		MotionColumn mc1 = new MotionColumn("number", "Sales");
		MotionColumn mc2 = new MotionColumn("number", "Expenses");
		MotionColumn mc3 = new MotionColumn("string", "Location");
		mcs.add(mc1);
		mcs.add(mc2);
		mcs.add(mc3);
		
		
		MotionChart motionChart = new MotionChart(mcs);
		
		motionChart.setSizeFull();
		motionChart.add("Apples", "1988-01-01", new String[] {"1000", "300", "East"});
		motionChart.add("Oranges", "1988-01-01", new String[] {"1150", "200", "West"});
		motionChart.add("Bananas", "1988-01-01", new String[] {"300", "250", "West"});
		motionChart.add("Apples", "1988-06-01", new String[] {"1200", "400", "East"});
		motionChart.add("Oranges", "1988-06-01", new String[] {"750", "150", "West"});
		motionChart.add("Bananas", "1988-06-01", new String[] {"788", "617", "West"});
		
		

		w.addWindow(createSubWindow(motionChart, "motionChart", "636px","636px"));*/
		
		// Humorous charts
/*		PieChart pc1 = new PieChart();
		
		pc1.setSizeFull();
		
		
		pc1.add("Doesn't work as said", 1);
		pc1.add("Duh it's working", 97);
		
		pc1.setOption("width", 700);
		pc1.setOption("height", 400);
		pc1.setOption("is3D", true);
		pc1.setOption("title", "What happens when you want to show tech support something is not working");
		pc1.setOption("titleFontSize", "18");
		w.addWindow(createSubWindow(pc1, "Pie Chart", "536px","736px"));
		
PieChart pc2 = new PieChart();
		
		pc2.setSizeFull();
		
		
		pc2.add("Anything", 100);
		pc2.add("That", 1);
		
		pc2.setOption("width", 700);
		pc2.setOption("height", 400);
		pc2.setOption("is3D", true);
		pc2.setOption("title", "Things Meat Loaf would do for love");
		pc2.setOption("titleFontSize", "18");
		pc2.setOption("pieMinimalAngle", 20);
		w.addWindow(createSubWindow(pc2, "Pie Chart", "536px","736px"));
		
PieChart pc3 = new PieChart();
		
pc3.setSizeFull();
		
		
pc3.add("give you up", 30);
pc3.add("run around and desert you", 28);
pc3.add("let you down", 15);
pc3.add("make you cry", 22);
pc3.add("say goodbye", 25);
pc3.add("tell a lie and hurt you", 12);


		
pc3.setOption("width", 700);
pc3.setOption("height", 400);
pc3.setOption("is3D", true);
pc3.setOption("title", "Rick Astley would never");
pc3.setOption("titleFontSize", "18");

		w.addWindow(createSubWindow(pc3, "Pie Chart", "536px","736px"));
		
		PieChart pc4 = new PieChart();
		
		pc4.setSizeFull();
				
		pc4.add("Love", 30);
			
		pc4.setOption("width", 700);
		pc4.setOption("height", 400);
		pc4.setOption("is3D", true);
		pc4.setOption("title", "All you need");
		pc4.setOption("titleFontSize", "18");

				w.addWindow(createSubWindow(pc4, "Pie Chart", "536px","736px"));
		
				PieChart pc5 = new PieChart();
				
				pc5.setSizeFull();
						
						
				pc5.add("Games", 3);
				pc5.add("Phone Calls", 5);

				pc5.add("Texting", 22);
				pc5.add("Clock", 36);
				pc5.add("Torch", 125);


						
				pc5.setOption("width", 700);
				pc5.setOption("height", 400);
				pc5.setOption("is3D", true);
				pc5.setOption("title", "Common Mobile Phone Uses");
				pc5.setOption("titleFontSize", "18");

						w.addWindow(createSubWindow(pc5, "Pie Chart", "536px","736px"));
						
						
						PieChart pc6 = new PieChart();
						
						pc6.setSizeFull();
								
								
						pc6.add("Surfing the internet", 3);
						pc6.add("Downloading Opera", 5);
						pc6.add("Downloading Chrome", 5);

						pc6.add("Clicked by Mistake", 10);
						pc6.add("Forced to by Large Corporation Policy", 60);
						pc6.add("Downloading Firefox", 125);


								
						pc6.setOption("width", 900);
						pc6.setOption("height", 400);
						pc6.setOption("is3D", true);
						pc6.setOption("title", "Reasons for using Internet Explorer");
						pc6.setOption("titleFontSize", "18");
						pc6.setOption("legendFontSize", 14);

								w.addWindow(createSubWindow(pc6, "Pie Chart", "536px","936px"));*/
		
		// Add a columnChart
/*		ColumnChart cccc1 = new ColumnChart();
		cccc1.setOption("is3D", true);
		cccc1.setOption("title", "Apple Computer Compatability");
		cccc1.setOption("titleY", "Compatability %");
		cccc1.setOption("width", "700");
		cccc1.setOption("height", "460");
		
		
		cccc1.addXAxisLabel("Year");
		cccc1.addColumn("Compatability");
		
		cccc1.add("iPod", new double[]{100});
		cccc1.add("iPhone", new double[]{100});
		cccc1.add("Music", new double[]{45});
		cccc1.add("Alien Ships", new double[]{62});
		cccc1.add("Useful Software", new double[]{5});
		
		cccc1.setSizeFull();
		//w.addComponent(cc);
		w.addWindow(createSubWindow(cccc1, "Column Chart", "536px","736px"));
		
		// Add a columnChart
		ColumnChart ccc2 = new ColumnChart();
		ccc2.setOption("is3D", true);
		ccc2.setOption("title", "Estmated distance between my car and the wall behind according to");
		ccc2.setOption("titleY", "Metres");
		ccc2.setOption("width", "700");
		ccc2.setOption("height", "460");
		ccc2.setOption("titleFontSize", 14);
		ccc2.setOption("legendFontSize", 12);
		ccc2.setOption("axisFontSize", 12);
		
		
		ccc2.addXAxisLabel("Metres");
		ccc2.addColumn("Distance");
		
		ccc2.add("Actual", new double[]{5});
		ccc2.add("Me", new double[]{4.5});
		ccc2.add("Male Passenger", new double[]{4});
		ccc2.add("Female Passenger", new double[]{1});
		ccc2.add("My Mum", new double[]{.5});
		
		ccc2.setSizeFull();
		//w.addComponent(cc);
		w.addWindow(createSubWindow(ccc2, "Column Chart", "536px","736px"));
		//
		// This creates a Pie Chart
		ImageChart ic = new ImageChart();
		ic.addAColumn("string", "X");
		ic.addAColumn("number", "Y");
		String[] v1 = new String[]{"January", "12"};
		ic.add("", v1);
		String[] v2 = new String[]{"February", "17"};
		ic.add("", v2);
		ic.setOption("cht", "p");
		ic.setOption("title", "Sales per Month");
		ic.setOption("chp", "0.628");
		ic.setOption("chs", "400x200");
		ic.setSizeFull();
		
		w.addWindow(createSubWindow(ic, "Image Chart", "536px","736px"));

		//
		// This creates a Radar Chart
		ImageChart ic1 = new ImageChart();
		ic1.addAColumn("number", "X");
		ic1.addAColumn("number", "Y");
		String[] vx1 = new String[]{"100", "10"};
		ic1.add("", vx1);
		String[] vx2 = new String[]{"80", "20"};
		ic1.add("", vx2);
		String[] vx3 = new String[]{"60", "30"};
		ic1.add("", vx3);
		String[] vx4 = new String[]{"30", "40"};
		ic1.add("", vx4);
		String[] vx5 = new String[]{"25", "50"};
		ic1.add("", vx5);
		String[] vx6 = new String[]{"20", "60"};
		ic1.add("", vx6);
		ic1.setOption("cht", "rs");
		ic1.setOption("chco","00FF00,FF00FF");
		ic1.setOption("chg","25.0,25.0,4.0,4.0");
		ic1.setOption("chm", "B,FF000080,0,1.0,5.0|B,FF990080,1,1.0,5.0");
		ic1.setSizeFull();
		
		w.addWindow(createSubWindow(ic1, "Radar Chart", "536px","736px"));
		
		*/

		//
		// This creates a Radar Chart
/*		ImageChart ic2 = new ImageChart();

		ic2.addAColumn("number", "Y");
		ic2.addAColumn("number", "Z");
		
		ic2.add("", new String[]{"100", "10"});
		ic2.add("", new String[]{"80", "20"});
		ic2.add("", new String[]{"60", "30"});
		ic2.add("", new String[]{"30", "40"});
		ic2.add("", new String[]{"25", "50"});
		ic2.add("", new String[]{"20", "60"});
		ic2.add("", new String[]{"10", "70"});
		
		
		ic2.setOption("cht", "rs");
		ic2.setOption("chco", "00FF00,FF00FF");
		ic2.setOption("chm", "B,FF000080,0,1.0,5.0|B,FF990080,1,1.0,5.0");


		ic2.setSizeFull();
		
		w.addWindow(createSubWindow(ic2, "Radar Chart", "536px","736px")); */
		
		// This creates a Google O Meter
/*		ImageChart ic2 = new ImageChart();

		ic2.addAColumn("number", "");
		
		
		ic2.add("", new String[]{ "20"});
		//ic2.add("", new String[]{ "40"});
		//ic2.add("", new String[]{"60"});
		
		
		
		ic2.setOption("cht", "gom");
		ic2.setOption("chco", "chco=FF0000,FF8040,FFFF00,00FF00,00FFFF,0000FF,800080");
		ic2.setOption("chxt", "x,y");
		ic2.setOption("chxl", "0:|Groovy|1:|slow|faster|crazy");
		ic2.setOption("chs", "200x200");


		ic2.setSizeFull();
		
		w.addWindow(createSubWindow(ic2, "Radar Chart", "536px","736px")); */
		// This creates a Venn Chart
/*		ImageChart ic2 = new ImageChart();

		ic2.addAColumn("number", ""); //size of chart
		ic2.addAColumn("number", ""); // size of chart
		ic2.addAColumn("number", ""); // size of chart
		ic2.addAColumn("number", ""); // intersection between A and B
		ic2.addAColumn("number", ""); // intersection between A and C
		ic2.addAColumn("number", ""); // Intersection between B and C
		ic2.addAColumn("number", ""); // Common intersection
		
		
		ic2.add("", new String[]{ "100", "80", "60", "30", "30", "30", "10"});
		
		
		
		
		ic2.setOption("cht", "v");
		
		//ic2.setOption("chs", "200x200");


		ic2.setSizeFull();
		
		w.addWindow(createSubWindow(ic2, "Venn Chart", "536px","736px")); 
		
/*		
		ImageChart icx = new ImageChart();
		icx.addAColumn("number", "Apples");
		icx.addAColumn("number", "Bananas");
		
		//icx.setOption("chs", "200,200");
		String[] vy1 = new String[]{"10", "40"};
		icx.add("", vy1);
		String[] vy2 = new String[]{"50", "60"};
		icx.add("", vy2);
		icx.setOption("cht", "bvo");
		
		icx.setOption("chds", "0,160");
		
	
		icx.setSizeFull();
		
		w.addWindow(createSubWindow(icx, "Line Chart", "536px","736px")); */
/*		ImageChart icx = new ImageChart();
		icx.setOption("chld","taped_y|sunny|Barcelona|max+25°C|min+15°C");
		
		icx.setOption("chst", "d_weather");
		
	
		icx.setSizeFull();
		
		w.addWindow(createSubWindow(icx, "Line Chart", "536px","736px")); */
		
		
/*		AreaChartImage ac = new AreaChartImage();
		ac.addXAxisLabel("Year");
		ac.addArea("Expenses");
		ac.addArea("Sales");
		ac.add("2004", new double[]{1000,900});
		ac.add("2005", new double[]{1170,1000});
		ac.add("2006", new double[]{660,600});
		ac.add("2007", new double[]{1030,1000});
		
		 
		
		ac.setOption("width", 400);
		ac.setOption("height", 240);
		ac.setOption("min", 300);
		ac.setOption("max", 1400);
		ac.setOption("title", "Yearly Expenses and Sales");
		ac.setSizeFull();
		w.addWindow(createSubWindow(ac, "Area Chart Image", "536px","736px")); 
		//
		// Add a barChart
				BarChartImage bc = new BarChartImage();
						
		bc.addXAxisLabel("Year");
		bc.addBar("Expenses");
		bc.addBar("Sales");
		bc.add("2004", new double[]{1000,400});
		bc.add("2005", new double[]{1170,460});
		bc.add("2006", new double[]{860,580});
		bc.add("2007", new double[]{1030,540});
		
		bc.setSizeFull();
		//w.addComponent(bc);
		w.addWindow(createSubWindow(bc, "Bar Chart", "536px","476px"));
		//
		// Add a Line
			LineChartImage lc = new LineChartImage();
						
		lc.addXAxisLabel("Year");
		lc.addLine("Expenses");
		lc.addLine("Sales");
		lc.add("2004", new double[]{1000,400});
		lc.add("2005", new double[]{1170,460});
		lc.add("2006", new double[]{860,580});
		lc.add("2007", new double[]{1030,540});
		
		lc.setSizeFull();
		//w.addComponent(bc);
		w.addWindow(createSubWindow(lc, "Line Chart Image", "536px","470px"));
		//
		
			PieChartImage pc = new PieChartImage();
		
		pc.setSizeFull();
		
		
		pc.add("Work", 7);
		pc.add("Play", 3);
		pc.add("Eat", 1.5);
		pc.add("Sleep", 6);
		pc.add("Do Vaadin", 7);
		pc.setOption("width", 400);
		pc.setOption("height", 400);
		pc.setOption("title", "My Daily Activities");
		//pc.setOption("is3D", true);
		w.addWindow(createSubWindow(pc, "Pie Chart", "536px","476px"));
		
		
		// Add a SparkLine
		SparklineImage sl = new SparklineImage();
						
		
		sl.addLine("Revenue");
		sl.addLine("Licences");
		sl.add(new double[]{435,132});
		sl.add(new double[]{438,131});
		sl.add(new double[]{512,137});
		sl.add(new double[]{460,142});
		sl.add(new double[]{491,140});
		sl.add(new double[]{487,139});
		
		
		sl.setOption("width", 300);
		sl.setOption("height", 300);
		sl.setOption("showAxisLines", false);
		sl.setOption("showValueLabels", false);
		sl.setOption("labelPosition", "left");
		
		sl.setSizeFull();
		//w.addComponent(bc);
		w.addWindow(createSubWindow(sl, "Sparkline Image", "536px","470px"));
		
		//
		 
		 */
		// Add a Table
		Table t = new Table();
		t.setOption("allowHtml", true);
		t.setOption("showRowNumber", true);
		
		t.addTableColumn("Name", "string");
		t.addTableColumn("Salary", "number");
		t.addTableColumn("Full Time Employee", "boolean");
		
		t.add(new String[]{"Mike", "10000", "true"});
		t.add(new String[]{"Jim", "8000", "false"});
		t.add(new String[]{"Alice", "12500", "true"});
		t.add(new String[]{"Bob", "7000", "true"});
		t.add(new String[]{"Pete", "13276", "false"});	
		
		t.setSizeFull();
		//w.addComponent(lc);
		w.addWindow(createSubWindow(t, "Table", "536px","436px"));
		
		w.getContent().setSizeFull();
		setMainWindow(w);
	}
	private Window createSubWindow(Component component, String type, String height, String width){
        Window subwindow = new Window("A subwindow showing " + type);

        // Configure the windws layout; by default a VerticalLayout
        VerticalLayout layout = (VerticalLayout) subwindow.getContent();
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setSizeFull();
        //layout.setHeight("400px");
        //layout.setWidth("400px");

        
        subwindow.setHeight(height);
       
        subwindow.setWidth(width);
        subwindow.addComponent(component);
        
        
        
        return subwindow;

	}
	


}
