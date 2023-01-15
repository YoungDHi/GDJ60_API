package com.iu.api4.network.ex.servers2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentDAO {
	
	private String result;
	
	//학생추가
	public StudentDTO add(String data) {
		StudentDTO studentDTO = new StudentDTO();
		
		data = data.substring(2);
		String [] add = data.split("-");
		studentDTO.setName(add[0]);
		studentDTO.setNum(Integer.parseInt(add[1]));
		studentDTO.setKor(Integer.parseInt(add[2]));
		studentDTO.setEng(Integer.parseInt(add[3]));
		studentDTO.setMath(Integer.parseInt(add[4]));
		studentDTO.setTotal(studentDTO.getKor()+studentDTO.getEng()+studentDTO.getMath());
		studentDTO.setAvg(studentDTO.getTotal()/3.0);
		return studentDTO;
		
	}
	
	public String makeList(StudentDTO studentDTO) {
		
		StringBuffer sb = new StringBuffer();
		sb.append(studentDTO.getName());
		sb.append("-");
		sb.append(studentDTO.getNum());
		sb.append("-");
		sb.append(studentDTO.getKor());
		sb.append("-");
		sb.append(studentDTO.getEng());
		sb.append("-");
		sb.append(studentDTO.getMath());
		sb.append("-");
		sb.append(studentDTO.getTotal());
		sb.append("-");
		sb.append(studentDTO.getAvg());
		sb.append("-");
		
		result = sb.toString();
		return result;
	}
	
	public String makeList(ArrayList<StudentDTO> ar) {
		
		StringBuffer sb = new StringBuffer();
		for(StudentDTO studentDTO:ar) {
			sb.append(studentDTO.getName());
			sb.append("-");
			sb.append(studentDTO.getNum());
			sb.append("-");
			sb.append(studentDTO.getKor());
			sb.append("-");
			sb.append(studentDTO.getEng());
			sb.append("-");
			sb.append(studentDTO.getMath());
			sb.append("-");
			sb.append(studentDTO.getTotal());
			sb.append("-");
			sb.append(studentDTO.getAvg());
			sb.append("-");
		}
		result = sb.toString();
		result = result.substring(0,result.length()-1);
		
		return result;
	}
	
	//초기화
	public ArrayList<StudentDTO> init() throws Exception{
		
		ArrayList<StudentDTO> ar = new ArrayList<>();
		
		File file = new File("C:\\fileTest","123.txt");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		boolean check = true;
		while(check) {
			String s = br.readLine();
			if(s==null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(s,"-");
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
