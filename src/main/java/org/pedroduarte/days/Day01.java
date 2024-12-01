package org.pedroduarte.days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Day01 {

    private static List<Integer> getLeftNumbers(List<int[]> input) {
        List<Integer> leftNumbers = new ArrayList<>();
        input.forEach(i -> leftNumbers.add(i[0]));
        return leftNumbers;
    }

    private static List<Integer> getRightNumbers(List<int[]> input) {
        List<Integer> rigtNumbers = new ArrayList<>();
        input.forEach(i -> rigtNumbers.add(i[1]));
        return rigtNumbers;
    }

    public static void part1(List<int[]> input) {
        List<Integer> leftOrderedNumbers = getLeftNumbers(input).stream().sorted((Comparator.naturalOrder())).toList();
        List<Integer> rightOrderedNumbers = getRightNumbers(input).stream().sorted((Comparator.naturalOrder())).toList();
        int total = IntStream.range(0, leftOrderedNumbers.size()).map(i -> Math.abs(leftOrderedNumbers.get(i) - rightOrderedNumbers.get(i))).sum();
        System.out.println("Total distance is: " + total);
    }

    public static void part2(List<int[]> input) {
        List<Integer> leftNumbers = getLeftNumbers(input);
        List<Integer> rightNumbers = getRightNumbers(input);
        int total = leftNumbers.stream()
                .mapToInt(num -> num * Collections.frequency(rightNumbers, num))
                .sum();

        System.out.println("Similarity score: " + total);
    }

}
