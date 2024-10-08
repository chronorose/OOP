package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HeapTest {
    @Test
    void testHeapify() {
        int[] arr = new int[]{4, 7, 8, 10, 3, 7, 10};
        Heap.heapify(arr);
        assertTrue(testIfMaxHeap(arr, 0));
    }

    @Test
    void testHeapifyNull() {
        int[] arr = null;
        try {
            Heap.heapify(arr);
        } catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }

    private boolean testIfMaxHeap(int[] heap, int i) {
        if (heap == null) {
            return false; // not sure what's the right thing to return :D
        }
        if (i > heap.length) {
            return true;
        }
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < heap.length && heap[left] > heap[i]) {
            return false;
        }
        if (right < heap.length && heap[right] > heap[i]) {
            return false;
        }
        return testIfMaxHeap(heap, left) && testIfMaxHeap(heap, right);
    }
}
