package com.iu.api.strings;

import java.util.Scanner;

public class StringEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] names = {"jpg", "jpeg", "gif", "png"};
		System.out.println("파일명을 입력");
		String filename = sc.next();//sf.sd.dsf.df
		
		String result = filename.substring(filename.lastIndexOf(".")+1);
		
		
		for(int i = 0;i<4;i++) {
			boolean check = false;
			if(result.equals(names [i])) {
				System.out.println("정상적인 파일입니다");
				check = true;
				break;
			}	
		if(check) {
			System.out.println("비정상적인 파일입니다");
		}
		
		
		
		}
	}

}
