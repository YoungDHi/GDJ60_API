package com.iu.api.strings;

public class StringStudy2 {

	public static void main(String[] args) {
		String email = "a@ bc@123@gmail.com";


		System.out.println(email.length());
		for(int i = 0 ;i < email.length();i++) {
		char em = email.charAt(i);
		
		System.out.println(i+1 + "번째 문자 : " + em);
		}
		
		System.out.println("Before Email : " + email);
		email = email.replace("@", "_");
		System.out.println("After Email : " + email);
		
	}

}
