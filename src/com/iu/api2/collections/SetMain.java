package com.iu.api2.collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain {

	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet<>();
		
		hs.add(1);
		hs.add(11);
		hs.add(11);
		hs.add(2);
		hs.remove(1);
		System.out.println(hs.toString());
		System.out.println(hs.size());
		
		//set의 Data들을 Iterator 변경
		//변수선언
		Iterator<Integer> is = hs.iterator();
		
		while (is.hasNext()){
			Integer num = is.next();
			System.out.println(num);
			
		}
		
		
	}

}
