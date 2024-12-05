package org.pedroduarte.days;

import java.util.List;
import org.apache.commons.lang.ArrayUtils;

public class Day02 {

    public static boolean isSorted(int[] array) {

        boolean ascending = true;
        boolean descending = true;

        if (array.length < 2) {
            return true;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                ascending = false;
            }
            if (array[i] > array[i - 1]) {
                descending = false;
            }
        }
        return ascending || descending;
    }

    public static boolean isSafe(int[] array) {
        boolean safe = true;
        for (int i = 0; i < array.length - 1; ++i) {
            if (Math.abs(array[i] - array[i + 1]) > 3 || Math.abs(array[i] - array[i + 1]) == 0) {
                safe = false;
                break;
            }
        }
        return safe;
    }

    public static boolean isReallySafe(int[] array) {
        boolean reallySafe = true;
        for (int i = 0; i < array.length; i++) {
            int[] auxArray = ArrayUtils.remove(array, i);
            if (isSorted(auxArray) && isSafe(auxArray)) {
                reallySafe = true;
                break;
            } else {
                reallySafe = false;
            }
        }
        return reallySafe;
    }

    public static void part1(List<int[]> input) {
        int safeReports = 0;
        for (int[] array : input) {
            if (isSorted(array)) {
                if (isSafe(array)) {
                    safeReports += 1;
                }
            }
        }
        System.out.println("Safe reports: " + safeReports);
    }

    public static void part2(List<int[]> input) {
        int safeReports = 0;
        for (int[] array : input) {
            if (isSorted(array)) {
                if (isSafe(array)) {
                    safeReports += 1;
                } else {
                    if (isReallySafe(array)) {
                        safeReports += 1;
                    }
                }
            } else {
                if (isReallySafe(array)) {
                    safeReports +=1;
                }
            }
        }
        System.out.println("Safe reports thanks to the Problem Dampener: " + safeReports);
    }
}
