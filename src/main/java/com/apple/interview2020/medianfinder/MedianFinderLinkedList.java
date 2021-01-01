package com.apple.interview2020.medianfinder;

import java.util.*;

public class MedianFinderLinkedList implements MedianFinder {

    private final LinkedList<Long> durations;
    private ListIterator<Long> iterator;
    private long lastMedian = 0L;

    public MedianFinderLinkedList() {
        durations = new LinkedList<>();
        iterator = durations.listIterator();
    }

    @Override
    public Long getNextMedianPlayDuration(PlayEvent nextPlayEvent) {
        final Long duration = nextPlayEvent.getDuration();

        final int middle = (durations.size() + 1) / 2;

        // *** Optimizations. Trying to avoid O(n) insert operations as often as possible ***

        // Add near middle when duration is the same as the last median
        if (durations.isEmpty() || lastMedian == duration) {
            iterator.add(duration);
            if (iterator.nextIndex() > middle) {
                iterator.previous();
            }
        }
        // Add at the beginning of the list
        else if (durations.getFirst() >= duration) {
            durations.addFirst(duration);
            iterator = durations.listIterator(middle); // O(n) transversal
        }
        // Add at the end of the list
        else if (durations.getLast() <= duration) {
            durations.addLast(duration);
            iterator = durations.listIterator(middle); // O(n) transversal
        }
        // Find right position to insert
        else {
            // Suboptimal -> O(n)
            // Reusing the iterator is faster than Collections.binarySearch + inserting by index
            while (iterator.hasPrevious() && iterator.previous() > duration) ;
            while (iterator.hasNext() && iterator.next() < duration) ;

            iterator.add(duration);

            // Return iterator to middle
            while (iterator.hasPrevious() && iterator.previousIndex() > middle) {
                iterator.previous();
            }
            while (iterator.hasNext() && iterator.nextIndex() < middle) {
                iterator.next();
            }
        }

        Long median;
        if ((durations.size() & 1) == 0) {
            median = iterator.next();
            iterator.previous();
            median += iterator.previous();
            median /= 2;
        } else {
            median = iterator.next();
        }

        lastMedian = median;
        return median;
    }
}
