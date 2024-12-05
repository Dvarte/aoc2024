package org.pedroduarte.days;

import java.util.ArrayList;
import java.util.List;

public class Day05 {

    private static int getMiddleNumber(List<Integer> listOfInts) {
        return listOfInts.get((listOfInts.size()/2));
    }

    private static List<Integer> getPreviousPages (List<List<Integer>> rules, int pageNumber) {
        List<Integer> previousPages = new ArrayList<>();
        for (int i = 0; i < rules.size(); i++) {
            if (rules.get(i).get(1) == pageNumber) {
                previousPages.add(rules.get(i).get(0));
            }
        }
        return previousPages;
    }

    private static List<Integer> getNextPages (List<List<Integer>> rules, int pageNumber) {
        List<Integer> nextPages = new ArrayList<>();
        for (int i = 0; i < rules.size(); i++) {
            if (rules.get(i).get(0) == pageNumber) {
                nextPages.add(rules.get(i).get(1));
            }
        }
        return nextPages;
    }

    private static boolean compareLists(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list2.size(); i++) {
            if (!list1.contains(list2.get(i))) {
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

        for (int j = 0; j < updates.size(); j++) {
            for (int i = 0; i < updates.get(j).size(); i++) {
                previousPages = getPreviousPages(rules, updates.get(j).get(i));
                nextPages = getNextPages(rules, updates.get(j).get(i));

                if (i == 0) {
                    if (compareLists(nextPages, updates.get(j).subList(1, updates.get(j).size()))) {
                        goOn = true;
                    } else {
                        goOn = false;
                    }
                } else if (i == updates.get(j).size() - 1) {
                    if (goOn && compareLists(previousPages, updates.get(j).subList(0, updates.get(j).size() - 1))) {
                        goOn = true;
                    } else {
                        goOn = false;
                    }
                } else {
                    if (goOn && compareLists(previousPages, updates.get(j).subList(0, updates.get(j).indexOf(updates.get(j).get(i))))
                            && compareLists(nextPages, updates.get(j).subList(updates.get(j).indexOf(updates.get(j).get(i)) + 1, updates.get(j).size()))) {
                        goOn = true;
                    } else {
                        goOn = false;
                    }
                }
            }
            if (goOn) {
                sumMiddlePageNumbers += getMiddleNumber(updates.get(j));
            }
        }

        System.out.println("Sum of middle page numbers from correctly-ordered updates: " + sumMiddlePageNumbers);
    }
}
