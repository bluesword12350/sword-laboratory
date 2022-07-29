package top.bluesword.laboratory;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1,time = 1)
@Measurement(iterations = 5, time = 1)
@Threads(3)
@Fork(1)
@OutputTimeUnit(TimeUnit.SECONDS)
public class LoggerBenchmark {

    private final static java.util.logging.Logger javaUtilLogger = java.util.logging.Logger.getLogger(LoggerBenchmark.class.getName());
    private final static org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger(LoggerBenchmark.class);

    @Benchmark
    public void javaUtilLogger(){
        javaUtilLogger.info("java.util.logging.Logger");
    }

    @Benchmark
    public void slf4jLogger(){
        slf4jLogger.info("org.slf4j.Logger");
    }

    @Benchmark
    public void println(){
        System.out.println("System.out.println");
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include("top.bluesword.laboratory")
                .build();
        new Runner(opt).run();
    }

}
