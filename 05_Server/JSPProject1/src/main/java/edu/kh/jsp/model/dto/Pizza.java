package edu.kh.jsp.model.dto;

public class Pizza {

	
	private String name;
	private int price;
	
	public Pizza() {}
	
	
	public Pizza(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name = name;
	}

	public int getprice() {
		return price;
	}
	
	public void setPrice() {
		this.price = price;
	}
	
	
	
	
}
