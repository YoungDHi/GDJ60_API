package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentInput {
	Scanner sc = new Scanner(System.in);
	
	public ArrayList search(ArrayList arr) {
		
		System.out.println("조회할 학생의 이름을 입력해주세요");
		String name=sc.next();
		for(int i=0;i<arr.size();i++) {
			
			if(name.equals(arr)) {
				
				return arr;
				
			}
			
		}
		return null;
		
	}

	public void add() {
		
		System.out.println("추가할 학생의 이름을 입력해주세요");
		String name = sc.next();
		System.out.println("추가할 학생의 번호를 입력해주세요");
		int num=sc.nextInt();
		System.out.println("추가할 학생의 국어점수를 입력해주세요");
		int kor=sc.nextInt();
		System.out.println("추가할 학생의 영어점수를 입력해주세요");
		int eng=sc.nextInt();
		System.out.println("추가할 학생의 수학점수를 입력해주세요");
		int math=sc.nextInt();
		
		
		
		
	}
	
	public void remove() {
		
		System.out.println("삭제할 학생의 이름을 입력해주세요");
		String name = sc.next();
		
		
	}
	
}
