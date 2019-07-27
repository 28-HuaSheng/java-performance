package com.ibeetl.code.ch02;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class StringPoolTest {

  String status = "1";


  @Benchmark
  public String intern(){
   String str =  status.intern();
   return str;

  }




  public static void main(String[] args) throws RunnerException {

    Options opt = new OptionsBuilder()
      .include(StringPoolTest.class.getSimpleName())
      .forks(1)
      .build();
    new Runner(opt).run();
  }
}

