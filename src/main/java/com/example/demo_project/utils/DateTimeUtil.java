package com.example.demo_project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateTimeUtil {
	
	/**
	 * SimpleDateFormat
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String formatDateUsingDate(Date date) throws ParseException {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return sdf.format(date); 
	}
	
	public static String formatDateUsingLocalDate(LocalDate date) throws ParseException {		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return sdf.format(date); 
	}

}
