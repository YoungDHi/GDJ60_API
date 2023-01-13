package com.iu.api4.network.ex.clients;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentController {

	public String start(String data) {
		int select = Integer.parseInt(data.substring(0, 1));
		data = data.substring(3);
		ArrayList<StudentDTO> ar = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(data,"-");
		StudentView sv = new StudentView();
		StudentDTO studentDTO = new StudentDTO();
		StudentDAO studentDAO = new StudentDAO();
		String result = null;
		while(st.hasMoreTokens()) {
			studentDTO = new StudentDTO();
			studentDTO.setName(st.nextToken());
			studentDTO.setNum(Integer.parseInt(st.nextToken()));
			studentDTO.setKor(Integer.parseInt(st.nextToken()));
			studentDTO.setEng(Integer.parseInt(st.nextToken()));
			studentDTO.setMath(Integer.parseInt(st.nextToken()));
			studentDTO.setTotal(studentDTO.getKor()+studentDTO.getEng()+studentDTO.getMath());
			studentDTO.setAvg(studentDTO.getTotal()/3);
			ar.add(studentDTO);
		}
			switch(select) {
				case 1:
					System.out.println("전체학생정보를 출력합니다");
					sv.view(ar);
					break;
				case 2:
					System.out.println("검색한 학생의 정보를 출력합니다");
					sv.view(studentDTO);
					break;
				case 3:
					result = studentDAO.add();
					break;
				case 4:
					result = studentDAO.remove();
					
					break;
				default:
					
					break;
			}
		return result;
	
	}
}