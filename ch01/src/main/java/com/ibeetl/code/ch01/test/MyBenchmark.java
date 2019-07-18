package com.ibeetl.code.ch01.test;
import com.ibeetl.code.ch01.sample.Area;
import com.ibeetl.code.ch01.sample.AreaService;
import com.ibeetl.code.ch01.sample.PreferAreaService;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SampleTime)
@Warmup(iterations = 3)
@Measurement(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@OutputTimeUnit(TimeUnit.SECONDS)
public class MyBenchmark {
    static AreaService areaService = new AreaService();
    static PreferAreaService perferAreaService = new PreferAreaService();
    static List<Area> data = buildData(20);

    @Benchmark
    public  void  testStringKey(){
        areaService.buildArea(data);
    }
    @Benchmark
    public  void  testObjectKey(){
        perferAreaService.buildArea(data);
    }

    private static List<Area> buildData(int count){
        List<Area>  list = new ArrayList<>(count);
        for(int i=0;i<count;i++){
            Area area = new Area(i,i*10);
            list.add(area);
        }
        return list;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MyBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
