package com.iu.api.strings.ex3;

import java.util.Scanner;

public class WeatherController {
	//start
	public void start() {
	Scanner sc = new Scanner(System.in);
	WeatherData wd = new WeatherData();
	WeatherView wv = new WeatherView();
	WeatherInput wi = new WeatherInput();
	WeatherDTO[] wdtos = null;
	boolean check=true;
	while(check) {
		System.out.println("원하는 메뉴를 선택해주세요");
		System.out.println("1.날씨정보초기화 2.전국날씨정보 3.지역날씨검색 "
				+ "4.지역날씨추가 5.지역날씨삭제 6.종료");
		int select = sc.nextInt();
		if(select==6) {
			System.out.println("종료입니다");
			break;
		//1. 날씨정보초기화
		//	 초기화가 완료되었습니다
		}else if(select==1) {
			wdtos=wd.init();
			System.out.println("초기화가 완료되었습니다");	
		}else if(select==2) {
			//2. 전국날씨정보
			System.out.println("전국날씨정보를 검색합니다");
			wv.view(wdtos);
		}else if(select==3) {
			//3. 지역날씨검색
			//	 정보가 없으면 도시정보가 없습니다
			System.out.println("지역날씨를 검색합니다");
			if(wi.search(wdtos)!=null) {
			wv.view(wi.search(wdtos));
			
			}else {
				System.out.println("도시정보가 없습니다");
			}
		}else if(select==4) {
			System.out.println("지역날씨를 추가합니다");
		}else {
			System.out.println("지역날씨를 삭제합니다");
		}
	
	
	
	//4. 지역날씨추가
	//	 
	//5. 지역날씨삭제
	//
	//6. 종료
	}
	}
}
