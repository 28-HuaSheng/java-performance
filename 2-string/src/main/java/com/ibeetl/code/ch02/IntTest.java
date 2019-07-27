package com.ibeetl.code.ch02;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class IntTest {

	int a = 1;
	int b = 2;
	Integer c = a;
	Integer d = b;

	public static void main(String[] args) throws RunnerException {


		Options opt = new OptionsBuilder().include(IntTest.class.getSimpleName()).forks(1).build();
		new Runner(opt).run();
	}

	@Benchmark
	public int add() {
		IntStream intStream = IntStream.of(10, 20, 30, 40, 50);

		return  intStream.sum();

	}

	@Benchmark
	public int addInteger() {
		return c + d;
	}
}

