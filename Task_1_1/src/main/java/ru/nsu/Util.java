package ru.nsu;

/**
 * Class for utility static methods.
 */
public class Util {
    /**
     * Static method which swaps two elements in int array at indices {@code i} {@code j}.
     *
     * @param array Array in which swaps will be procured
     * @param i     first one to be swapped
     * @param j     second one to be swapped
     * @throws NullPointerException           when passed null into {@code array}.
     * @throws ArrayIndexOutOfBoundsException when elements in indices {@code i} or {@code j} are not present in the array.
     */
    static void swap(int[] array, int i, int j) {
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }
}
