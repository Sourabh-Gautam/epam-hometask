package com.epam;

public class Vendor {
	String vendorName;
	String vendorDepartment;
	public Vendor(String vendorName, String vendorDepartment) {
		super();
		this.vendorName = vendorName;
		this.vendorDepartment = vendorDepartment;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorDepartment() {
		return vendorDepartment;
	}
	public void setVendorDepartment(String vendorDepartment) {
		this.vendorDepartment = vendorDepartment;
	}
	
}
