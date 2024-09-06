package ru.nsu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortTest {
    @Test
    void testHeapSort() {
        int[] arr = new int[]{4, 7, 8, 10, 3, 7, 10};
        int[] sorted_arr = new int[]{3, 4, 7, 7, 8, 10, 10};
        HeapSort.heapsort(arr);
        assertArrayEquals(arr, sorted_arr);
    }
}
