package Lesson6;

public class Animal {
    protected String name;
    protected int age;
    private int count = 0;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public void run(int distance){
        System.out.println(name + " пробежал " + distance + "м");
    }

    public void jump(double height){
        System.out.println(name + " прыгнул на " + height + "м");
    }

    public void swim(int distance){
        System.out.println(name + " проплыл " + distance + "м");
    }

    public void count(){
        System.out.println("Всего создано животных: " + count);
    }

    public void setCount(int count) {
        this.count += count;
    }
}