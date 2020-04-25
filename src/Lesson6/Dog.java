package Lesson6;

import java.util.Random;

public class Dog extends Animal {
    private int count = 0;
    private int maxDistance;
    Random rand = new Random();

    public Dog(String name, int age) {
        super(name, age);
        setCount(1);
        count++;
        maxDistance = rand.nextInt(601) + 400;
    }

    public void info(){
        System.out.println(name + " " + age+ " " + maxDistance);
    }

    @Override
    public void run(int distance) {
        System.out.print(name + " пробежал: " );
        System.out.println(distance <= maxDistance);
    }

    @Override
    public void jump(double height) {
        System.out.print(name + " прыгнул: ");
        System.out.println(height <= 0.5);
    }

    @Override
    public void swim(int distance) {
        System.out.print(name + " проплыл: ");
        System.out.println(distance <= 10);
    }

    public void countDogs(){
        System.out.println("Всего собак: " + count);
    }
}
