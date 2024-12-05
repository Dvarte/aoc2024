package org.pedroduarte.days;

public class Day04 {

    private static boolean checkHorizontal1(char[][] input, int i, int j) {
        try {
             if (input[j][i] == 'X' && input[j][i + 1] == 'M' && input[j][i + 2] == 'A' && input[j][i + 3] == 'S') {
                 return true;
             }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static boolean checkHorizontal2(char[][] input, int i, int j) {
         try {
             if (input[j][i] == 'X' && input[j][i - 1] == 'M' && input[j][i - 2] == 'A' && input[j][i - 3] == 'S') {
                 return true;
             }
         } catch (Exception e) {
             return false;
         }
        return false;
    }

    private static boolean checkVertical1(char[][] input, int i, int j) {
        try {
            if (input[j][i] == 'X' && input[j + 1][i] == 'M' && input[j + 2][i] == 'A' && input[j + 3][i] == 'S') {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static boolean checkVertical2(char[][] input, int i, int j) {
        try {
            if (input[j][i] == 'X' && input[j - 1][i] == 'M' && input[j - 2][i] == 'A' && input[j - 3][i] == 'S') {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static boolean checkDiagonal1(char[][] input, int i, int j) {
       try {
           if (input[j][i] == 'X' && input[j + 1][i + 1] == 'M' && input[j + 2][i + 2] == 'A' && input[j + 3][i + 3] == 'S') {
               return true;
           }
       } catch (Exception e) {
           return false;
       }
        return false;
    }

    private static boolean checkDiagonal2(char[][] input, int i, int j) {
        try {
            if (input[j][i] == 'X' && input[j - 1][i - 1] == 'M' && input[j - 2][i - 2] == 'A' && input[j - 3][i - 3] == 'S') {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static boolean checkDiagonal3(char[][] input, int i, int j) {
        try {
            if (input[j][i] == 'X' && input[j + 1][i - 1] == 'M' && input[j + 2][i - 2] == 'A' && input[j + 3][i - 3] == 'S') {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static boolean checkDiagonal4(char[][] input, int i, int j) {
        try {
           if (input[j][i] == 'X' && input[j - 1][i + 1] == 'M' && input[j - 2][i + 2] == 'A' && input[j - 3][i + 3] == 'S') {
               return true;
           }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static void part1(char[][] input) {
        int xmasCounter = 0;
        for (int j = 0; j < input.length; j++) {
            for (int i = 0; i < input[j].length; i++) {
                if (checkHorizontal1(input, i, j)) {
                    xmasCounter += 1;
                }
                if (checkHorizontal2(input, i, j)) {
                    xmasCounter += 1;
                }
                if (checkVertical1(input, i, j)) {
                    xmasCounter += 1;
                }
                if (checkVertical2(input, i, j)) {
                    xmasCounter += 1;
                }
                if (checkDiagonal1(input, i, j)) {
                    xmasCounter += 1;
                }
                if (checkDiagonal2(input, i, j)) {
                    xmasCounter += 1;
                }
                if (checkDiagonal3(input, i, j)) {
                    xmasCounter += 1;
                }
                if (checkDiagonal4(input, i, j)) {
                    xmasCounter += 1;
                }
            }
        }

        System.out.format("XMAS word appears: %d times", xmasCounter);
    }
}
