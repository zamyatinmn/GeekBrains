package Lesson5;

public class Staff {
    static final String GR = "\u001B[32m";
    static final String RES = "\u001B[0m";
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Staff() {
        this("Unnamed");
    }

    public Staff(String fullName) {
        this.fullName = fullName;
        this.position = "unpositioned";
        this.email = "@mail.ru";
        this.phoneNumber = "89---------";
        this.salary = 0;
        this.age = 18;
    }

    public Staff(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    /**
     * Выводит всю информацию о работнике в консоль
     */
    public void info(){
        System.out.printf(GR + "ФИО:" + RES + "%25s\t" + GR + "Должность:" + RES + "%13s\t" + GR + "Email:" + RES +
                "%17s\t" + GR + "Телефон:" + RES + "%11s\t" + GR + "З/П:" + RES + "%6d\t" + GR + "Возраст:" + RES +
                "%2d\n", fullName, position, email, phoneNumber, salary, age);
    }

    /**
     * Возвращает возраст работника
     * @return age
     */
    public int getAge() {
        return age;
    }
}
