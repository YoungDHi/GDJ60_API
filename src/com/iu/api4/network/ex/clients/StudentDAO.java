package com.iu.api4.network.ex.clients;

import java.util.Scanner;

public class StudentDAO {
	
	private Scanner scanner = new Scanner(System.in);
	
	public String add() {
		
		
		
		System.out.println("추가할 이름을 입력해주세요");
		String name = scanner.next();
		System.out.println("추가할 번호를 입력해주세요");
		int num = scanner.nextInt();
		System.out.println("국어점수를 입력해주세요");
		int Kor = scanner.nextInt();
		System.out.println("영어점수를 입력해주세요");
		int Eng = scanner.nextInt();
		System.out.println("수학점수를 입력해주세요");
		int Math = scanner.nextInt();
		
		name = name+"-"+num+"-"+Kor+"-"+Eng+"-"+Math;
		return name;
	}
	public String remove() {
		
		System.out.println("제거할 이름을 검색해주세요");
		String name = scanner.next();
		return name;
	}
}
