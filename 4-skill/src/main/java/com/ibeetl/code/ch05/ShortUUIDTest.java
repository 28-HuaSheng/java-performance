package com.ibeetl.code.ch05;

import org.apache.commons.codec.binary.Base64;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author 公众号 闲谈Java开发
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class ShortUUIDTest {
	String uuidStr = UUID.randomUUID().toString();

	@Benchmark
	public String regReplace() throws IOException {
		String str = uuidStr.replaceAll("-","");
		return str;
	}
	@Benchmark
	public String replace() throws IOException {
		return shortUUID(uuidStr);
	}




	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(ShortUUIDTest.class.getSimpleName()).forks(1).build();
		new Runner(opt).run();
//		String uuidStr = UUID.randomUUID().toString();
//		String str = uuidStr.replaceAll("-","");
//		System.out.println(str);
//
//		String str1 = shortUUID(uuidStr);
//		System.out.println(str1);
	}

	public static String shortUUID(String uuid){
		StringBuilder sb = new StringBuilder(uuid.length()-4);
		sb.append(uuid.substring(0,8)).append(uuid.substring(9,13)).append(uuid.substring(14,18))
				.append(uuid.substring(19,23)).append(uuid.substring(24,36));
		return sb.toString();
	}
}
