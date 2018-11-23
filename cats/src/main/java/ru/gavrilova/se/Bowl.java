package ru.gavrilova.se;

import java.util.Scanner;

public class Bowl {

    private static Scanner sc = new Scanner(System.in);
    private int volume; // объем миски
    private boolean foodIsThere; //есть ли еда в миске

    public Bowl(int volume) {//миска создается с едой
        this.volume = volume;
        this.foodIsThere = true;
    }

    public boolean decreaseFood(int quantity) { //возвращает true, если в миске хватило еды
        if (this.volume >= quantity) {
            this.volume -= quantity;
            return true;
        } else {
            this.foodIsThere = false;
            return false;
        }
    }

    public boolean getFoodIsThere() {// возвращает информацию есть ли в миске еда
        return foodIsThere;
    }

    public void fillingBowl() { //наполнение миски едой
        System.out.println("How many food to put in a bowl?");
        int amountOfFood = sc.nextInt();

        if (amountOfFood > 0) {
            this.foodIsThere = true;
            this.volume += amountOfFood;
            System.out.println("Now in a bowl is " + volume + " food");
        } else {
            System.out.println("No food in a bowl!");
        }
    }


}
