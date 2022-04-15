package com.customerPortal.CustomerManage.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity(name="customer_details")
public class CustomerDetails implements Serializable{
	
	
	private static final long serialVersionUID = -4439114469417994319L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	
	private String firstName;
	private String lastName;
	private Date dob;
	private int age;
	private String location;
	private String gender;
	private String nationality;
	
	public CustomerDetails()
	{
		
	}

	public CustomerDetails(int customerId, String firstName, String lastName, Date dob, int age, String location,
			String gender, String nationality) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.age = age;
		this.location = location;
		this.gender = gender;
		this.nationality = nationality;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	

}
