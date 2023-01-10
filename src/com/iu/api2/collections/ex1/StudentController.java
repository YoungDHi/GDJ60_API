package com.iu.api2.collections.ex1;

import java.util.Scanner;

public class StudentController {
	Scanner sc = new Scanner(System.in);
	StudentDAO sDAO=new StudentDAO();
	StudentView sv=new StudentView();
	
	public void start() {
		boolean check = true;
		while(check) {
		System.out.println("원하는 숫자를 입력해주세요");
		System.out.println("1. 학생정보초기화");
		System.out.println("2. 학생정보전체조회");
		System.out.println("3. 학생정보검색조회");
		System.out.println("4. 학생정보추가");
		System.out.println("5. 학생정보삭제");
		System.out.println("6. 프로그램종료");
		int select=sc.nextInt();
		switch(select) {
		case 1:
			System.out.println("1.학생정보를 초기화합니다");
			sDAO.studentInit();
			break;
		case 2:
			System.out.println("2. 전체학생정보를 조회합니다");
			sv.view();
		case 3:
			System.out.println("3. 학생정보를 검색합니다");
			
		case 4:
			
		case 5:
			
		case 6:
			check = false;
			break;
		
		}
			
			
		}
		
		
	}

}
