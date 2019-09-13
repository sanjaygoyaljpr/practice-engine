package com.sanjaygoyaljpr.interfaceTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MonthTest {

	public static void main(String[] args) {
		
		try {
			Date date = new SimpleDateFormat("dd MMMM").parse("1 January");
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_MONTH, -1);
			
			String finalDate = new SimpleDateFormat("dd MMMM").format(cal.getTime());
			
			System.out.println(finalDate);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
