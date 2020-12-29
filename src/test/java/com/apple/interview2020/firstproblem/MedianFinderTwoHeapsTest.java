package com.apple.interview2020.firstproblem;

class MedianFinderTwoHeapsTest implements MedianFinderContract<MedianFinderTwoHeaps> {
    @Override
    public MedianFinderTwoHeaps createMedianFinder() {
        return new MedianFinderTwoHeaps();
    }
}
