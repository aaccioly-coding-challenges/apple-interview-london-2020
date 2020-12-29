package com.apple.interview2020.firstproblem;

class MedianFinderGlazedListsSortedListTest implements MedianFinderContract<MedianFinderGlazedListsSortedList> {
    @Override
    public MedianFinderGlazedListsSortedList createMedianFinder() {
        return new MedianFinderGlazedListsSortedList();
    }
}
