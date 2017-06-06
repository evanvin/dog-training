package com.haywood.dog.dao;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {

	@Id
	private String id;
	
	String firstName;

	String lastName;
	
	String petName;
	
	String petDesc;
	
	String petDOB;
	
	String email;
	
	String phone;
	
	String addressOne;
	
	String addressTwo;
	
	String city;
	
	String zip;
	
	String state;
	
	Date createdDate;
	
	Boolean isActive;
	
	String notes;
	
	String service;
	
	Date graduatedDate;
	
	Boolean graduated;
	
	public Customer(){
		this.createdDate = new Date();
		this.graduated = false;
		this.graduatedDate = new Date();
		this.isActive = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Date getGraduatedDate() {
		return graduatedDate;
	}

	public void setGraduatedDate(Date graduatedDate) {
		this.graduatedDate = graduatedDate;
	}

	public Boolean getGraduated() {
		return graduated;
	}

	public void setGraduated(Boolean graduated) {
		this.graduated = graduated;
	}

		
	
	
}
