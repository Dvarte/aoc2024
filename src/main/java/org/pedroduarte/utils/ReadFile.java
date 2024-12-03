package org.pedroduarte.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    private ReadFile() {

    }

    public static List<int[]> readIntoArrayList(String file) throws IOException {
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
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
        }
        return stringBuilder.toString();
    }
}
