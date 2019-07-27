package com.ibeetl.code.ch03;


public class CPUCacheTest {
	private static /* volatile */ boolean stop = false;
	public static void main(String[] args){
		Thread a = new Thread("B"){
		  public void run(){
			  while (!stop) {
				  //		  	pause(1);
				 // System.out.println(1);
				  int a = 1;
			}
			System.out.println("exit");
		  }
		};
    	a.start();
		pause(100);
		stop = true;

  }
  public static void pause(int time){
    try {
      Thread.sleep(time);
    }catch(Exception ex){
    }

  }

}
