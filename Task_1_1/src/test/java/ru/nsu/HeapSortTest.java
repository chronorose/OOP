package ru.nsu;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortTest {
    void universalHeapTest(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HeapSort.heapsort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void testHeapSort() {
        int[] arr = new int[]{4, 7, 8, 10, 3, 7, 10};
        universalHeapTest(arr);
    }

    @Test
    void testHeapSortSingleElem() {
        int[] arr = new int[]{1};
        universalHeapTest(arr);
    }

    @Test
    void testHeapSortNull() {
        int[] arr = null;
        HeapSort.heapsort(arr);
        assertArrayEquals(null, arr);
    }

    @Test
    void testHeapSortNegative() {
        int[] arr = new int[]{-10, -3, -3490, 300, 490, 5000, 695, 777};
        universalHeapTest(arr);
    }

    @Test
    void testHeapSortABitBigger() {
        int[] arr = generateArray(1000000);
        universalHeapTest(arr);
    }

    int[] generateArray(int amount) {
        int[] arr = new int[amount];
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
}
