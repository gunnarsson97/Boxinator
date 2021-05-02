package com.example.restapi;

public class Table {

	private String name;
	private String weight;
	private String color;
	private String country;

	public Table() {
	}

	public Table(String name, String weight, String color, String country) {
		this.name = name;
		this.weight = weight;
		this.color = color;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public String getWeight() {
		return weight;
	}

	public String getColor() {
		return color;
	}
	
	public String getCountry() {
		return country;
	}
}