package com.haywood.dog.forms;

import java.util.Date;
import java.util.List;

public class SessionForm {
	
	private Date sessionTime;
	
	private List<String> customerIds;
	
	private String notes;
	

	public Date getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(Date sessionTime) {
		this.sessionTime = sessionTime;
	}

	public List<String> getCustomerIds() {
		return customerIds;
	}

	public void setCustomerIds(List<String> customerIds) {
		this.customerIds = customerIds;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
