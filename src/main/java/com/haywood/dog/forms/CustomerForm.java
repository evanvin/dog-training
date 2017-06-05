package com.haywood.dog.forms;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class CustomerForm {

	@NotEmpty(message="First name is required")
	private String firstName;

	@NotEmpty(message="Last name is required")
	private String lastName;
	
	@NotEmpty(message="Pet name is required")
	private String petName;
	
	@Email(message="Email needs to be in correct format")
	private String email;
	
	@NotEmpty(message="Phone number is required")
	private String phone;
	
	private String petDesc;
	
	private String petDOB;
	
	private String notes;
	
	private String addressOne;
	
	private String addressTwo;
	
	private String city;
	
	private String zip;
	
	private String state;

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

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPetDesc() {
		return petDesc;
	}

	public void setPetDesc(String petDesc) {
		this.petDesc = petDesc;
	}

	public String getPetDOB() {
		return petDOB;
	}

	public void setPetDOB(String petDOB) {
		this.petDOB = petDOB;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "CustomerForm [firstName=" + firstName + ", lastName="
				+ lastName + ", petName=" + petName + ", email=" + email
				+ ", phone=" + phone + ", petDesc=" + petDesc + ", petDOB="
				+ petDOB + ", notes=" + notes + ", addressOne=" + addressOne
				+ ", addressTwo=" + addressTwo + ", city=" + city + ", zip="
				+ zip + ", state=" + state + "]";
	}
	
	
	
	
	
	
	
}
