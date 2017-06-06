package com.haywood.dog.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "session")
public class TrainingSession {

	@Id
	private String id;
	
	Date sessionTime;
	
	List<Customer> customers;
	
	Boolean markedComplete;
	
	String notes;
	
	Boolean isActive;
	
	
	public TrainingSession(){
		this.markedComplete = false;
		this.isActive = true;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(Date sessionTime) {
		this.sessionTime = sessionTime;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Boolean getMarkedComplete() {
		return markedComplete;
	}

	public void setMarkedComplete(Boolean markedComplete) {
		this.markedComplete = markedComplete;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
}
