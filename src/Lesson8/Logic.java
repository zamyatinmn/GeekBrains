package Lesson8;


import java.util.Random;

public class Logic {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_BLUE = "\u001B[34m";
    static int SIZE = 3;
    static int DOTS_TO_WIN = 3;
    static int difficult = 4;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = ' ';
    static boolean status = false;
    static int winx;
    static int winy;
    static int wina;
    static int winb;
    static char[][] map;
    static int result;

    static Random random = new Random();
    static boolean gameFinished = false;

    public static void go() {
        gameFinished = true;
        if (checkWin(DOT_X)) {
            result = 1;
            return;
        }
        if (isMapFull()) {
            result = 3;
            return;
        }
        if (BattleMap.gameMode == 0){
            aiTurn();
        }
        if (checkWin(DOT_O)) {
            result = 2;
            return;
        }
        if (isMapFull()) {
            result = 3;
            return;
        }
        gameFinished = false;
    }

    public static void createMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    public static void setHumanXY(int x, int y, char dot) {
        if (isCellValid(y, x)) {
            map[y][x] = dot;
            go();
        }
    }

    public static void aiTurn() {
        int x, y;
        status = false;
        switch (difficult) {
            //Смотрит на два хода вперед
            case (4):
                if (SIZE == 3){
                    if (isCellValid(1,1)){
                        map[1][1] = DOT_O;
                        break;
                    }
                }
                //проверка, может ли выиграть сразу
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (isCellValid(i, j)) {
                            map[i][j] = DOT_O;
                            if (checkWin(DOT_O)) {
                                map[i][j] = DOT_O;
                                status = true;
                                break;
                            } else {
                                map[i][j] = DOT_EMPTY;
                            }

                        }
                    }
                    if (status) {
                        break;
                    }
                }
                if (status) {
                    break;
                }
                //мешает выиграть противнику
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (isCellValid(i, j)) {
                            map[i][j] = DOT_X;
                            if (checkWin(DOT_X)) {
                                map[i][j] = DOT_O;
                                status = true;
                                break;
                            } else {
                                map[i][j] = DOT_EMPTY;
                            }
                        }
                    }
                    if (status) {
                        break;
                    }
                }
                if (status) {
                    break;
                }
                //проверка может ли выиграть через два хода
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (isCellValid(i, j)) {
                            map[i][j] = DOT_O;
                            for (int k = 0; k < SIZE; k++) {
                                for (int l = 0; l < SIZE; l++) {
                                    if (isCellValid(k, l)) {
                                        map[k][l] = DOT_O;
                                        if (checkWin(DOT_O)) {
                                            map[k][l] = DOT_EMPTY;
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
                            if (status) {
                                break;
                            }
                            map[i][j] = DOT_EMPTY;
                        }
                    }
                    if (status) {
                        break;
                    }
                }
                if (status) {
                    break;
                }
                //проверка может ли противник выиграть через два хода
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (isCellValid(i, j)) {
                            map[i][j] = DOT_X;
                            if (checkWin(DOT_X)) {
                                map[i][j] = DOT_O;
                                status = true;
                                break;
                            } else {
                                map[i][j] = DOT_EMPTY;
                            }

                        }
                    }
                    if (status) {
                        break;
                    }
                }
                if (!status) {
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
                if (status) {
                    break;
                }
                //Пытается выиграть сам
            case (3):
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (isCellValid(i, j)) {
                            map[i][j] = DOT_O;
                            if (checkWin(DOT_O)) {
                                map[i][j] = DOT_O;
                                status = true;
                                break;
                            } else {
                                map[i][j] = DOT_EMPTY;
                            }

                        }
                    }
                    if (status) {
                        break;
                    }
                }
                if (status) {
                    break;
                }
                //Пытается помешать выиграть противнику
            case (2):
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (isCellValid(i, j)) {
                            map[i][j] = DOT_X;
                            if (checkWin(DOT_X)) {
                                map[i][j] = DOT_O;
                                status = true;
                                break;
                            } else {
                                map[i][j] = DOT_EMPTY;
                            }
                        }
                    }
                    if (status) {
                        break;
                    }
                }
                if (status) {
                    break;
                }
                //рандом
            case (1):
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

    static boolean checkLine(int cy, int cx, int vy, int vx, char dot) {
        if (cx + vx * DOTS_TO_WIN - 1 > SIZE - 1 || cy + vy * DOTS_TO_WIN - 1 > SIZE - 1 ||
                cy + vy * (DOTS_TO_WIN - 1) < 0) {
            return false;
        }

        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            } else {
                wina = cy + i * vy;
                winb = cx + i * vx;
            }
        }
        winx = cx;
        winy = cy;

        return true;
    }

    static boolean checkWin(char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 0, dot) ||
                        checkLine(i, j, 1, 1, dot) || checkLine(i, j, -1, 1, dot)) {
                    return true;
                }
            }
        }
        return false;
    }
}