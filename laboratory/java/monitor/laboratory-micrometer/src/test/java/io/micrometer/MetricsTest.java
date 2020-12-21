package io.micrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MetricsTest {

    @BeforeAll
    static void before() {
        Metrics.addRegistry(new SimpleMeterRegistry());
    }

    @Test
    void counter() {
        Counter counter = Metrics.counter("simple");
        counter.increment();
        System.out.println(counter.count());
    }
}
