package com.iu.api2.collections;

import java.util.ArrayList;

public class ListMain3 {

	public static void main(String[] args) {
		//Collection은 Type에 안전하지 않다
		//Generic : Type의 안전성
		//E : 변수명
		// E = Integer
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(1);
		
		int num = ar.get(0);
		
		
		ArrayList<weatherDTO> ar2 = new ArrayList();
		weatherDTO weatherDTO = new weatherDTO();
		weatherDTO.setCity("Seoul");
		ar2.add(weatherDTO);
		weatherDTO = new weatherDTO();
		weatherDTO.setCity("JEJU");
		ar2.add(weatherDTO);
		
//		weatherDTO = new weatherDTO();
//		weatherDTO.setCity("Jeju");
		ar2.remove(weatherDTO);
		
		
		
		
		for(int i=0;i<ar2.size();i++) {
			
			System.out.println(ar2.get(i).getCity());
			
		}
		
		
	}

}
