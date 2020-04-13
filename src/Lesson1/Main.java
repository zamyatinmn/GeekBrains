package Lesson1;

public class Main {
    //Задание 1
    public static void main(String[] args) {
        //Задание 2
        byte a = 1;
        short b = 2;
        int c = 3;
        long d =4l;
        float e = 4.5f;
        double f = 5.5;
        char g = 'g';
        boolean h = true;
        String i = "John";
        Byte j = 6;
        Short k = 7;
        Integer l = 8;
        Long m = 9l;
        Float n = 9.5f;
        Double o = 10.5;
        Character p = 123;
        Boolean q = false;


        System.out.println(firstMethod(a,b,c,c));
        System.out.println(sumInterval(a, b));
        numIsPos(a);
        System.out.println(numIsPosBool(a));
        sayHello(i);
        whatYear(2020);

    }
    //Задание 3
    public static int firstMethod(int a, int b, int c, int d){
        return a * (b + (c / d));
    }
    //Задание 4
    public static boolean sumInterval(int firstNumber, int secondNumber){
        if(firstNumber + secondNumber >= 10 && firstNumber + secondNumber <= 20){
            return true;
        } else{
            return false;
        }
    }
    //Задание 5
    public static void numIsPos(int number){
        if(number >= 0){
            System.out.println(number + " это положительное число");
        }else {
            System.out.println(number + " это отрицательное число");
        }
    }
    //Задание 6
    public static boolean numIsPosBool(int number){
        if(number < 0){
            return true;
        } else{
            return false;
        }
    }
    //Задание 7
    public static void sayHello(String name){
        System.out.println("Привет, " + name + "!");
    }
    //Задание 8
    public static void whatYear(int year){
        if(year % 4 == 0 && year % 100 != 0){
            System.out.println(year + " год является високосным");
        } else if(year % 400 == 0){
            System.out.println(year + " год является високосным");
        } else{
            System.out.println(year + " год является невисокосным");
        }
    }
}
