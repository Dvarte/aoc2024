package org.pedroduarte;

import org.pedroduarte.days.Day01;
import org.pedroduarte.days.Day02;
import org.pedroduarte.days.Day03;
import org.pedroduarte.days.Day04;
import org.pedroduarte.utils.ReadFile;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // ******************* Day 01 ********************
        // Part 1
        // String file = "./src/main/resources/day01.txt";
        // Day01.part1(ReadFile.readIntoListOfIntegers(file));
        // Part 2
        // Day01.part2(ReadFile.readIntoListOfIntegers(file));

        // ******************* Day 02 *******************
        // Part 1
        // String file = "./src/main/resources/day02.txt";
        // Day02.part1(ReadFile.readIntoListOfIntegers(file));
        // Part 2
        // Day02.part2(ReadFile.readIntoListOfIntegers(file));

        // ******************* Day 03 *******************
        // Part 1
        // String file = "./src/main/resources/day03.txt";
        // Day03.part1(ReadFile.readIntoString(file));
        // Part 2
        // Day03.part2(ReadFile.readIntoString(file));

        // ******************* Day 04 *******************
        // Part 1
        String file = "./src/main/resources/day04.txt";
        Day04.part1(ReadFile.readIntoArrayOfChars(file));
    }
}