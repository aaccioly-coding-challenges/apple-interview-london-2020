package com.apple.interview2020.medianfinder;

class MedianFinderGlazedListsSortedListTest implements MedianFinderContract<MedianFinderGlazedListsSortedList> {
    @Override
    public MedianFinderGlazedListsSortedList createMedianFinder() {
        return new MedianFinderGlazedListsSortedList();
    }
}
