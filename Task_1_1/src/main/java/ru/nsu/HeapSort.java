package ru.nsu;

class HeapSort {
    /**
     * Implementation of heapsort algorithm. Runs in O(n * log(n)).
     *
     * @param array Array to be sorted.
     */
    public static void heapsort(int[] array) {
        if (array == null) {
            return;
        }
        Heap heap = new Heap(array);
        for (int i = heap.array.length - 1; i > 0; i--) {
            Util.swap(heap.array, 0, i);
            heap.siftDown(0, i);
        }
        heap.array = null;
    }
}
