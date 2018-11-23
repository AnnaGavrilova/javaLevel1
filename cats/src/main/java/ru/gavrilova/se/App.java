package ru.gavrilova.se;

/**
 * let's feed the cats
 */
public class App {
    public static void main(String[] args) {

        Cat[] arrayOfCats = new Cat[5];

        arrayOfCats[0] = new Cat("Vasily", 20);
        arrayOfCats[1] = new Cat("Semen", 15);
        arrayOfCats[2] = new Cat("Barsik", 20);
        arrayOfCats[3] = new Cat("Sima", 15);
        arrayOfCats[4] = new Cat("Baks", 20);

        Bowl bowl = new Bowl(50);

        for (Cat cat : arrayOfCats) {
            do {
                if (bowl.getFoodIsThere()) {
                    if (cat.toEat(bowl)) System.out.println("Cat " + cat.name + " is full.");
                } else {
                    System.out.println("Little food for a cat " + cat.name + ". He will not eat.");
                    bowl.fillingBowl();
                }
            } while (!cat.getSatiety());
        }
    }
}
