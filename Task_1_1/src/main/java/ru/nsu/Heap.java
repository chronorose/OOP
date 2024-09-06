package ru.nsu;

public class Heap {
    int[] array;
    /**
     * Constructs new {@link Heap} object. Makes it into the max-heap during initialization.
     * @param array Array to be heapified and used within {@link Heap} class;
    */
    Heap(int[] array) {
        if (array == null) {
            this.array = new int[] {};
        } else {
            this.array = array;
        }
        heapify();
    }

    /**
     * Sifts down element of {@link Heap} from {@code start} index to its correct position,
     * up to the {@limit} index. 
     * @param start index from which to start sifting down.
     * @param limit index on which to forcefully end sifting down.
    */
    public void siftDown(int start, int limit) {
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        int new_i = start;
        
        if (left < limit && this.array[left] > this.array[new_i]) {
            new_i = left;
        }

        if (right < limit && this.array[right] > this.array[new_i]) {
            new_i = right;
        }

        if (new_i != start) {
            Util.swap(this.array, start, new_i);
            siftDown(new_i, limit);
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
