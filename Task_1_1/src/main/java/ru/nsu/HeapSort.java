package ru.nsu;

class HeapSort {
    /**
     * Implementation of heapsort algorithm. Runs in O(n * log(n)).
     *
     * @param array Array to be sorted.
     * @throws NullPointerException
     */
    public static void heapsort(int[] array) {
        Heap.heapify(array);
        for (int i = array.length - 1; i > 0; i--) {
            Util.swap(array, 0, i);
            Heap.siftDown(array, 0, i);
        }
    }
}
