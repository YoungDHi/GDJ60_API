package com.iu.api.strings.ex3;

public class StringBuffer1 {

	public static void main(String[] args) {
		//Stringbuffer는 String이 아님
		StringBuffer sb = new StringBuffer("Hello"); //hello
		
		//hello + world
		sb.append("world");
		
		
		
		System.out.println(sb);
		
		//참조변수를 출력하면 toString() : 클래스명@객체주소
		//toString를 오버라이딩 했다.
		//변수에는 같은 데이터타입만 대입 가능
		String str = sb.substring(0);
		System.out.println(str);
		
		str = sb.toString();
		System.out.println(str);
		
		sb.reverse();
		System.out.println(sb);
		
		
		
		str = String.valueOf(123);
		System.out.println(str);
		
		str = 123+""; 
		
		
		
		

	}

}
