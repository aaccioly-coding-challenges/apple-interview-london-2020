package com.apple.interview2020.medianfinder;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.SortedList;


public class MedianFinderGlazedListsSortedList implements MedianFinder  {

    private final SortedList<Long> durations;

    public MedianFinderGlazedListsSortedList() {
        durations = new SortedList<>(new BasicEventList<>());
    }

    @Override
    public Long getNextMedianPlayDuration(PlayEvent nextPlayEvent) {

        durations.add(nextPlayEvent.getDuration()); // O(log n)

        Long median;
        final int middle = durations.size() / 2;
        if ((durations.size() & 1) == 0) {
            median = (durations.get(middle - 1) + durations.get(middle)) / 2;
        } else {
            median = durations.get(middle);
        }

        return median;
    }
}
