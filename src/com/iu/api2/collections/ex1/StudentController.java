package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
	private Scanner sc;
	private StudentDAO sDAO;
	private StudentView studentView;
	private ArrayList<StudentDTO> ar;
	
	public StudentController () {
		sc=new Scanner(System.in);
		sDAO = new StudentDAO();
		studentView = new StudentView();
		
	}
	
	public void start() {
		boolean check = true;
		while(check) {
		System.out.println("원하는 숫자를 입력해주세요");
		System.out.println("1. 학생정보초기화");
		System.out.println("2. 학생정보전체조회");
		System.out.println("3. 학생정보검색조회");
		System.out.println("4. 학생정보추가");
		System.out.println("5. 학생정보삭제");
		System.out.println("6. 학생정보백업");
		System.out.println("7. 프로그램종료");
		int select=sc.nextInt();
		switch(select) {
		case 1:
			System.out.println("1.학생정보를 초기화합니다");
			ar = sDAO.studentInit();
			break;
		case 2:
			System.out.println("2. 전체학생정보를 조회합니다");
			studentView.view(ar);
			break;
		case 3:
			System.out.println("3. 학생정보를 검색합니다");
			StudentDTO studentDTO = sDAO.search(ar);
			if(studentDTO != null) {
				studentView.view(studentDTO);
			} else {
				System.out.println("학생정보가 없습니다.");
			}
			break;
		case 4:
			sDAO.add(ar);
			break;
		case 5:
			int i = sDAO.remove(ar);
			if(i==1) {
				System.out.println("삭제성공");
			}
			break;
		case 6:
			sDAO.backup(ar);
			break;
		case 7:
			System.out.println("종료");
			check = false;
			break;
		
		}
			
			
		}
		
		
	}

}
