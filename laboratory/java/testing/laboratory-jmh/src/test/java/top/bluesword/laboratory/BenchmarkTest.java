package top.bluesword.laboratory;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

//BenchmarkMode，使用模式，默认是Mode.Throughput，表示吞吐量
//AverageTime，表示平均执行时间
//SampleTime表示采样时间
//SingleShotTime表示只运行一次，用于测试冷启动消耗时间
//All表示统计前面的所有指标
@BenchmarkMode(Mode.All)
//Warmup 配置预热次数，iterations表示执行次数，time是每次执行时间，timeUnit是执行时间单位
@Warmup(iterations = 1,time = 1)
//Measurement 配置执行次数。
@Measurement(iterations = 5, time = 1)
//Threads 配置同时起多少个线程执行
@Threads(1)
//Fork，代表启动多个单独的进程分别测试每个方法
@Fork(1)
//OutputTimeUnit 统计结果的时间单元，这个例子TimeUnit.SECONDS，我们在运行后会看到输出结果是统计每秒的吞吐量
@OutputTimeUnit(TimeUnit.SECONDS)
public class BenchmarkTest {

    @Benchmark
    public static void deci() throws InterruptedException {
        Thread.sleep(100);
    }

    @Benchmark
    public static void empty() {
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

}