package Lesson6;

public class Cat extends Animal {
    private int count = 0;
    public Cat(String name, int age) {
        super(name, age);
        setCount(1);
        count++;
    }

    @Override
    public void run(int distance) {
        System.out.print(name + " пробежал: " );
        System.out.println(distance <= 200);
    }

    @Override
    public void jump(double height) {
        System.out.print(name + " прыгнул: ");
        System.out.println(height <= 2);
    }

    @Override
    public void swim(int distance) {
        System.out.print(name + " проплыл: ");
        System.out.println(false);
    }

    public void countCats(){
        System.out.println("Всего кошек: " + count);
    }
}
