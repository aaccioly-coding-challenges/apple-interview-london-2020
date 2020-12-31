package com.apple.interview2020.medianfinder;

class MedianFinderArrayListTest implements MedianFinderContract<MedianFinderArrayList> {
    @Override
    public MedianFinderArrayList createMedianFinder() {
        return new MedianFinderArrayList();
    }
}
