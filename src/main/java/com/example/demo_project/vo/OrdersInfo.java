package com.example.demo_project.vo;

public class OrdersInfo {

	private String name;

	private String productName;

	private int quantity;

	private int customerId;

	public OrdersInfo() {

	}
	
	public OrdersInfo(String name, String productName, int quantity, int customerId) {
		this.name = name;
		this.productName = productName;
		this.quantity = quantity;
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
