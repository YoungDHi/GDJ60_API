package com.iu.api.strings.ex3;

import java.util.Scanner;

public class WeatherInput {

	//search
	//배열을 받고, 키보드로부터 검색할 도시명(대소문자 무관)을 입력받음
	//찾은 DTO를 리턴,없으면 null
	public WeatherDTO search(WeatherDTO [] weatherDTOs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 도시를 입력해주세요");
		String name = sc.next().toLowerCase();
		WeatherDTO weatherDTO= null;
		for(int i=0;i<weatherDTOs.length;i++) {
			if(name.equals(weatherDTOs[i].getCity().toLowerCase())) {
				weatherDTO = weatherDTOs[i];
				
			}
		}
		return weatherDTO;
	}
	
	//add
	//배열을 받고, 키보드로부터 정보들을 입력받음
	//배열에 추가하고 배열을 리턴
	public WeatherDTO[] add(WeatherDTO[] weatherDTOs) {
		Scanner sc=new Scanner(System.in);
		WeatherDTO weatherDTO = new WeatherDTO();
		
		System.out.println("추가할 도시를 입력해주세요");
		weatherDTO.setCity(sc.next());
		System.out.println("기온을 입력해주세요");
		weatherDTO.setGion(sc.next());
		System.out.println("날씨를 입력해주세요");
		weatherDTO.setStatus(sc.next());
		System.out.println("미세먼지를 입력해주세요");
		weatherDTO.setMise(sc.next());
		System.out.println("City	: "+weatherDTO.getCity());
		System.out.println("Gion	: "+weatherDTO.getGion());
		System.out.println("Status	: "+weatherDTO.getStatus());
		System.out.println("Mise	: "+weatherDTO.getMise());
		WeatherDTO [] newWeatherDTOs = new WeatherDTO[weatherDTOs.length+1];
		for(int i=0;i<weatherDTOs.length;i++) {
			newWeatherDTOs[i] = weatherDTOs[i];
		}
		newWeatherDTOs[weatherDTOs.length]=weatherDTO;
		return newWeatherDTOs;
	}
	//remove
	//배열을 받고, 키보드로부터 삭제할 도시명을 입력 받음
	//배열에서 삭제하고 배열을 리턴
	public void remove(WeatherDTO[] weatherDTOs) {
		Scanner sc=new Scanner(System.in);
		WeatherDTO weatherDTO = new WeatherDTO();
		
		System.out.println("삭제할 도시를 입력해주세요");
		String name = sc.next().toUpperCase();
		for(int i=0;i<weatherDTOs.length;i++) {
			if(name.equals(weatherDTOs[i].getCity().toUpperCase())) {
				
			}
			
		}
		
	}
		
}
