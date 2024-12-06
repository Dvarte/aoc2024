package org.pedroduarte.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    private static boolean checkCorrectOrder(List<List<Integer>> rules, List<Integer> update) {
        List<Integer> previousPages;
        List<Integer> nextPages;
        boolean goOn = false;

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
        return goOn;
    }

    private static int sumPageNumbers(List<List<Integer>> rules, List<List<Integer>> updates) {
        int sumMiddlePageNumbers = 0;
        boolean goOn;

        for (List<Integer> update : updates) {
            goOn = checkCorrectOrder(rules, update);
            if (goOn) {
                sumMiddlePageNumbers += getMiddleNumber(update);
            }
        }

        return sumMiddlePageNumbers;
    }

    private static List<Integer> orderWrongUpdate(List<Integer> update, List<List<Integer>> rules) {
        List<Integer> previousPages;
        List<Integer> nextPages;
        List<Integer> auxList = new ArrayList<>();
        auxList.addAll(update);

        for (int number : update) {

            previousPages = getPreviousPages(rules, number);
            nextPages = getNextPages(rules, number);

            List<Integer> previousNumbers = auxList.subList(0, auxList.indexOf(number));
            List<Integer> nextNumbers = auxList.subList(auxList.indexOf(number) + 1, auxList.size());

            for (int previousNumber: previousNumbers) {
                if (nextPages.contains(previousNumber)) {
                    Collections.swap(auxList, auxList.indexOf(number), auxList.indexOf(previousNumber));
                }
            }

            for (int nextNumber: nextNumbers) {
                if (previousPages.contains(nextNumber)) {
                    Collections.swap(auxList, auxList.indexOf(number), auxList.indexOf(nextNumber));
                }
            }
        }

        return auxList;
    }

    public static void part1(List<List<Integer>> rules, List<List<Integer>> updates) {
        int sumMiddlePageNumbers = sumPageNumbers(rules, updates);

        System.out.println("Sum of middle page numbers from correctly-ordered updates: " + sumMiddlePageNumbers);
    }

    public static void part2(List<List<Integer>> rules, List<List<Integer>> updates) {
        int sumMiddlePageNumbersWrongUpdates = 0;
        boolean goOn;

        for (List<Integer> update : updates) {
            goOn = checkCorrectOrder(rules, update);
            if (!goOn) {
                sumMiddlePageNumbersWrongUpdates += getMiddleNumber(orderWrongUpdate(update, rules));
            }
        }

        System.out.println("Sum of middle page numbers from correctly-ordered updates: " + sumMiddlePageNumbersWrongUpdates);
    }

}
