package com.apple.interview2020.medianfinder;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 3/*, jvmArgs = {"-Xms2G", "-Xmx2G"}*/)
//@Warmup(iterations = 2)
//@Measurement(time = 5)
public class MedianFinderBenchmarkAvgTime {

    private static final Logger logger = LoggerFactory.getLogger(MedianFinderBenchmarkAvgTime.class);

    @Benchmark
    @OperationsPerInvocation(100)
    public void arrayList000100Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderArrayList(), events, blackhole, 100);
    }

    @Benchmark
    @OperationsPerInvocation(100)
    public void linkedList000100Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderLinkedList(), events, blackhole, 100);
    }

    @Benchmark
    @OperationsPerInvocation(100)
    public void sortedList000100Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderGlazedListsSortedList(), events, blackhole, 100);
    }

    @Benchmark
    @OperationsPerInvocation(100)
    public void twoHeaps000100Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderTwoHeaps(), events, blackhole, 100);
    }

    @Benchmark
    @OperationsPerInvocation(1000)
    public void arrayList001000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderArrayList(), events, blackhole, 1000);
    }

    @Benchmark
    @OperationsPerInvocation(1000)
    public void linkedList001000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderLinkedList(), events, blackhole, 1000);
    }

    @Benchmark
    @OperationsPerInvocation(1000)
    public void sortedList001000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderGlazedListsSortedList(), events, blackhole, 1000);
    }

    @Benchmark
    @OperationsPerInvocation(1000)
    public void twoHeaps001000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderTwoHeaps(), events, blackhole, 1000);
    }

    @Benchmark
    @OperationsPerInvocation(10000)
    public void arrayList010000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderArrayList(), events, blackhole, 10000);
    }

    @Benchmark
    @OperationsPerInvocation(10000)
    public void linkedList010000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderLinkedList(), events, blackhole, 10000);
    }

    @Benchmark
    @OperationsPerInvocation(10000)
    public void sortedList010000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderGlazedListsSortedList(), events, blackhole, 10000);
    }

    @Benchmark
    @OperationsPerInvocation(10000)
    public void twoHeaps010000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderTwoHeaps(), events, blackhole, 10000);
    }

    @Benchmark
    @OperationsPerInvocation(100000)
    public void arrayList100000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderArrayList(), events, blackhole, 100000);
    }

    @Benchmark
    @OperationsPerInvocation(100000)
    public void linkedList100000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderLinkedList(), events, blackhole, 100000);
    }

    @Benchmark
    @OperationsPerInvocation(100000)
    public void sortedList100000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderGlazedListsSortedList(), events, blackhole, 100000);
    }

    @Benchmark
    @OperationsPerInvocation(100000)
    public void twoHeaps100000Events(ThreadEvents events, Blackhole blackhole) {
        run(new MedianFinderTwoHeaps(), events, blackhole, 100000);
    }

    private void run(MedianFinder medianFinder, ThreadEvents events, Blackhole blackhole, final int nEventsToProcess) {
        for (int i = 0; i < nEventsToProcess; i++) {
            blackhole.consume(medianFinder.getNextMedianPlayDuration(events.getNextEvent()));
        }
    }

}
