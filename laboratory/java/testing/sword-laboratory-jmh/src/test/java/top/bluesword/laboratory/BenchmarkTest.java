package top.bluesword.laboratory;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

//BenchmarkMode，使用模式，默认是Mode.Throughput，表示吞吐量
//还有AverageTime，表示每次执行时间
//SampleTime表示采样时间
//SingleShotTime表示只运行一次，用于测试冷启动消耗时间
//All表示统计前面的所有指标
@BenchmarkMode(Mode.All)
//Warmup 配置预热次数，默认是每次运行1秒，运行10次
@Warmup(iterations = 3)
//Measurement 配置执行次数，本例是一次运行5秒，总共运行3次。
@Measurement(iterations = 3, time = 5)
//Threads 配置同时起多少个线程执行
@Threads(1)
//Fork，代表启动多个单独的进程分别测试每个方法
@Fork(1)
//OutputTimeUnit 统计结果的时间单元，这个例子TimeUnit.SECONDS，我们在运行后会看到输出结果是统计每秒的吞吐量
@OutputTimeUnit(TimeUnit.SECONDS)
public class BenchmarkTest {

    @Benchmark
    public static void test1(){
        int sum = 1;
        for (int i = 0; i < 10; i++) {
            sum*=2;
        }
        if (sum!=1024) {
            throw new RuntimeException();
        }
    }

    @Benchmark
    public static void test2(){
        int sum = 1;
        for (int i = 0; i < 10; i++) {
            sum=sum<<1;
        }
        if (sum!=1024) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}