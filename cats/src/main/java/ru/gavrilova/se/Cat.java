package ru.gavrilova.se;

public class Cat {

    public String name;
    private int appetite;
    private boolean satiety; // сытость

    public Cat(String name) {
        this.name = name;
        this.appetite = 10; //кот может съесть за один раз
        this.satiety = false; // кот голодный
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public boolean toEat(Bowl bowl) {
        if (bowl.getFoodIsThere()) {
            this.satiety = bowl.decreaseFood(this.appetite);
            return this.satiety;
        } else return false;
    }

    public boolean getSatiety() {
        return this.satiety;
    }
}

