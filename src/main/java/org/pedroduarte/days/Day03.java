package org.pedroduarte.days;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    private static String REGEX = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";

    private static List<String> getMults(String file) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(file);
        return matcher.results().map(MatchResult::group).toList();
    }

    private static int multiplyNumbers(String input) {
        return Integer.parseInt(input.substring(4, input.indexOf(','))) * Integer.parseInt(input.substring(input.indexOf(',') + 1, input.length() - 1));
    }

    public static void part1(String file) {
        int result = getMults(file).stream().mapToInt(Day03::multiplyNumbers).sum();
        System.out.println("Result of all multiplications is: " + result);
    }
}
