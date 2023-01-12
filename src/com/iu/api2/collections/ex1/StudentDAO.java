package com.iu.api2.collections.ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	//6. 학생정보백업
	public File backup(ArrayList<StudentDTO> ar) {
		Calendar ca = Calendar.getInstance();
		long n = ca.getTimeInMillis();
		File file = new File("C:\\fileTest\\",n+".txt");
		FileWriter fw = null;
			try {
				fw = new FileWriter(file, true);
				for(StudentDTO studentDTO:ar) {
					String name = studentDTO.getName();
					int num = studentDTO.getNum();
					int kor = studentDTO.getKor();
					int eng = studentDTO.getEng();
					int math = studentDTO.getMath();			
				fw.write(name+"-"+num+"-"+kor+"-"+eng+"-"+math+"\r\n");
				}
				fw.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		System.out.println("백업완료");
		return file;
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
		
		//File f = new File("C:\\fileTest","student.txt");
		File file = new File("C:\\fileTest");
		String[] files = file.list();
		long max = 0;
		for(String filename:files) {
			filename=filename.substring(0, filename.lastIndexOf("."));
			long n= Long.parseLong(filename);
			
			if(n>max) {
				max=n;
			}
		}
		
		
		
		File f = new File("C:\\fileTest",max+".txt");
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<StudentDTO> ar = new ArrayList();
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String data=null;
		while((data=br.readLine()) !=null) {
			data = data.replace(" ", "-");
			data = data.replace(",", "");
			StringTokenizer st = new StringTokenizer(data,"-");			
			
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
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		return ar;
	}
}	
		
		
		
		
	
	


