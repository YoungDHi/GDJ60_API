package com.iu.api4.network;

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
import java.util.Calendar;
import java.util.Random;

public class Server2 {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Calendar ca = Calendar.getInstance();
		Random random = new Random(ca.getTimeInMillis());
		OutputStream os = null;
		OutputStreamWriter or = null;
		BufferedWriter bw = null;
		String menu = null;
		try {
			// Client접속 대기
			ss = new ServerSocket(8282);
			System.out.println("Client의 접속을 기다리는 중");
			socket = ss.accept();
			System.out.println("Client와 연결 성공");
			is = socket.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String select = br.readLine();
			if(select.equals("1")) {
				System.out.println("점심메뉴를 추천합니다");
				ArrayList<String> ar = new ArrayList<>();
				ar.add("짜장면");
				ar.add("짬뽕");
				ar.add("볶음밥");
				menu = ar.get(random.nextInt(ar.size()));
				os = socket.getOutputStream();
				or = new OutputStreamWriter(os);
				bw = new BufferedWriter(or);
				bw.write(menu+"\r\n");
				bw.flush();
			}else if(select.equals("2")) {
				System.out.println("저녁메뉴를 추천합니다");
				ArrayList<String> ar = new ArrayList<>();
				ar.add("피자");
				ar.add("치킨");
				ar.add("삼겹살");
				menu = ar.get(random.nextInt(ar.size()));
				os = socket.getOutputStream();
				or = new OutputStreamWriter(os);
				bw = new BufferedWriter(or);
				bw.write(menu+"\r\n");
				bw.flush();
			}else {
				System.out.println("시스템을 종료합니다");
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//1. 점심메뉴중 하나를 랜덤하게 골라서 전송
		//2. 저녁메뉴중 하나를 랜덤하게 골라서 전송
		//3. 종료

	}

}
