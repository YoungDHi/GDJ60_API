package com.iu.api4.network.ex.servers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
	
	public void start()throws Exception {
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		StudentDAO studentDAO = new StudentDAO();
		ss= new ServerSocket(8282);
		System.out.println("Client 접속을 기다리는 중");
		socket = ss.accept();
		System.out.println("client와 연결 성공");
		
		ArrayList<StudentDTO> ar = new ArrayList<>();
		
		
		is = socket.getInputStream();
		ir = new InputStreamReader(is);
		br = new BufferedReader(ir);
		
		os = socket.getOutputStream();
		ow = new OutputStreamWriter(os);
		bw = new BufferedWriter(ow);
		boolean check = true;
		String select = null;
		while(check) {
			select = br.readLine();
			String [] s = select.split("-");
			switch(s[0]) {
			case "1":
				//1:
				select = studentDAO.makelist(ar);
				break;
				
			case "2":
				//2:iu
				//select = studentDAO.findbyname(ar, s[1]);
				
				
				break;
			case "3":
				//3:iu-4-50-72-81
				//s[1]
				//select = studentDAO.addStudent(ar,s[1]);
				break;
			case "4":
				
				
				default:
					check = false;
			 }
		}
		
		if(check) {
			bw.write(select+"\r\n");
			
		}
		
		
		
	}
}
