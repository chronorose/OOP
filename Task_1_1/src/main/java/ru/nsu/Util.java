package ru.nsu;

public class Util {
    static void swap(int[] array, int i, int j) {
        if (array == null) return;
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }
}
