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
import java.util.Scanner;

public class Server1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		ServerSocket ss=null;
		Socket socket = null;
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		try {
			ss = new ServerSocket(8282);
			System.out.println("Client 접속을 기다리는 중");
			socket = ss.accept();
			System.out.println("client와 연결 성공");
			while(true) {
				is = socket.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
			
				String msg = br.readLine();
				if(msg.toUpperCase().equals("Q")) {
					System.out.println("종료되었습니다");
					break;
				}
				System.out.println("Client : "+msg);
				System.out.println("Client로 보낼 메세지 입력");
				msg = scanner.next();
				os = socket.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				bw.write(msg+"\r\n");
				bw.flush();
			
				if(msg.toUpperCase().equals("Q")) {
					System.out.println("종료되었습니다");
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
			br.close();
			ir.close();
			is.close();
			bw.close();
			ow.close();
			os.close();
			socket.close();
			ss.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
