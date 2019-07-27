package com.ibeetl.code.ch02;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class StringSearch {


	String str = "你好，java";
	String reg = ".*java.*";
	String key = "java";
	Pattern pattern = Pattern.compile(reg);

	public static void main(String[] args) throws RunnerException {

		Options opt = new OptionsBuilder().include(StringSearch.class.getSimpleName()).forks(1).build();
		new Runner(opt).run();

	}

	@Benchmark
	public boolean search() {
		return str.matches(reg);
	}

	@Benchmark
	public boolean compileSearch() {
		return pattern.matcher(str).matches();
	}

	@Benchmark
	public boolean contain() {
		return str.contains(key);
	}
}

