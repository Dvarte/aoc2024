package org.pedroduarte.days;

public class Day06 {

    private static int y;
    private static int x;
    private static char[][] globalMap;
    private static int moves;

    private static void moveUp() {
        while (globalMap[y - 1][x] != '#') {
            y -= 1;
            if (globalMap[y][x] != 'X') {
                moves += 1;
                globalMap[y][x] = 'X';
            }
        }
    }

    private static void moveRight() {
        while (globalMap[y][x + 1] != '#') {
            x += 1;
            if (globalMap[y][x] != 'X') {
                moves += 1;
                globalMap[y][x] = 'X';
            }
        }
    }

    private static void moveDown() {
        while (globalMap[y + 1][x] != '#') {
            y += 1;
            if (globalMap[y][x] != 'X') {
                moves += 1;
                globalMap[y][x] = 'X';
            }
        }
    }

    private static void moveLeft() {
        while (globalMap[y][x - 1] != '#') {
            x -= 1;
            if (globalMap[y][x] != 'X') {
                moves += 1;
                globalMap[y][x] = 'X';
            }
        }
    }

    private static int[] locatePosition(char[][] map) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == '^') {
                    return new int[]{y, x};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void part1(char[][] map) {
        globalMap = map;
        int[] coords = locatePosition(globalMap);
        globalMap[coords[0]][coords[1]] = 'X';
        y = coords[0];
        x = coords[1];

        moves = 0;

        try {
            while (y != 9 || x != 9) {
                moveUp();
                moveRight();
                moveDown();
                moveLeft();
            }
        } catch (Exception e) {
            System.out.println("Guard is out of the map.");
            moves += 1;
        }

        System.out.println("Number of distinct positions the guard will visit: " + moves);
    }

    public static void part2(char[][] chars) {
        System.out.println("Prueba");
    }
}
