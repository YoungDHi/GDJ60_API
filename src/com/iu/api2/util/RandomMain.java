package com.iu.api2.util;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class RandomMain {

	public static void main(String[] args) {
		Random random = new Random();
		
		//1000원 로또 구매 1-45 번호 6개를 랜덤하게 추출
		HashSet<Integer> hs = new HashSet<>();
		
		while(hs.size()<6) {
			hs.add(random.nextInt(44)+1);
		}
		System.out.println(hs);
			
			
		
		
		
//		int num = random.nextInt(9)+1;
		
		

	}

}
