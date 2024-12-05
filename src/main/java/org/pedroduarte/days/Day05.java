package org.pedroduarte.days;

import java.util.ArrayList;
import java.util.List;

public class Day05 {

    private static int getMiddleNumber(List<Integer> listOfInts) {
        return listOfInts.get((listOfInts.size()/2));
    }

    private static List<Integer> getPreviousPages (List<List<Integer>> rules, int pageNumber) {
        List<Integer> previousPages = new ArrayList<>();
        for (List<Integer> rule : rules) {
            if (rule.get(1) == pageNumber) {
                previousPages.add(rule.get(0));
            }
        }
        return previousPages;
    }

    private static List<Integer> getNextPages (List<List<Integer>> rules, int pageNumber) {
        List<Integer> nextPages = new ArrayList<>();
        for (List<Integer> rule : rules) {
            if (rule.get(0) == pageNumber) {
                nextPages.add(rule.get(1));
            }
        }
        return nextPages;
    }

    private static boolean compareLists(List<Integer> list1, List<Integer> list2) {
        for (Integer integer : list2) {
            if (!list1.contains(integer)) {
                return false;
            }
        }
        return true;
    }

    public static void part1(List<List<Integer>> rules, List<List<Integer>> updates) {
        int sumMiddlePageNumbers = 0;
        boolean goOn = false;
        List<Integer> previousPages;
        List<Integer> nextPages;

        for (List<Integer> update : updates) {
            for (int i = 0; i < update.size(); i++) {
                previousPages = getPreviousPages(rules, update.get(i));
                nextPages = getNextPages(rules, update.get(i));

                if (i == 0) {
                    if (compareLists(nextPages, update.subList(1, update.size()))) {
                        goOn = true;
                    } else {
                        goOn = false;
                    }
                } else if (i == update.size() - 1) {
                    if (goOn && compareLists(previousPages, update.subList(0, update.size() - 1))) {
                        goOn = true;
                    } else {
                        goOn = false;
                    }
                } else {
                    if (goOn && compareLists(previousPages, update.subList(0, update.indexOf(update.get(i))))
                            && compareLists(nextPages, update.subList(update.indexOf(update.get(i)) + 1, update.size()))) {
                        goOn = true;
                    } else {
                        goOn = false;
                    }
                }
            }
            if (goOn) {
                sumMiddlePageNumbers += getMiddleNumber(update);
            }
        }

        System.out.println("Sum of middle page numbers from correctly-ordered updates: " + sumMiddlePageNumbers);
    }

    public static void part2() {

    }
}
