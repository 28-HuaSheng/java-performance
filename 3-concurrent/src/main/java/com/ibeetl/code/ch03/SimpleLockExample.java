package com.ibeetl.code.ch03;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleLockExample {

	public void lockInterruptiblyTest(){
		Lock lock =  new ReentrantLock();
		try{
			lock.lockInterruptibly();


		}catch(InterruptedException ie){

		}finally {
			lock.unlock();
		}

	}

	public void lockTest(){
		Lock lock =  new ReentrantLock();
		lock.lock();

		try{
			runTask();
		}finally {
			lock.unlock();
		}
	}

	public void tryLockTest(){
		Lock lock =  new ReentrantLock();
		if(lock.tryLock()){
			try{

			}finally {
				lock.unlock();
			}
		}

	}

	public void tryLockForTimeTest(){
		Lock lock =  new ReentrantLock();
		try{
			if(lock.tryLock(1, TimeUnit.SECONDS)){
				try{

				}finally {
					lock.unlock();
				}
			}
		}catch(InterruptedException ie){

		}

	}

	ReentrantLock myLock =  new ReentrantLock();
	public void runTask(){
		if(!myLock.isHeldByCurrentThread()){
				throw new IllegalStateException("未获得锁不能直接调用此方法");
		}


	}


}
