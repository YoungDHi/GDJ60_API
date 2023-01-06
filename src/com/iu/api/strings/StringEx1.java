package com.iu.api.strings;

public class StringEx1 {

	public static void main(String[] args) {
		//
		String phone = "010-1234-5678";
	
		
		int num=phone.indexOf('-');
		System.out.println("1차 : "+num);
		boolean check=(num!=-1);
		while(check) {
			if(check) {
				System.out.println("Num : "+num);
				num=phone.indexOf('-', num+1);
			} else {
				break;
//			num=phone.indexOf('-', num+1);
//			System.out.println("Num : " + num);
//			if(num == -1) {
//				check = false;
			}
		}
//		boolean check = true;
//		int idx = 0;
//		while(check) {
//			idx = phone.indexOf('-', idx);
//			if(idx !=-1) {
//				System.out.println("Idx : " + idx);
//				idx++;
//			}else {
//				break;
//			}
//		}
		
	}

}
