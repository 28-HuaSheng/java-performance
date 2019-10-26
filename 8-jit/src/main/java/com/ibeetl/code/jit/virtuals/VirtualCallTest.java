package com.ibeetl.code.jit.virtuals;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class VirtualCallTest {

	@Param({"false","true"})
	boolean virtual;
	int x = 1;
	static final int   MAX = 2000;
	int count = 0;

    @Benchmark
//	@Fork(value=1,jvmArgsAppend = "-XX:+PrintCompilation")
	public  int  call(){
		return justCall();

	}

	@Benchmark
	public  int  staticCall(){
		Foo foo = getFoo();
		return Foo.say2(x);

	}

    private int justCall(){
		Foo foo = getFoo();
		return foo.say(x);
	}

    private Foo getFoo() {
    	count++;
		if (virtual) {
			if(count>MAX){
				return new Bar();
			}else{
				return new Foo();
			}


		}else{
			if(count>MAX){
				return new Foo();
			}else{
				return new Foo();
			}
		}


	}
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(VirtualCallTest.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}