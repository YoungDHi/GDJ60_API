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
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		String menu = null;
		ArrayList<String> lunch = new ArrayList<>();
		lunch.add("짜장면");
		lunch.add("짬뽕");
		lunch.add("볶음밥");
		ArrayList<String> diner = new ArrayList<>();
		diner.add("피자");
		diner.add("치킨");
		diner.add("삼겹살");
		try {
			// Client접속 대기
			ss = new ServerSocket(8282);
			System.out.println("Client의 접속을 기다리는 중");
			socket = ss.accept();
			System.out.println("Client와 연결 성공");
				is = socket.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				while(true) {
					Calendar ca = Calendar.getInstance();
					Random random = new Random(ca.getTimeInMillis());

					String select = br.readLine();
					int s = Integer.parseInt(select);
					
					if(s==1) {
						menu = lunch.get(random.nextInt(lunch.size()));
					}else if(s==2) {
						menu = diner.get(random.nextInt(diner.size()));
					}else {
						System.out.println("시스템을 종료합니다");
						break;
					}
					os = socket.getOutputStream();
					ow = new OutputStreamWriter(os);
					bw = new BufferedWriter(ow);
					bw.write(menu+"\r\n");
					bw.flush();
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
