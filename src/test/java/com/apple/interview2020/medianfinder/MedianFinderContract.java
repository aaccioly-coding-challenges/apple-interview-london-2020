package com.apple.interview2020.medianfinder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface MedianFinderContract<T extends MedianFinder> {

    T createMedianFinder();

    @Test
    default void medianOfOneEventShouldBeItsDuration() {
        var event = new PlayEvent("a", "1", 1591009200000L, 1591009470000L);

        var medianFinder = createMedianFinder();

        long expected = 270_000L;
        long result = medianFinder.getNextMedianPlayDuration(event);

        assertEquals(expected, result);
    }

    @Test
    default void medianOfEventsWithSameDurationShouldEqualDuration() {
        var event = new PlayEvent("a", "1", 0L, 100L);

        var medianFinder = createMedianFinder();

        final long expected = 100L;

        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
        assertEquals(expected, medianFinder.getNextMedianPlayDuration(event));
    }

    @Test
    default void medianOfEventsWithAscendingDurationShouldGrow() {
        var event1 = new PlayEvent("a", "1", 0L, 100L);
        var event2 = new PlayEvent("b", "2", 0L, 200L);
        var event3 = new PlayEvent("c", "3", 0L, 300L);
        var event4 = new PlayEvent("d", "4", 0L, 400L);

        var medianFinder = createMedianFinder();

        assertEquals(100L, medianFinder.getNextMedianPlayDuration(event1));
        assertEquals(150L, medianFinder.getNextMedianPlayDuration(event2));
        assertEquals(200L, medianFinder.getNextMedianPlayDuration(event3));
        assertEquals(250L, medianFinder.getNextMedianPlayDuration(event4));
    }

    @Test
    default void medianOfEventsWithDescendingDurationShouldShrink() {
        var event1 = new PlayEvent("d", "4", 0L, 400L);
        var event2 = new PlayEvent("c", "3", 0L, 300L);
        var event3 = new PlayEvent("b", "2", 0L, 200L);
        var event4 = new PlayEvent("a", "1", 0L, 100L);

        var medianFinder = createMedianFinder();

        assertEquals(400L, medianFinder.getNextMedianPlayDuration(event1));
        assertEquals(350L, medianFinder.getNextMedianPlayDuration(event2));
        assertEquals(300L, medianFinder.getNextMedianPlayDuration(event3));
        assertEquals(250L, medianFinder.getNextMedianPlayDuration(event4));
    }

    @Test
    default void sampleProblemInputShouldProduceExpectedOutput() {
        var event1 = new PlayEvent("9e20342f-0477-407b-98b7-90a2c319af4a", "b2997a71-bb50-43cb-b254-8ace7c5fc5ba", 1591009200000L, 1591009470000L);
        var event2 = new PlayEvent("f2f217a6-7ccf-4420-a117-7dd8757294fb", "ce3f9080-598e-46b6-b4f0-5a5a7a494ac6", 1591009410000L, 1591009470000L);
        var event3 = new PlayEvent("97f8f849-3d65-43d7-a8f1-721723665400", "ce3f9080-598e-46b6-b4f0-5a5a7a494ac6", 1591009380000L, 1591009470000L);
        var event4 = new PlayEvent("fdfbc1c8-05e4-46f1-a1bc-40e1cdb6d87f", "b2997a71-bb50-43cb-b254-8ace7c5fc5ba", 1591009410000L, 1591009475000L);

        var medianFinder = createMedianFinder();

        assertEquals(270_000L, medianFinder.getNextMedianPlayDuration(event1));
        assertEquals(165_000L, medianFinder.getNextMedianPlayDuration(event2));
        assertEquals(90_000L, medianFinder.getNextMedianPlayDuration(event3));
        assertEquals(77_500L, medianFinder.getNextMedianPlayDuration(event4));
    }

}
