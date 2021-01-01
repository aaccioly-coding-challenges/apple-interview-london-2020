package com.apple.interview2020.medianfinder;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@State(Scope.Benchmark)
public class GlobalEvents {
    static final int N_EVENTS_TO_GENERATE = 1_000_000;
    static final int MIN_DURATION = 0;
    static final int MAX_DURATION = 900_000;

    private static final Logger logger = LoggerFactory.getLogger(GlobalEvents.class);

    final Random random = new Random();
    List<PlayEvent> events;

    @Setup(Level.Trial)
    public void setup() {
        events = Stream.generate(this::randomEvent)
                .limit(N_EVENTS_TO_GENERATE)
                .collect(Collectors.toUnmodifiableList());
        logger.info("Finished constructing {} sample events", N_EVENTS_TO_GENERATE);
    }

    private PlayEvent randomEvent() {
        long firstDuration = MIN_DURATION + random.nextInt(MAX_DURATION);
        long secondDuration = MIN_DURATION + random.nextInt(MAX_DURATION);
        return new PlayEvent("a", "b",
                Math.min(firstDuration, secondDuration),
                Math.max(firstDuration, secondDuration));
    }
}
