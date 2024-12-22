package ru.nsu;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * class with util methods.
 */
public class Util {
    /**
     * method that append prefix to all lines of string.
     */
    public static String appendPrefix(String prefix, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        new BufferedReader(new StringReader(str))
                .lines()
                .map(line -> prefix + line + System.lineSeparator())
                .forEach(stringBuilder::append);

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    /**
     * method that appends postfix to all lines of string.
     */
    public static String appendPostfix(String postfix, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        new BufferedReader(new StringReader(str))
                .lines()
                .map(line -> line + postfix + System.lineSeparator())
                .forEach(stringBuilder::append);

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
