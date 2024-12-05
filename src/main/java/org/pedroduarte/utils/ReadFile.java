package org.pedroduarte.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReadFile {

    private ReadFile() {

    }

    public static List<int[]> readIntoListOfIntegers(String file) throws IOException {
        List<int[]> inputList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                inputList.add(Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray());
            }
        }
        return inputList;
    }

    public static String readIntoString(String file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String ls = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
        }
        return stringBuilder.toString();
    }

    public static char[][] readIntoArrayOfChars(String file) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<char[]> dataList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(line.toCharArray());
            }
            return dataList.toArray(new char[0][]);
        }
    }

    public static List<List<Integer>> readPageOrderingRules(String file) throws IOException{
        List<List<Integer>> inputList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while(!Objects.equals(line = br.readLine(), "")) {
                inputList.add(Arrays.stream(line.split("\\|"))
                        .map(Integer::valueOf)
                        .toList());
            }
        }
        return inputList;
    }

    public static List<List<Integer>> readUpdates(String file) throws IOException {
        List<List<Integer>> inputList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                if (line.length() > 5) {
                    inputList.add(Arrays.stream(line.split(","))
                            .map(Integer::valueOf)
                            .toList());
                }
            }
        }
        return inputList;
    }
}
