package com.iu.api4.network.ex.servers2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class StudentController {
	private ServerSocket ss;
	private Socket socket;
	public void start() throws Exception{
		ss=new ServerSocket(8282);
		System.out.println("Client 접속을 기다리는 중");
		socket = ss.accept();
		System.out.println("Client와 연결 성공");
		
		StudentDAO studentDAO = new StudentDAO();
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;

		ArrayList<StudentDTO> ar = studentDAO.init();
		System.out.println("학생정보초기화완료");
		
		is = socket.getInputStream();
		ir = new InputStreamReader(is);
		br = new BufferedReader(ir);
		
		os = socket.getOutputStream();
		ow = new OutputStreamWriter(os);
		bw = new BufferedWriter(ow);
		boolean check = true;
		String name = null;
		while(check) {
			boolean check1 = true;
			String select = br.readLine();
			String [] s = select.split(":");
			
			switch(s[0]) {
			case "1":
				select = studentDAO.makeList(ar);
				break;
			case "2":
				//2. iu
				
				name = select.substring(2);
				
				
				for(StudentDTO studentDTO:ar) {
					
					if(name.toUpperCase().equals(studentDTO.getName().toUpperCase())) {
						select = studentDAO.makeList(studentDTO);
						break;
					} else {
						select = "no data";
					}
					
				}
				break;
			case "3":
				StudentDTO studentDTO = new StudentDTO();
				studentDTO = studentDAO.add(select);
				ar.add(studentDTO);
				select = "추가 성공";
				break;
			case "4":
				//4:su
				name = select.substring(2);
				int i=0;
				for(StudentDTO studentDTO1:ar) {
					if(name.toUpperCase().equals(studentDTO1.getName().toUpperCase())) {
						ar.remove(studentDTO1);
						i=1;
						break;
					}
				}
				if(i == 1) {
					select = "삭제 성공";
				} else {
					select = "삭제할 정보가 없습니다";
				}
				break;
			default:
				check = false;
				break;
			}
			if(check) {
				bw.write(select+"\r\n");
				bw.flush();
			}
		}
		
		
		
		
		
		
	}

}
