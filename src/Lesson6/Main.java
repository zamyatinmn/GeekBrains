package Lesson6;

public class Main {

    public static void main(String[] args) {

        Cat cat = new Cat("Пушок", 7);
        Dog dog = new Dog("Бобик", 5);
        Dog dog2 = new Dog("Барбос", 6);

        cat.run(222);
        cat.jump(1);
        dog.jump(0.5);
        dog.swim(15);
        cat.swim(41);
        cat.countCats();
        dog.countDogs();
        cat.count();

        dog.run(470);
        dog2.run(600);

    }
}
