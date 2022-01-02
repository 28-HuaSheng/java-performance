package com.ibeetl.code.ch05;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * hashcode性能
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
public class CacheHashCode {
  int[] a = null;

  @Benchmark
  public int defaultHashcode(){
   return  new CityKey(1,10).hashCode();
  }



	@Benchmark
	public int hashcode(){
		return  new CachedCityKey(1,10).hashCode();
	}

	@Benchmark
	public int identityHashCode(){
		return  new CachedCityKey2(1,10).hashCode();
	}





	public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
      .include(CacheHashCode.class.getSimpleName())
      .forks(1)
      .build();
    new Runner(opt).run();
  }


}

class CityKey {
	private Integer provinceId;
	private Integer cityId;

	public CityKey(Integer provinceId, Integer cityId) {
		this.provinceId = provinceId;
		this.cityId = cityId;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}


}

 class CachedCityKey {
	private Integer provinceId;
	private Integer cityId;

	private transient  int hashCode = -1;

	public CachedCityKey(Integer provinceId, Integer cityId) {
		this.provinceId = provinceId;
		this.cityId = cityId;
	}

	@Override
	public int hashCode() {
		int code = hashCode;
		if(code!=0){
			return code;
		}
		code = Objects.hash(provinceId,cityId);
		hashCode = code;
		return code;
	}
}

class CachedCityKey2 {
	private Integer provinceId;
	private Integer cityId;

	private transient  int hashCode = -1;

	public CachedCityKey2(Integer provinceId, Integer cityId) {
		this.provinceId = provinceId;
		this.cityId = cityId;
	}

	@Override
	public int hashCode() {
		return System.identityHashCode(this);
	}
}

