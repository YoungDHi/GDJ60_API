package com.iu.api2.collections;

import java.util.HashMap;

public class MapMain {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		//데이터 추가
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k2", "v2Re");
		
		
		//데이터 조회
		String v = map.get("k3");
		
		System.out.println(v);
		System.out.println(map);
	}

}
