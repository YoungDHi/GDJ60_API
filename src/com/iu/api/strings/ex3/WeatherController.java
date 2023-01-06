package com.iu.api.strings.ex3;

import java.util.Scanner;

public class WeatherController {
	//start
	public void start() {
	Scanner sc = new Scanner(System.in);
	WeatherData wd = new WeatherData();
	WeatherView wv = new WeatherView();
	WeatherInput wi = new WeatherInput();
	WeatherDTO[] wDTOs = null;
	boolean check=true;
	while(check) {
		System.out.println("원하는 메뉴를 선택해주세요");
		System.out.println("1.날씨정보초기화 2.전국날씨정보 3.지역날씨검색 "
				+ "4.지역날씨추가 5.지역날씨삭제 6.종료");
		int select=sc.nextInt();
		switch(select) {
		//1. 날씨정보초기화
		//	 초기화가 완료되었습니다
		case 1:
			wDTOs = wd.init();
			System.out.println("초기화가 완료되었습니다.");
			break;
		//2. 전국날씨정보	
		case 2:
			wv.view(wDTOs);
			break;
		//3. 지역날씨 검색
		//정보가 없으면 도시정보가 없습니다.
		case 3:
			System.out.println("지역날씨를 검색합니다");
			WeatherDTO wDTO = wi.search(wDTOs);
			if(wDTO!=null) {
			wv.view(wDTO);
			}else {
				System.out.println("도시정보가 없습니다");
			}
			break;
		//4. 지역날씨추가
		case 4:
			System.out.println("도시를 추가합니다");
			wDTOs = wi.add(wDTOs);
			break;
		//5. 지역날씨삭제
		case 5:
			System.out.println("도시를 삭제합니다");
			wDTOs = wi.remove(wDTOs);
			break;
		//6. 종료
		default:
			check=!true;
		}
			
	}
	}
}
