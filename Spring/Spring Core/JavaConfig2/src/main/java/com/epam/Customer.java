package com.epam;

public class Customer {
	String customerName;
	String customerDepartment;
	public Customer(String customerName, String customerDepartment) {
		super();
		this.customerName = customerName;
		this.customerDepartment = customerDepartment;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerDepartment() {
		return customerDepartment;
	}
	public void setCustomerDepartment(String customerDepartment) {
		this.customerDepartment = customerDepartment;
	}
	
}
