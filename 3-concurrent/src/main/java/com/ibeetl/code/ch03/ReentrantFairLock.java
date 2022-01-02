package com.ibeetl.code.ch03;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁和非公平锁
 * @author 公众号 闲谈Java
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Threads(200)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class ReentrantFairLock {
	static ReentrantLock fairLock =  new ReentrantLock(true);
	static ReentrantLock unfairLock =  new ReentrantLock(false);
	static AtomicInteger aiForFair = new AtomicInteger();
	static AtomicInteger aiForUnFair = new AtomicInteger();

    @Benchmark
    public  int    fairLock(){
		fairLock.lock();
		try{
			return aiForFair.incrementAndGet();
		}finally {
			fairLock.unlock();
		}

    }
    @Benchmark
    public  int  unFairLock() {
		unfairLock.lock();
		try{
			return aiForUnFair.incrementAndGet();
		}finally {
			unfairLock.unlock();
		}

	}



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ReentrantFairLock.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
