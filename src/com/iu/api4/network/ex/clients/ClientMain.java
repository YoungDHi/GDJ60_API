package com.iu.api4.network.ex.clients;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Socket socket = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		StudentController sc = new StudentController();
		String data = null;
		boolean check = true;
		String result = null;
		try {
			socket = new Socket("192.168.1.125", 8282);
			System.out.println("Server 접속 성공");
			os = socket.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			
			while(check) {
				System.out.println("원하는 번호를 입력해주세요");
				System.out.println("1. 전체학생정보, 2. 학생정보검색, 3. 학생정보추가, 4. 학생정보삭제, 5. 시스템종료");
				int select = scanner.nextInt();	
				switch(select) {
				case 1:
					bw.write(select+"\r\n");
					bw.flush();
					is = socket.getInputStream();
					ir = new InputStreamReader(is);
					br = new BufferedReader(ir);
					data ="1. "+br.readLine();
					sc.start(data);				
					break;
				case 2:
					System.out.println("학생의 이름을 검색해주세요");
					String name = scanner.next();
					bw.write("2."+name+"\r\n");
					bw.flush();
					is = socket.getInputStream();
					ir = new InputStreamReader(is);
					br = new BufferedReader(ir);
					data ="2. "+br.readLine();
					
					sc.start(data);
					break;
				case 3:
					result = sc.start(select+"");
					result = select+result;
					bw.write("3."+result+"\r\n");
					bw.flush();
					break;
				case 4:
					
					result = sc.start(select+"");
					result = select+result;
					bw.write("4."+result+"\r\n");
					bw.flush();
					
					
					break;
				default:
					bw.write(select+"\r\n");
					bw.flush();
					System.out.println("시스템 종료");
					check = false;
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
