package ru.gavrilova.se;

import java.util.Random;
import java.util.Scanner;

/**
 * Tic tac toe game.
 */
public class App {
    public static char[][] field;
    public static int size;
    public static int dotsToWin;
    public static final char dotEmpty = '.';
    public static final char dotX = 'X';
    public static final char dot0 = '0';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();


    public static void main(String[] args) {
        go();
    }

    public static void go() {
        customizeGame();
        initializationField();
        printField();
        while (true) {
            playHuman();
            printField();
            if (chekWin(dotX)) {
                System.out.println("The human von!");
                break;
            }
            if (fieldIsFull()) {
                System.out.println("It is draw.");
                break;
            }
            playComputer();
            printField();
            if (chekWin(dot0)) {
                System.out.println("The computer von!");
                break;
            }
            if (fieldIsFull()) {
                System.out.println("It is draw.");
                break;
            }
        }
        System.out.println("Game over.");
    }

    public static void customizeGame() {
        do {
            System.out.print("Enter the size of field: from 3 to 10:");
            size = sc.nextInt();
        } while (size < 3 || size > 10);
        do {
            System.out.print("How many dots to vin? From 3 to " + size + " :");
            dotsToWin = sc.nextInt();
        } while (dotsToWin < 3 || dotsToWin > size);
    }

    public static void initializationField() {
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = dotEmpty;
            }
        }
    }

    public static void printField() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean fieldIsFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == dotEmpty) return false;
            }
        }
        return true;
    }

    public static void playHuman() {
        int x, y;
        do {
            System.out.println("Enter coordinates X, Y:");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        field[y][x] = dotX;
    }

    public static boolean isCellEmpty(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        if (field[x][y] == dotEmpty) return true;
        return false;
    }

    public static void playComputer() {
        int x, y;
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (!isCellEmpty(x, y));
        System.out.println("The computer went to a point" + (x + 1) + " " + (y + 1));
        field[x][y] = dot0;
    }

    public static boolean chekWin(char symb) {
        for (int i = 0; i < size - dotsToWin + 1; i++) {
            for (int j = 0; j < size - dotsToWin + 1; j++) {
                if (checkDiagonal(symb, i, j) || checkLine(symb, i, j)) return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonal(char symb, int x, int y) {
        boolean leftToRight = true;
        boolean rightToLeft = true;
        for (int i = 0; i < dotsToWin; i++) {
            leftToRight &= (field[i + x][i + y] == symb);
            rightToLeft &= (field[dotsToWin - i - 1 + x][i + y] == symb);
        }
        return leftToRight || rightToLeft;
    }

    public static boolean checkLine(char symb, int x, int y) {
        for (int i = x; i < dotsToWin + x; i++) {
            boolean cols = true;
            boolean rows = true;
            for (int j = y; j < dotsToWin + y; j++) {
                cols &= (field[i][j] == symb);
                rows &= (field[j][i] == symb);
            }
            if (cols || rows) return true;
        }
        return false;
    }
}
