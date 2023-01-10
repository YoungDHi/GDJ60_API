package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentDAO {
	
	private StringBuffer sb;
	private Scanner sc;
	
	public StudentDAO() {
		this.sb=new StringBuffer();
		sc=new Scanner(System.in);
		sb.append("iu-1-90-60-70-");
		sb.append("winter-2-86-84-72-");
		sb.append("suji, 3, 89 ,74, 87 ");
		sb.append("choa, 4, 71, 25, 99 ");
	}
	
	
	
	//5. 학생정보삭제
	public int remove(ArrayList<StudentDTO> ar) {
		int i = 0;
		System.out.println("삭제할 학생의 이름을 입력해주세요");
		String name = sc.next().toUpperCase();
		for(StudentDTO studentDTO:ar) {
			if(name.equals(studentDTO.getName().toUpperCase())) {
				ar.remove(studentDTO);
				i=1;
				break;
			}
		}
		return i;
	}
	//4. 학생정보추가
	public void add(ArrayList<StudentDTO> ar) {
		StudentDTO studentDTO = new StudentDTO();
		System.out.println("추가할 학생의 정보를 입력해주세요");
		System.out.println("학생 이름 입력");
		studentDTO.setName(sc.next());
		System.out.println("번호 입력");
		studentDTO.setNum(sc.nextInt());
		System.out.println("국어 점수 입력");
		studentDTO.setKor(sc.nextInt());
		System.out.println("영어 점수 입력");
		studentDTO.setEng(sc.nextInt());
		System.out.println("수학 점수 입력");
		studentDTO.setMath(sc.nextInt());
		studentDTO.setTotal(studentDTO.getKor()+studentDTO.getEng()+studentDTO.getMath());
		studentDTO.setAvg(studentDTO.getTotal()/3.0);
		ar.add(studentDTO);
	}
	//3. 학생정보검색
	public StudentDTO search(ArrayList<StudentDTO> ar) {
		System.out.println("검색할 학생의 이름을 입력해주세요");
		String name = sc.next().toUpperCase();
		StudentDTO oneDTO = null;
		for(StudentDTO studentDTO:ar) {
			if(name.equals(studentDTO.getName().toUpperCase())) {
				oneDTO = studentDTO;
				break;
			}
				
		}
		return oneDTO;
	}
	
	//1. 학생정보 초기화
	public ArrayList<StudentDTO> studentInit() {
		String data = this.sb.toString();
		data = data.replace(" ", "-");
		data = data.replace(",", "");
		
		ArrayList<StudentDTO> ar = new ArrayList();
		StringTokenizer st = new StringTokenizer(data,"-");
		
		while(st.hasMoreTokens()) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setName(st.nextToken());
			studentDTO.setNum(Integer.parseInt(st.nextToken()));
			studentDTO.setKor(Integer.parseInt(st.nextToken()));
			studentDTO.setEng(Integer.parseInt(st.nextToken()));
			studentDTO.setMath(Integer.parseInt(st.nextToken()));
			studentDTO.setTotal(studentDTO.getKor()+studentDTO.getEng()+studentDTO.getMath());
			studentDTO.setAvg(studentDTO.getTotal()/3);
			ar.add(studentDTO);
		}
		return ar;
	}
	
}	
		
		
		
		
	
	


