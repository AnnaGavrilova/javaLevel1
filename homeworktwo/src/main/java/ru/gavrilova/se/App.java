package ru.gavrilova.se;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        changeArray();
        fillArray();
        multiplyArray();
        fillDiagonalArray();
        findMaxAndMin();
        ShiftArray();
    }


    public static void changeArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fillArray() {
        int[] array = new int[8];
        for (int i = 0, j = 0; i < array.length; i++, j = j + 3) {
            array[i] = j;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void multiplyArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fillDiagonalArray() {
        int[][] table = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    table[i][j] = 1;
                }
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findMaxAndMin() {
        int[] array = {3, 10, 0, 15, 9, 3, 8};
        int min, max;
        min = max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }

    public static void ShiftArray() {
        int[] array = {2, 4, 7, 15, 8, 1, 5};
        int n = 3;
        int length = array.length - 1;
        if (n > 0) {
            for (int i = length; i >= 0; i--) {
                int j = i - n;
                if (j >= 0) {
                    array[i] = array[j];
                } else {
                    array[i] = 0;
                }
            }
        } else if (n < 0) {
            for (int i = 0; i < array.length; i++) {
                int j = i + Math.abs(n);
                if (j < array.length) {
                    array[i] = array[j];
                } else {
                    array[i] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
