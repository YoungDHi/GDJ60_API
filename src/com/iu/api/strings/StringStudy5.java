package com.iu.api.strings;

public class StringStudy5 {

	public static void main(String[] args) {
		String str="apple# Apple, aPPle# appLe";//전처리 : 기준을 가지고 하나로 바꾸는것
		str = str.replace(",", "#");
		//str = str.replace(" ","");
		String [] result = str.split("#");//파싱(parsing) : 하나의 문자열을 여러개의 문자열로 나누는 작업
		
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i].trim().toLowerCase());
		}
		

	}

}
