package com.ibeetl.code.ch05.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibeetl.code.ch05.messagePack.Product;
import org.msgpack.MessagePack;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 *c.i.c.c.j.JsonTest.fastjson_obj2str    thrpt        5  2543.146       92.901  ops/ms
 * c.i.c.c.j.JsonTest.fastjson_str2obj    thrpt        5   861.506        9.800  ops/ms
 * c.i.c.c.j.JsonTest.jackson_obj2str     thrpt        5  1759.122       77.816  ops/ms
 * c.i.c.c.j.JsonTest.jackson_str2obj     thrpt        5   897.493       16.975  ops/ms
 * Jackson 和 FastJSOn 性能测试
 * @author 公众号 闲谈java开发
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class JsonTest {

	ObjectMapper objectMapper = null;
	Small small = null;

	String smallJson = null;


	@Benchmark
	public String jackson_obj2str() throws JsonProcessingException {
		return objectMapper.writeValueAsString(small);
	}

	@Benchmark
	public String  fastjson_obj2str() throws IOException {
		return JSON.toJSONString(small,SerializerFeature.DisableCircularReferenceDetect);
	}


	@Benchmark
	public Small jackson_str2obj() throws JsonProcessingException {
		return objectMapper.readValue(smallJson,Small.class);
	}

	@Benchmark
	public Small  fastjson_str2obj() throws IOException {
		return JSON.parseObject(smallJson,Small.class);
	}


	@Setup
	public void init() throws Exception {
		objectMapper = new ObjectMapper();
		objectMapper.getFactory().configure(JsonFactory.Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING,true);
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		small = new Small();
		small.setDel(true);
		small.setDescription("hello");
		small.setId(1);
		small.setPrice(2.34);
		small.setProductStatus(true);
		small.setCreateTime(new Date());
		Small.SmallAttribute attribute1 = new Small.SmallAttribute("key","v1","");
		Small.SmallAttribute attribute2 = new Small.SmallAttribute("key2","v1","");
		small.setList(Arrays.asList(attribute1,attribute2));


		smallJson = objectMapper.writeValueAsString(small);






	}
	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(JsonTest.class.getSimpleName()).forks(1).build();
		new Runner(opt).run();
	}
}

