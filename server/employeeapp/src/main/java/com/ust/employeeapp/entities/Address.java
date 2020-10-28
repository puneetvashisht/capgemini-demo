package com.ust.employeeapp.entities;

public class Address {
	
	int houseNumber;
	String locality;
	String city;
	
	
	public Address() {
		super();
	}


	public Address(int houseNumber, String locality, String city) {
		super();
		this.houseNumber = houseNumber;
		this.locality = locality;
		this.city = city;
	}


	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", locality=" + locality + ", city=" + city + "]";
	}
	
	

}
