package org.pedroduarte.days;

import java.util.List;

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

    public static void part1(List<int[]> input) {
        boolean aux = true;
        int safeReports = 0;
        for (int[] array : input) {
            if (isSorted(array)) {
                for (int i = 0; i < array.length - 1; ++i) {
                    aux = true;
                    if (Math.abs(array[i] - array[i + 1]) > 3 || Math.abs(array[i] - array[i + 1]) == 0) {
                        aux = false;
                        break;
                    }
                }
                if (aux) {
                    safeReports += 1;
                }
            }
        }
        System.out.println("Safe reports: " + safeReports);
    }

    public static void part2(List<int[]> input) {

    }
}
