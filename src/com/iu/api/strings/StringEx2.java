package com.iu.api.strings;

import java.util.Scanner;

public class StringEx2 {

	public static void main(String[] args) {
		System.out.println("Start");
		Scanner sc = new Scanner(System.in);
		String [] names = {"jpg", "jpeg", "gif", "png"};
		System.out.println("파일명을 입력");
		String filename = sc.next();//sf.sd.jpg
		
		//확장자 분리 작업
		int idx = filename.lastIndexOf(".");
		String result = filename.substring(idx+1);
		boolean flag = true;
		//확장자가 이미지인지 검증
		for(int i=0;i<names.length;i++) {
			if(result.equals(names[i])) {
				System.out.println("정상적인 파일입니다");
				//flag = false;
				flag=!flag;
				break;
			}
		}
		if(flag) {
			System.out.println("비정상적인 파일입니다.");
		}
		
		
		
		System.out.println("Finish");
		
	}

}
