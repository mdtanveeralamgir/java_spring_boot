package com.in28minutes.rest.webservices.resfulwebservices.filtering;

public class SomeBean {

	private String field_1;
	private String field_2;
	private String field_3;
	
	public SomeBean(String field_1, String field_2, String field_3) {
		super();
		this.field_1 = field_1;
		this.field_2 = field_2;
		this.field_3 = field_3;
	}

	public String getField_1() {
		return field_1;
	}

	public String getField_2() {
		return field_2;
	}

	public String getField_3() {
		return field_3;
	}

	@Override
	public String toString() {
		return "SomeBean [field_1=" + field_1 + ", field_2=" + field_2 + ", field_3=" + field_3 + "]";
	}
	
	
	
	
	
}
