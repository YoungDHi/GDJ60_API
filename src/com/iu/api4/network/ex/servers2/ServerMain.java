package com.iu.api4.network.ex.servers2;

public class ServerMain {

	public static void main(String[] args) {
		try {
			new StudentController().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
