package org.vaadin.vaadinvisualizations;

public class MotionColumn {
	private String columnType;
	
	private String columnName;
	public MotionColumn(String columnType, String columnName) {
		super();
		this.columnType = columnType;
		this.columnName = columnName;
	}
	public String getColumnType() {
		return columnType;
	}
	public String getColumnName() {
		return columnName;
	}

}
