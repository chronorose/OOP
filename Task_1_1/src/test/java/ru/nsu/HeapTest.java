package ru.nsu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HeapTest {
    @Test
    void testHeapify() {
        int[] arr = new int[]{4, 7, 8, 10, 3, 7, 10};
        Heap heap = new Heap(arr);
        assertTrue(testIfMaxHeap(arr, 0));
    }

    private boolean testIfMaxHeap(int[] heap, int i) {
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
