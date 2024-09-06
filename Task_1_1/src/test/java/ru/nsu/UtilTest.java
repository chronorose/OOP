package ru.nsu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

class UtilTest {
    @Test
    void testSwap() {
        int[] arr = new int[] {4, 7, 8, 10, 3, 7, 10};
        Util.swap(arr, 0, 4);
        assertTrue(Arrays.equals(arr, new int[] {3, 7, 8, 10, 4, 7, 10}));
    }
}
