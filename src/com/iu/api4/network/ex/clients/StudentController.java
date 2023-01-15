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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentController {

	public void start() {
		Scanner scanner = new Scanner(System.in);
		
		Socket socket = null;
		
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		String data = null;
		
		boolean check = true;
		try {
			socket = new Socket("127.0.0.1", 8282);
			System.out.println("Server 접속 성공");
			os = socket.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			
			is = socket.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			StudentDTO studentDTO = new StudentDTO();
			StudentView sv = new StudentView();
			StudentDAO studentDAO = new StudentDAO();
			String result = null;
			
			while(check) {
				System.out.println("원하는 번호를 입력해주세요");
				System.out.println("1. 전체학생정보, 2. 학생정보검색, 3. 학생정보추가, 4. 학생정보삭제, 5. 시스템종료");
				int select = scanner.nextInt();
				ArrayList<StudentDTO> ar = new ArrayList<>();
				switch(select) {
				case 1:
					System.out.println("전체학생정보를 출력합니다");
					bw.write("1:\r\n");
					bw.flush();
					
					data = br.readLine();
					System.out.println(data);
					StringTokenizer st = new StringTokenizer(data, "-");
					while(st.hasMoreTokens()) {
						studentDTO = new StudentDTO();
						studentDTO.setName(st.nextToken());
						studentDTO.setNum(Integer.parseInt(st.nextToken()));
						studentDTO.setKor(Integer.parseInt(st.nextToken()));
						studentDTO.setEng(Integer.parseInt(st.nextToken()));
						studentDTO.setMath(Integer.parseInt(st.nextToken()));
						studentDTO.setTotal(Integer.parseInt(st.nextToken()));
						studentDTO.setAvg(Double.parseDouble(st.nextToken()));
						ar.add(studentDTO);
						}
					sv.view(ar);
					break;
				case 2:
					System.out.println("학생의 이름을 검색해주세요");
					String name = scanner.next();
					bw.write("2:"+name+"\r\n");
					bw.flush();
					data = br.readLine();
					if(data.equals("no data")) {
						System.out.println("학생정보가 없습니다");
					} else {
						String [] onename = data.split("-");
						studentDTO.setName(onename[0]);
						studentDTO.setNum(Integer.parseInt(onename[1]));
						studentDTO.setKor(Integer.parseInt(onename[2]));
						studentDTO.setEng(Integer.parseInt(onename[3]));
						studentDTO.setMath(Integer.parseInt(onename[4]));
						studentDTO.setTotal(studentDTO.getKor()+studentDTO.getEng()+studentDTO.getMath());
						studentDTO.setAvg(studentDTO.getTotal()/3.0);
						System.out.println("검색한 학생의 정보를 출력합니다");
						sv.view(studentDTO);
					}
					
					break;
				case 3:
					result = studentDAO.add();
					bw.write("3:"+result+"\r\n");
					bw.flush();
					data = br.readLine();
					System.out.println(data);
					break;
				case 4:
					result = studentDAO.remove();
					bw.write("4:"+result+"\r\n");
					bw.flush();
					data = br.readLine();
					System.out.println(data);
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
