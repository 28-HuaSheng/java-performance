package com.ibeetl.code.ch03;

import java.util.concurrent.TimeUnit;

public class IDSeqHelper {
	static  int a = 0;
  public   static int add(){
    a++;
    return a;
  }

  public static void main(String[] args){
	  CountThread aThread =  new CountThread("a");
	  CountThread bThread =  new CountThread("b");
	  aThread.start();
	  bThread.start();

  }

  static class CountThread extends  Thread{
  	int last = 0;
  	public CountThread(String name){
  		super(name);
	}
  	public void run(){
  		while(true){
			int a = IDSeqHelper.add();
			if(a==last){
				System.out.println("error "+a);
			}
			last = a;

		}
	}
  }

}
