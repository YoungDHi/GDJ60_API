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

public class ServerMain {

	public static void main(String[] args) {
		
		ServerSocket ss=null;
		Socket socket = null;
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		String msg = null;
		boolean check = true;
		try {
			ss= new ServerSocket(8282);
			System.out.println("Client 접속을 기다리는 중");
			socket = ss.accept();
			System.out.println("client와 연결 성공");
			while(check) {
				is = socket.getInputStream();
				ir = new InputStreamReader(is);
				br = new BufferedReader(ir);
				msg = br.readLine();
				String student = "iu-1-20-30-40-suji-2-30-40-50";
				os = socket.getOutputStream();
				ow = new OutputStreamWriter(os);
				bw = new BufferedWriter(ow);
				if(msg.equals("1")) {
					bw.write(student+"\r\n");
					bw.flush();
				}else if(msg.substring(0, 1).equals("2")) {
					student = "iu-1-20-30-40";
					bw.write(student+"/r/n");
					bw.flush();
				}else {
					System.out.println("시스템 종료");
					check = false;
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
