package ru.nsu;

import java.util.Objects;

/**
 * {@link Heap} class for max-heap
 */
public class Heap {
    int[] array;

    /**
     * Constructs new {@link Heap} object. Makes it into the max-heap during initialization.
     *
     * @param array Array to be heapified and used within {@link Heap} class;
     */
    Heap(int[] array) {
        this.array = Objects.requireNonNullElseGet(array, () -> new int[]{});
        heapify();
    }

    /**
     * Sifts down element of {@link Heap} from {@code start} index to its correct position,
     * up to the {@code limit} index.
     *
     * @param start index from which to start sifting down.
     * @param limit index on which to forcefully end sifting down.
     */
    public void siftDown(int start, int limit) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        int toSwap = start;

        if (left < limit && this.array[left] > this.array[toSwap]) {
            toSwap = left;
        }

        if (right < limit && this.array[right] > this.array[toSwap]) {
            toSwap = right;
        }

        if (toSwap != start) {
            Util.swap(this.array, start, toSwap);
            siftDown(toSwap, limit);
        }
    }

    /**
     * Private method, which turns regular {@link Heap#array} into correct max-heap.
     */
    private void heapify() {
        int middle = (this.array.length / 2) - 1;
        for (int i = middle; i >= 0; i--) {
            siftDown(i, this.array.length);
        }
    }
}
