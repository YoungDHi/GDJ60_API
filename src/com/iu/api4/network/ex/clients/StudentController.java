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
			socket = new Socket("127.1.1.1", 8282);
			System.out.println("Server 접속 성공");
			os = socket.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			
			is = socket.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			
			while(check) {
				System.out.println("원하는 번호를 입력해주세요");
				System.out.println("1. 전체학생정보, 2. 학생정보검색, 3. 학생정보추가, 4. 학생정보삭제, 5. 시스템종료");
				int select = scanner.nextInt();
				ArrayList<StudentDTO> ar = new ArrayList<>();
				switch(select) {
				case 1:
					System.out.println("전체학생정보를 출력합니다");
					bw.write(select+"\r\n");
					bw.flush();
					
					data ="1. "+br.readLine();
					
					select = Integer.parseInt(data.substring(0, 1));
					data = data.substring(3);
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
					sv.view(ar);
					break;
				case 2:
					System.out.println("학생의 이름을 검색해주세요");
					String name = scanner.next();
					bw.write("2."+name+"\r\n");
					bw.flush();
					data = "2. "+br.readLine();
					StringTokenizer st2 = new StringTokenizer(data,"-");
					while(st2.hasMoreTokens()) {
						studentDTO = new StudentDTO();
						studentDTO.setName(st2.nextToken());
						studentDTO.setNum(Integer.parseInt(st2.nextToken()));
						studentDTO.setKor(Integer.parseInt(st2.nextToken()));
						studentDTO.setEng(Integer.parseInt(st2.nextToken()));
						studentDTO.setMath(Integer.parseInt(st2.nextToken()));
						studentDTO.setTotal(studentDTO.getKor()+studentDTO.getEng()+studentDTO.getMath());
						studentDTO.setAvg(studentDTO.getTotal()/3);
						ar.add(studentDTO);
					}
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
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
