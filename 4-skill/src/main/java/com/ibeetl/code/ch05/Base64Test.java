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
public class Base64Test {
	/*sun*/
	BASE64Encoder sunBase64Encoder = new BASE64Encoder();
	BASE64Decoder sunBase64Decoder = new BASE64Decoder();
	/*apache*/
	Base64 apacheBase64 = new Base64();
	/*jdk8*/
	java.util.Base64.Decoder jdk8Base64Decoder =  java.util.Base64.getDecoder();
	java.util.Base64.Encoder jdk8Base64Encoder =  java.util.Base64.getEncoder();


	byte[] content = "<xml><element>hello,world</element></xml>".getBytes(StandardCharsets.UTF_8);

	@Benchmark
	public byte[] sun() throws IOException {
		String str = sunBase64Encoder.encode(content);
		byte[] bs = sunBase64Decoder.decodeBuffer(str);
		return bs;
	}
	@Benchmark
	public byte[] apache() throws IOException {
		String str = apacheBase64.encodeToString(content);
		byte[] bs = apacheBase64.decode(str);
		return bs;
	}

	@Benchmark
	public byte[] jdk8() throws IOException {
		String str = jdk8Base64Encoder.encodeToString(content);
		byte[] bs = jdk8Base64Decoder.decode(str);
		return bs;
	}


	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(Base64Test.class.getSimpleName()).forks(1).build();
		new Runner(opt).run();
	}
}
