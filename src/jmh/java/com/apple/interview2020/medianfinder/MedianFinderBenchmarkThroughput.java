package com.apple.interview2020.medianfinder;

import org.openjdk.jmh.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 3/*, jvmArgs = {"-Xms2G", "-Xmx2G"}*/)
//@Warmup(iterations = 2)
//@Measurement(time = 5)
public class MedianFinderBenchmarkThroughput {

    private static final Logger logger = LoggerFactory.getLogger(MedianFinderBenchmarkThroughput.class);

    @Benchmark
    public Long arrayList(MedianFinderImplementations implementations, ThreadEvents events) {
        return implementations.arrayList.getNextMedianPlayDuration(events.getNextEvent());
    }

    @Benchmark
    public Long linkedList(MedianFinderImplementations implementations, ThreadEvents events) {
        return implementations.linkedList.getNextMedianPlayDuration(events.getNextEvent());
    }

    @Benchmark
    public Long sortedList(MedianFinderImplementations implementations, ThreadEvents events) {
        return implementations.sortedList.getNextMedianPlayDuration(events.getNextEvent());
    }

    @Benchmark
    public Long twoHeaps(MedianFinderImplementations implementations, ThreadEvents events) {
        return implementations.twoHeaps.getNextMedianPlayDuration(events.getNextEvent());
    }

}
