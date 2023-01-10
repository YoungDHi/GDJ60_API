package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentDAO {
	
	private StringBuffer sb;
	private Scanner sc;
	
	public StudentDAO() {
		this.sb=new StringBuffer();
		this.sc=new Scanner(System.in);
		
		sb.append("iu-1-90-60-70-");
		sb.append("winter-2-86-84-72-");
		sb.append("suji, 3, 89 ,74, 87 ");
		sb.append("choa, 4, 71, 25, 99 ");
	}
	//학생정보삭제
	public int remove(ArrayList<StudentDTO> ar) {
		//삭제확인용 변수
		//0이면 실패, 1 이면 삭제 성공
		int result=0;
		System.out.println("학제할 이름 입력");
		String name = sc.next();
//		//ar.remve(인덱스번호)
//		for(int i=0;i<ar.size();i++) {
//			if(name.equals(ar.get(i).getName())) {
//				ar.remove(i);
//				result=1;
//				break;
//			}
//		}
		//ar.remove(Object)
		for(StudentDTO studentDTO:ar) {
			if(name.equals(studentDTO.getName())) {
				ar.remove(studentDTO);
				result=1;
				break;
			}
		}
		return result;
	}
	
	//학생정보추가
	public void add(ArrayList<StudentDTO> ar) {
		StudentDTO studentDTO = new StudentDTO();
		System.out.println("이름을 입력");
		studentDTO.setName(sc.next());
		System.out.println("번호를 입력");
		studentDTO.setNum(sc.nextInt());
		System.out.println("국어점수를 입력");
		studentDTO.setKor(sc.nextInt());
		System.out.println("영어점수를 입력");
		studentDTO.setEng(sc.nextInt());
		System.out.println("수학점수를 입력");
		studentDTO.setMath(sc.nextInt());
		studentDTO.setTotal(studentDTO.getKor()+studentDTO.getEng()+studentDTO.getMath());
		studentDTO.setAvg(studentDTO.getTotal()/3.0);
		ar.add(studentDTO);
		
		
		
	}
	//학생정보검색
	public StudentDTO search(ArrayList<StudentDTO> ar) {
		System.out.println("검색할 이름 입력");
		String name = sc.next();
		
		StudentDTO st = null;
		
		for(StudentDTO studentDTO:ar) {
			if(name.equals(studentDTO.getName())) {
				st = studentDTO;
				break;
			}
		}
		return st;
	}
	
	
	//학생정보초기화
	public ArrayList<StudentDTO> studentinit() {
		String data = this.sb.toString();
		ArrayList<StudentDTO> ar = new ArrayList<>();
		data=data.replace(" ", "-");
		data=data.replace(",", "");
		
		System.out.println(data);
		
		StringTokenizer st = new StringTokenizer(data,"-");
		while(st.hasMoreTokens()) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setName(st.nextToken());
			studentDTO.setNum(Integer.parseInt(st.nextToken()));
			studentDTO.setKor(Integer.parseInt(st.nextToken()));
			studentDTO.setEng(Integer.parseInt(st.nextToken()));
			studentDTO.setMath(Integer.parseInt(st.nextToken()));
			studentDTO.setTotal(studentDTO.getKor()+studentDTO.getEng()+studentDTO.getMath());
			studentDTO.setAvg(studentDTO.getTotal()/3.0);
			ar.add(studentDTO);
			
		}
		return ar;
	}
	

}
