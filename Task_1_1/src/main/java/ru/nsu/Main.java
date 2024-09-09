package ru.nsu;

import java.util.Arrays;

/**
 * class for practice to launch java :D.
 */
class Main {
    /**
     * main method which sorts array and prints it.
     *
     * @param args arguments from cli.
     */
    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1};
        HeapSort.heapsort(array);
        System.out.println(Arrays.toString(array));
    }
}
