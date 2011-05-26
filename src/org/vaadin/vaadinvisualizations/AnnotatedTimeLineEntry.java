package org.vaadin.vaadinvisualizations;

public class AnnotatedTimeLineEntry {
	public AnnotatedTimeLineEntry(double number, String title, String text) {
		super();
		this.number = number;
		this.title = title;
		this.text = text;
	}
	double number;
	String title;
	String text;
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
