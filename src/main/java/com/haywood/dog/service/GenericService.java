package com.haywood.dog.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GenericService {

	
	public String nullCheck(String str){
		return str == null ? "" : str;
	}
	
	public Date convertStringToCalendar(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String convertCalendarToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
		return sdf.format(date.getTime());
	}
}
