package com.apple.interview2020.medianfinder;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class MedianFinderImplementations {

    MedianFinder arrayList;
    MedianFinder linkedList;
    MedianFinder sortedList;
    MedianFinder twoHeaps;

    @Setup(Level.Iteration)
    public void setup() {
        arrayList = new MedianFinderArrayList();
        linkedList = new MedianFinderLinkedList();
        sortedList = new MedianFinderGlazedListsSortedList();
        twoHeaps = new MedianFinderTwoHeaps();
    }
}
