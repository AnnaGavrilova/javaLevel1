package ru.gavrilova.se;


import java.util.Random;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Let's play!");
        int continuation = 0;
        do {
            if (guessNumber()) System.out.println("This is victory!");
            else System.out.println("This is a los!");
            System.out.println("Let's do it again? 1 - yes / 0 - no");
            continuation = sc.nextInt();
        }
        while (continuation == 1);
        System.out.println("Goodbye!");
    }

    public static boolean guessNumber() {
        Random rand = new Random();
        int random = rand.nextInt(10);
        System.out.println("Guess the number from 0 to 9:");
        for (int i = 0; i < 3; i++) {
            int input = sc.nextInt();
            if (input >= 0 && input <= 9) {
                if (input == random) return true;
                else {
                    if (input > random) System.out.println("Too much");
                    else System.out.println("Too little");
                }
            } else {
                System.out.println("Wrong number!");
                break;
            }
        }
        return false;
    }


}
