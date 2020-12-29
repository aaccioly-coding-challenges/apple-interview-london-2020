package com.apple.interview2020.firstproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinderArrayList implements MedianFinder  {

    private final List<Long> durations;

    public MedianFinderArrayList() {
        durations = new ArrayList<>();
    }

    @Override
    public Long getNextMedianPlayDuration(PlayEvent nextPlayEvent) {
        int idxToInsert = Collections.binarySearch(durations, nextPlayEvent.getDuration()); // O(log n)
        if(idxToInsert < 0) {
            idxToInsert = -idxToInsert - 1;
        }
        // Suboptimal -> add is O(n)
        // But the underlying call to System.arrayCopy is fast for small collections
        durations.add(idxToInsert, nextPlayEvent.getDuration());

        long median;
        final int middle = durations.size() / 2;
        if (durations.size() % 2 == 0) {
            median = (durations.get(middle - 1) + durations.get(middle)) / 2;
        } else {
            median = durations.get(middle);
        }

        return median;
    }
}
