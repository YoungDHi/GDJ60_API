package com.iu.api.wrappers.ex1;

public class JuminCheck2 {

		//check
		//주민번호를 받아서
		//991224-1234567
		//맨끝자리는 체크용 번호로 뺌
		//	9	8	0	7	2	4 -	1	2	3	4	5	6
		//	2	3	4	5	6	7	8	9	2	3	4	5
		//	18+	24+	0+	35+	12+	28+	8+	18+	6+	12+	20+	30
		// 합이 122, 합을 11로 나누어서 나머지구삼
		// 122/11 = 몫 : 11, 나머지는 1
		// 나머지값을 11로 뺀 결과값하고 체크용 번호랑 같은지 확인
		// 11-1-10
		// 11로 나눈 결과값이 두자리면
		// 11로 뺀 결과값을 다시 10으로 나눈 나머지를 체크용 번호랑 같은지 확인
		// 10/10 몫 : 1, 나머지 : 0 0==7?
		
	public void check(String jumin) {
		int num=2;
		int sum=0;
		for(int i=0;i<jumin.length()-1;i++) {
			if(i==6) {
				continue;
			}
			//sum=sum+Integer.parseInt(jumin.substring(i,i+1))*num;
			sum=sum+Integer.parseInt(String.valueOf(jumin.charAt(i)))*num;
			num++;
			if(num==10) {
				num=2;
			}
		}
		
		int result = 11-sum%11;
		
		if(result>9) {
			result = result%10;
		}
		
		int flag = Integer.parseInt(jumin.substring(13));
		
		if(result==flag) {
			System.out.println("정상");
		}else {
			System.out.println("비정상");
		}
			
		
		
		
			
//		String [] str = jumin.split(jumin);
//		int idx = 0;
//		for(int i=0;i<str.length-7;i++) {
//			int num = (Integer.parseInt(str[i]))*(i+2);
//			idx = idx+num;
//		}
//		System.out.println(str[7]);
//		idx = idx+Integer.parseInt(str[7])*8+Integer.parseInt(str[8])*9;
//		for(int i=9;i<12;i++) {
//			int num = Integer.parseInt(str[i])*(i-7);
//			idx = idx+num;
//		}
//		int check = idx%11;
//		if(check>10) {
//			if(check%10==Integer.parseInt(str[13])) {
//				System.out.println("정상적인 주민번호입니다");
//			}else {
//				System.out.println("비정상적인 주민번호입니다");
//			}
//		} else {
//			if(check==Integer.parseInt(str[13])) {
//				System.out.println("정상적인 주민번호입니다");
//			}else {
//				System.out.println("비정상적인 주민번호입니다");
//			}
//		}
			
		}
	
}
