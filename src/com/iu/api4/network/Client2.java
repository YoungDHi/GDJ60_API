package com.iu.api4.network;

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

public class Client2 {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		//1. 서버 접속 시도
		try {
			socket = new Socket("192.168.1.125", 8282);
			System.out.println("Server 접속 성공");
			os = socket.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);

			System.out.println("원하는 번호를 입력해주세요");
			System.out.println("1. 점심메뉴 추천, 2. 저녁메뉴 추천, 3. 종료");
			int select = scanner.nextInt();
			bw.write(select+"\r\n");
			bw.flush();
			if(select == 1) {
				is = socket.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				String menu = br.readLine();
				System.out.println("점심 메뉴 : "+menu);
			} else if(select == 2) {
				is = socket.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				String menu = br.readLine();
				System.out.println("저녁 메뉴 : "+menu);
			} else {
				System.out.println("시스템을 종료합니다");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2. 1. 점심, 2. 저녁, 3. 종료
		//3. 1,2,3, 고르기
		//1번 : 서버에서 점심메뉴중 하나를 보내줌, 출력
		//2번 : 서버에서 저녁메뉴중 하나를 보내줌, 출력
		//3번 : 둘다 종료
		

	}

}
