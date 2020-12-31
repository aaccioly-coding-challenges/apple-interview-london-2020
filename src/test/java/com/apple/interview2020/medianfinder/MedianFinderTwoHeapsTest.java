package com.apple.interview2020.medianfinder;

class MedianFinderTwoHeapsTest implements MedianFinderContract<MedianFinderTwoHeaps> {
    @Override
    public MedianFinderTwoHeaps createMedianFinder() {
        return new MedianFinderTwoHeaps();
    }
}
