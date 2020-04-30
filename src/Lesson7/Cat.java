package Lesson7;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    Random rand = new Random();

    public Cat(String name) {
        this.name = name;
        appetite = rand.nextInt(50);
    }

    /**
     * Метод позволяющий котику покушать из
     * @param plate откуда кушать
     */
    public void eat(Plate plate){
        if(plate.getFood(appetite)){
            satiety = true;
        } else {
            System.out.println("Фу, гречка");
        }

    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
