package com.haywood.dog.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GenericService {

	
	public String nullCheck(String str){
		return str == null ? "" : str;
	}
	
	public Calendar convertStringToCalendar(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
			return cal;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String convertCalendarToString(Calendar calendar){
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
		return sdf.format(calendar.getTime());
	}
}
