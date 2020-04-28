package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_BLUE = "\u001B[34m";
    static int SIZE = 3;
    static int DOTS_TO_WIN = 3;
    static int DIFFICULT = 3;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = ' ';
    static boolean status = false;

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Игра крестики-нолики.\nВведите размер поля");
        SIZE = sc.nextInt();
        System.out.println("Введите длину выигрышной линии");
        DOTS_TO_WIN = sc.nextInt();
        System.out.println("Введите сложность ИИ\n 1-легко/2-нормально/3-сложно");
        DIFFICULT = sc.nextInt();
        createMap();
        printMap();
        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                printMap();
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                printMap();
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

    public static void createMap() {
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
        System.out.print("  +");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("---+");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            if (i >= 9) {
                System.out.print((i + 1) + "| ");
            } else {
                System.out.print((i + 1) + " | ");
            }
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == 'X') {
                    System.out.print(ANSI_BLUE + map[i][j] + ANSI_RESET + " | ");
                } else if (map[i][j] == 'O') {
                    System.out.print(ANSI_RED + map[i][j] + ANSI_RESET + " | ");
                } else {
                    System.out.print(map[i][j] + " | ");
                }
            }
            System.out.println();
            System.out.print("  +");
            for (int j = 0; j < SIZE; j++) {
                System.out.print("---+");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
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
        status = false;
        switch (DIFFICULT) {
            //Смотрит на два хода вперед
            case(4):
/*


                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if(isCellValid(i, j)){
                            map[i][j] = DOT_O;
                            for (int k = 0; k < SIZE; k++) {
                                for (int l = 0; l < SIZE; l++) {
                                    if(isCellValid(k, l)){
                                        map[k][l] = DOT_O;
                                        if(checkWin(DOT_O)){
                                            map[k][l] = DOT_O;
                                            status = true;
                                            break;
                                        } else{
                                            map[k][l] = DOT_EMPTY;
                                        }

                                    }
                                }
                                if(status){
                                    break;
                                }
                            }
                            if(status) {
                                break;
                            }
                            if(checkWin(DOT_O)){
                                map[i][j] = DOT_O;
                                status = true;
                                break;
                            } else{
                                map[i][j] = DOT_EMPTY;
                            }

                        }
                    }
                    if(status){
                        break;
                    }
                }
                if(status) {
                    break;
                }




                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if(isCellValid(i, j)){
                            map[i][j] = DOT_X;
                            if(checkWin(DOT_X)){
                                map[i][j] = DOT_O;
                                status = true;
                                break;
                            } else{
                                map[i][j] = DOT_EMPTY;
                            }

                        }
                    }
                    if(status){
                        break;
                    }
                }
                if(!status) {
                    for (int a = 0; a < SIZE; a++) {
                        for (int b = 0; b < SIZE; b++) {
                            if (isCellValid(a, b)) {
                                map[a][b] = DOT_X;
                                for (int k = 0; k < SIZE; k++) {
                                    for (int l = 0; l < SIZE; l++) {
                                        if (isCellValid(k, l)) {
                                            map[k][l] = DOT_X;
                                            if (checkWin(DOT_X)) {
                                                map[k][l] = DOT_O;
                                                status = true;
                                                break;
                                            } else {
                                                map[k][l] = DOT_EMPTY;
                                            }
                                        }
                                    }
                                    if (status) {
                                        break;
                                    }
                                }
                                map[a][b] = DOT_EMPTY;
                            }
                            if (status) {
                                break;
                            }
                        }
                        if (status) {
                            break;
                        }
                    }
                }
                if(status){
                    break;
                }*/
                //Пытается выиграть сам
            case(3):
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if(isCellValid(i, j)){
                            map[i][j] = DOT_O;
                            if(checkWin(DOT_O)){
                                map[i][j] = DOT_O;
                                status = true;
                                break;
                            } else{
                                map[i][j] = DOT_EMPTY;
                            }

                        }
                    }
                    if(status){
                        break;
                    }
                }
                if(status) {
                    break;
                }
                //Пытается помешать выиграть противнику
            case(2):
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if(isCellValid(i, j)){
                            map[i][j] = DOT_X;
                            if(checkWin(DOT_X)){
                                map[i][j] = DOT_O;
                                status = true;
                                break;
                            } else{
                                map[i][j] = DOT_EMPTY;
                            }
                        }
                    }
                    if(status){
                        break;
                    }
                }
                if(status){
                    break;
                }
            case(1):
                do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
                map[x][y] = DOT_O;
                break;
        }
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
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

    public static boolean checkDiagonal(char symb, int offsetX, int offsetY) {
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            toright &= (map[i + offsetX][i + offsetY] == symb);
            toleft &= (map[DOTS_TO_WIN - i + offsetX - 1][i + offsetY] == symb);
        }
        return toright || toleft;
    }

    public static boolean checkLines(char symb, int offsetX, int offsetY) {
        boolean cols, rows;
        for(int col = offsetX; col < DOTS_TO_WIN + offsetX; col++){
            cols = true;
            rows = true;
            for(int row = offsetY; row < DOTS_TO_WIN + offsetY; row++){
                cols &= (map[col][row] == symb);
                rows &= (map[row][col] == symb);
            }
            if (cols || rows) return true;
        }
        return false;
    }

    public static boolean checkWin(char symb) {
        for(int col = 0; col <= SIZE - DOTS_TO_WIN; col++){
            for(int row = 0; row <= SIZE - DOTS_TO_WIN; row++){
                if (checkDiagonal(symb, col, row) || checkLines(symb, col, row)) return true;
            }
        }
        return false;
    }
}