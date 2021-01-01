package com.apple.interview2020.medianfinder;

import org.openjdk.jmh.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@State(Scope.Benchmark)
public class ThreadEvents {
    private static final Logger logger = LoggerFactory.getLogger(ThreadEvents.class);

    List<PlayEvent> events;
    int currentIndex;
    long fullRuns;

    @Setup(Level.Iteration)
    public void setup(GlobalEvents globalEvents) {
        events = globalEvents.events;
        currentIndex = 0;
        fullRuns = 0;
    }

    @TearDown(Level.Iteration)
    public void teardown() {
        logger.info("Total number of events processed: {} ", fullRuns * events.size() + currentIndex);
    }

    public PlayEvent getNextEvent() {
        var next = events.get(currentIndex++);
        if (currentIndex == events.size()) {
            currentIndex = 0;
            fullRuns++;
            //logger.debug("Processed batch number {}, containing {} events", fullRuns, events.size());
        }
        return next;
    }
}
