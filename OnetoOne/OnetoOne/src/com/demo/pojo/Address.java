package com.demo.pojo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Address
 *
 */
@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int addressid;
	private String city;
	private int zipcode;
	private int phone;
	
	
	//@JoinColumn(name="employeeid")
	private Employee emp;
	
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Address() {
		super();
	}

	public int getId() {
		return addressid;
	}

	public void setId(int id) {
		this.addressid = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", city=" + city + ", zipcode=" + zipcode + ", phone=" + phone
				+ ", emp=" + emp + "]";
	}

	
   
}
