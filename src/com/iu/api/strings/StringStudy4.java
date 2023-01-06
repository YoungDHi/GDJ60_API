package com.iu.api.strings;

public class StringStudy4 {

	public static void main(String[] args) {
		String str = "StarWars";
		
		String result = str.substring(4);
		
		System.out.println(result);
		
		result = str.substring(4,6);
		
		System.out.println(result);
		
		str = "newssdtest@naver.com";
		
		//int idx = str.indexOf("@");
		
		result = str.substring(str.indexOf("@")+1);
		
		System.out.println(result);
		
		
		
	}

}
