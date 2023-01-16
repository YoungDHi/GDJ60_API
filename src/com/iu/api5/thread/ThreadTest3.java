package com.iu.api5.thread;

public class ThreadTest3 implements Runnable{
	
	@Override
	public void run() {
		this.t3();
		
	}
	
	private void t3() {
		
		for(int i=0;i<25;i++) {
			
			System.out.println("hello : "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
