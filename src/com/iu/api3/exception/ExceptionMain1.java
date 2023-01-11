package com.iu.api3.exception;

import java.util.Random;

public class ExceptionMain1 {

	public static void main(String[] args) {
		String num=null;
		Random random = new Random();
		int n = random.nextInt(2);
		if(n==0) {
			num="test";
			
		}
		
		System.out.println(3/n)
		;
		
		System.out.println(num.charAt(0));
		
		
		
		System.out.println("종료합니다");

	}

}
