package ru.nsu;

/**
 * {@link Heap} class for max-heap methods for use on array of ints.
 */
public class Heap {
    /**
     * Sifts down element of array from {@code start} index to its correct position,
     * up to the {@code limit} index.
     *
     * @param start index from which to start sifting down.
     * @param limit index on which to forcefully end sifting down.
     * @throws NullPointerException
     */
    public static void siftDown(int[] array, int start, int limit) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        int toSwap = start;

        if (left < limit && array[left] > array[toSwap]) {
            toSwap = left;
        }

        if (right < limit && array[right] > array[toSwap]) {
            toSwap = right;
        }

        if (toSwap != start) {
            Util.swap(array, start, toSwap);
            siftDown(array, toSwap, limit);
        }
    }

    /**
     * Static method, which turns regular array into correct max-heap.
     *
     * @throws NullPointerException
     */
    public static void heapify(int[] array) {
        int middle = (array.length / 2) - 1;
        for (int i = middle; i >= 0; i--) {
            siftDown(array, i, array.length);
        }
    }
}
