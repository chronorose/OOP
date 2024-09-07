package ru.nsu;

public class Util {
    /**
     * Static method which swaps two elements in int array at indices {@code i} {@code j}.
     *
     * @param array Array in which swaps will be procured
     * @param i     first one to be swapped
     * @param j     second one to be swapped
     */
    static void swap(int[] array, int i, int j) {
        if (array == null) {
            return;
        }
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }
}
