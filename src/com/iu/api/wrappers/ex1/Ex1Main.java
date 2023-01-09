package com.iu.api.wrappers.ex1;

import java.util.Scanner;

public class Ex1Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민등록번호 입력");//991223-1234567
		String str = sc.next();
		JuminCheck jc = new JuminCheck();
		jc.check1(str);
		jc.check2(str);
		JuminCheck2 jc2 = new JuminCheck2();
		jc2.check(str);
		
		

	}

}
