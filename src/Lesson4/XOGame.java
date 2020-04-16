package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";
    static final int SIZE = 3;
//    static final int DOTS_TO_WIN = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = ' ';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        createMap();
        printMap();
        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

        }

        System.out.println("Игра закончена");
    }

    public static void createMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    public static void printMap() {
        System.out.print("    ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        System.out.println("  +---+---+---+");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < SIZE; j++) {
                if(map[i][j] == 'X'){
                    System.out.print(ANSI_BLUE + map[i][j] + ANSI_RESET + " | ");
                } else if(map[i][j] == 'O'){
                    System.out.print(ANSI_RED + map[i][j] + ANSI_RESET + " | ");
                }else {
                    System.out.print(map[i][j] + " | ");
                }
            }
            System.out.println();
            System.out.println("  +---+---+---+");
        }
        System.out.println();
    }

    public static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите номер строки и номер столбца");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;

    }

    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
//        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static boolean isCellValid(int x, int y){
        if(x < 0 || y < 0 || x >= SIZE || y >= SIZE){
            return false;
        }
        return map[x][y] == DOT_EMPTY;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char symb) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if(map[x][y] == symb && map[x][y + 1] == symb && map[x][y + 2] == symb) return true;
                if(map[x][y] == symb && map[x + 1][y] == symb && map[x + 2][y] == symb) return true;
                if(map[x][y] == symb && map[x + 1][y + 1] == symb && map[x + 2][y + 2] == symb) return true;
                if(map[x][y] == symb && map[x - 1][y + 1] == symb && map[x - 2][y + 2] == symb) return true;
            }
        }


        return false;
    }


}
