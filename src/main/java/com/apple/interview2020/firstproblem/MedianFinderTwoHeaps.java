package com.apple.interview2020.firstproblem;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinderTwoHeaps implements MedianFinder {

    private final PriorityQueue<Long> lowerHalf;
    private final PriorityQueue<Long> upperHalf;

    public MedianFinderTwoHeaps() {
        this.lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        this.upperHalf = new PriorityQueue<>();
    }

    @Override
    public Long getNextMedianPlayDuration(PlayEvent nextPlayEvent) {
        long duration = nextPlayEvent.getDuration();
        if (lowerHalf.isEmpty()) {
            lowerHalf.add(duration);
        } else if (duration < lowerHalf.peek()) {
            lowerHalf.add(duration);
            balance(lowerHalf, upperHalf);
        } else {
            upperHalf.add(duration);
            balance(upperHalf, lowerHalf);
        }

        long median;
        if (lowerHalf.size() == upperHalf.size()) {
            median = (lowerHalf.peek() + upperHalf.peek()) / 2;
        } else if (lowerHalf.size() > upperHalf.size()) {
            median = lowerHalf.peek();
        } else {
            median = upperHalf.peek();
        }

        return median;
    }

    private void balance(PriorityQueue<Long> updated, PriorityQueue<Long> other) {
        if (updated.size() > other.size()) {
            other.add(updated.remove());
        }
    }

}
