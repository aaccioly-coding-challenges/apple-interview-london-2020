package com.apple.interview2020.firstproblem;

class MedianFinderLinkedListTest implements MedianFinderContract<MedianFinderLinkedList> {
    @Override
    public MedianFinderLinkedList createMedianFinder() {
        return new MedianFinderLinkedList();
    }
}
