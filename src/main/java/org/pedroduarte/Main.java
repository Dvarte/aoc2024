package org.pedroduarte;

import org.pedroduarte.days.*;
import org.pedroduarte.utils.ReadFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // ******************* Day 01 ********************
        // String file = "./src/main/resources/day01.txt";
        // Part 1
        // Day01.part1(ReadFile.readIntoListOfIntegers(file));
        // Part 2
        // Day01.part2(ReadFile.readIntoListOfIntegers(file));

        // ******************* Day 02 *******************
        // String file = "./src/main/resources/day02.txt";
        // Part 1
        // Day02.part1(ReadFile.readIntoListOfIntegers(file));
        // Part 2
        // Day02.part2(ReadFile.readIntoListOfIntegers(file));

        // ******************* Day 03 *******************
        // String file = "./src/main/resources/day03.txt";
        // Part 1
        // Day03.part1(ReadFile.readIntoString(file));
        // Part 2
        // Day03.part2(ReadFile.readIntoString(file));

        // ******************* Day 04 *******************
        // String file = "./src/main/resources/day04.txt";
        // Part 1
        // Day04.part1(ReadFile.readIntoArrayOfChars(file));
        // Part 2
        // Day04.part2(ReadFile.readIntoArrayOfChars(file));

        // ******************* Day 04 *******************
        // String file = "./src/main/resources/day05.txt";
        // Part 1
        // Day05.part1(ReadFile.readPageOrderingRules(file), ReadFile.readUpdates(file));
        // Part 2
        // Day05.part2(ReadFile.readPageOrderingRules(file), ReadFile.readUpdates(file));

        // ******************* Day 04 *******************
        String file = "./src/main/resources/day06.txt";
        // Part 1
        Day06.part1(ReadFile.readIntoArrayOfChars(file));
        // Part 2
        // Day06.part2(ReadFile.readIntoArrayOfChars(file));
    }
}