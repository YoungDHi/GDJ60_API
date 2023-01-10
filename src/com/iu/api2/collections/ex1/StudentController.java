package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
	private Scanner sc;
	//의존성
	private StudentDAO studentDAO;
	private StudentView studentView;
	private ArrayList<StudentDTO> ar;
	public StudentController() {
		sc = new Scanner(System.in);
		studentDAO = new StudentDAO();//주입
		studentView = new StudentView();//dmlwhstjdwndlq(DI)
	}

	public void start() {
		boolean check = true;
		
		while(check) {
			System.out.println("1. 학생정보초기화");
			System.out.println("2. 학생정보전체조회");
			System.out.println("3. 검색학생조회");
			System.out.println("4. 학생정보추가");
			System.out.println("5. 학생정보삭제");
			System.out.println("6. 프로그램 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ar = studentDAO.studentinit();
				break;
			case 2:
				studentView.view(ar);
				break;
			case 3:
				StudentDTO studentDTO = studentDAO.search(ar);
				if(studentDTO !=null) {
					studentView.view(studentDTO);
					
				}else {
					System.out.println("학생이 없다");
				}
				break;
			case 4:
				studentDAO.add(ar);
				break;
			case 5:
				select = studentDAO.remove(ar);
				if(select==1) {
					studentView.view("삭제 성공");
					
				}
				break;
			case 6:
				check=false;
				break;
			}
			
		}
		
		
	}
	
}
