package com.iu.api.wrappers.ex1;

public class JuminCheck {
	
	//check1
	//주민등록번호를 받아서
	//남자인지 여자인지 출력
	public void check1(String str) {
		//str.charAt(7);
		int num1 = Integer.parseInt(str.substring(7,8));
		if(num1==1 || num1==3) {
			System.out.println("남자");
		}else {
			System.out.println("여자");
		}
		
		
	
	}
	//check2
	//주민등록번호를 받아서
	//나이를 계산해서 출력
	//3-5 : 봄
	//6-8 : 여름
	//9-11: 가을
	//12-2: 겨울
	public void check2(String str) {
		//1. 나이계산
		String y = str.substring(0,2);
		String check = str.substring(7,8);
		int year = 1900;
		
		if (check.equals("3") || check.equals("4")) {
			year = 2000;
		}
		year =year+Integer.parseInt(y);
		int age = 2023-year;
		System.out.println("Age : "+age);
		//2. 계절 출력
		String month = str.substring(2,4);
		int m = Integer.parseInt(month);
		if(m>=3 && m<=5) {
			System.out.println("계절 : 봄");
		} else if(m>=6 && m<=8) {
			System.out.println("계절 : 여름");
		} else if(m>=9 && m<=11) {
			System.out.println("계절 : 가을");
		}else {
			System.out.println("계절 : 겨울");
		}
		
		
		
	}

}
