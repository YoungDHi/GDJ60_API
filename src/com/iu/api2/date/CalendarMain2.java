package com.iu.api2.date;

import java.util.Calendar;

public class CalendarMain2 {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		Calendar sample = Calendar.getInstance();
		birth.set(1993, 1, 19);
		
		sample.set(Calendar.MINUTE, sample.get(Calendar.MINUTE)+1);
		
		//현재시간을 밀리세컨즈로 변환
		long n = now.getTimeInMillis();
		long s = birth.getTimeInMillis();
		
		n = n-s;
		
		n= (n/(1000*60*60*24))/365;
		
		System.out.println("n : "+n);
		System.out.println("s : "+s);
		
		
		
		System.out.println(now.getTime());
		System.out.println(sample.getTime());
		System.out.println(birth.getTime());
	}

}
