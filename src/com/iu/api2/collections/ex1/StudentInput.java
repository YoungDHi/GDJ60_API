package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentInput {
	
	public ArrayList search(ArrayList arr) {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회할 학생의 이름을 입력해주세요");
		String name=sc.next();
		for(int i=0;i<arr.size();i++) {
			
			if(name.equals(arr)) {
				
				return arr;
				
			}
			
		}
		return null;
		
	}

}
