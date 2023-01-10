package com.iu.api2.collections.ex1;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentDAO {
	
	private StringBuffer sb;
	
	public StudentDAO() {
		this.sb=new StringBuffer();
		
		sb.append("iu-1-90-60-70-");
		sb.append("winter-2-86-84-72-");
		sb.append("suji, 3, 89 ,74, 87 ");
		sb.append("choa, 4, 71, 25, 99 ");
	}
	
	public void studentInit() {
		
		StringTokenizer st=new StringTokenizer(this.sb.toString(),"-");
		StringTokenizer st2=new StringTokenizer(this.sb.toString(),",");
		ArrayList arr = new ArrayList();
		
		int i=0;
		
		while(st.hasMoreTokens()) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setName(st.nextToken());
			studentDTO.setNum(Integer.parseInt(st.nextToken()));
			studentDTO.setKor(Integer.parseInt(st.nextToken()));
			studentDTO.setEng(Integer.parseInt(st.nextToken()));
			studentDTO.setMath(Integer.parseInt(st.nextToken()));
			arr.add(i,studentDTO);
			i++;
			while(st2.hasMoreTokens()) {
				st2.nextToken();
				studentDTO.setName(st2.nextToken());
				studentDTO.setNum(Integer.parseInt(st2.nextToken()));
				studentDTO.setKor(Integer.parseInt(st2.nextToken()));
				studentDTO.setEng(Integer.parseInt(st2.nextToken()));
				studentDTO.setMath(Integer.parseInt(st2.nextToken()));
				arr.add(i,studentDTO);
				
			}
		}
		
		System.out.println(arr);
		
		
		
	}
	

}
