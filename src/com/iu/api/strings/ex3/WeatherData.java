package com.iu.api.strings.ex3;

public class WeatherData {
	
	private String data;
	
	public WeatherData() {
		this.data="SEOUL,12,맑음,60,Daegu,68,비,10,"
				+ "JEJU,-56,눈,12,JUNJU,32,흐림,5";
	}
	
	//init 
	//data를 파싱해서 각 data를 DTO에 대입하고 DTO들을 리턴
	public WeatherDTO [] init() {
		String [] datas = this.data.split(",");
		
		WeatherDTO [] weathers = new WeatherDTO[datas.length/4];
		
		
		
//		for(int i=0;i<datas.length;i++) {
//			WeatherDTO weatherDTO = new WeatherDTO();
//			for(int r=0;r<i+1;r++) {
//				if(i==4*r) {
//					weathers[i] = weatherDTO;
//				} else if(i==4*r+1) {
//					weathers[i].setGion(datas[i]);
//				}else if(i==4*r+2) {
//					weathers[i].setStatus(datas[i]);
//				}else if(i==4*r+3) {
//					weathers[i].setMise(datas[i]);
//				}
//			}
//		}
		//int idx = 0;
		for(int i=0;i<datas.length;i++) {
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setCity(datas[i]);
			weatherDTO.setGion(Integer.parseInt(datas[++i]));
			weatherDTO.setStatus(datas[++i]);
			weatherDTO.setMise(Integer.parseInt(datas[++i]));
			weathers[i/4] = weatherDTO;
			//weathers[idx]=weatherDTO;
			//idx++;
		}
		
		
		return weathers;
	}
	

}
