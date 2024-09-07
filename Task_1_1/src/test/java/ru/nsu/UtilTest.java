package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class UtilTest {
    @Test
    void testSwap() {
        int[] arr = new int[]{4, 7, 8, 10, 3, 7, 10};
        Util.swap(arr, 0, 4);
        assertArrayEquals(arr, new int[]{3, 7, 8, 10, 4, 7, 10});
    }

    @Test
    void testSwapFirstAndLast() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = new int[]{8, 2, 3, 4, 5, 6, 7, 1};
        Util.swap(arr, 0, arr.length - 1);
        assertArrayEquals(arr, arr2);
    }

    @Test
    void reverseWithSwap() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length / 2; i++) {
            Util.swap(array, i, array.length - i - 1);
        }
        int[] reversed = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(reversed, array);
    }
}
