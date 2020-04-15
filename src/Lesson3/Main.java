package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        int answer;
        do {
            System.out.println("Давайте сыграем в игру. Угадайте число от 0 до 9. У вас три попытки");
            gameNumbers();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            answer = sc.nextInt();
        } while (answer != 0);

        System.out.println("А теперь давайте сыграем в другую игру. Попробуйте угадать слово");
        gameWords();
    }

    public static void gameNumbers(){
        int number = random.nextInt(10);
        int tryCount = 3;
        while (true){
            if(tryCount == 0){
                System.out.println("Вы проиграли");
                break;
            }
            System.out.println("Введите число");
            int userNumber = sc.nextInt();

            if (userNumber == number) {
                System.out.println("Поздравляю, вы победили!");
                break;
            } else if (userNumber > number) {
                System.out.println("Вы ввели слишком большое число");
            } else if (userNumber < number) {
                System.out.println("Вы ввели слишком маленькое число");
            }
            tryCount--;

        }

    }
    public static void gameWords(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int i = random.nextInt(25);
        String word = words[i];
        int length;
        String result;
        StringBuilder sb = new StringBuilder();
        sb.append("###############");
        do{
        System.out.println("Введите свой вариант ответа");
        String userWord = sc.next();
        userWord = userWord.toLowerCase();
        length = Math.min(word.length(), userWord.length());
        for (int j = 0; j < length; j++) {
            char a = word.charAt(j);
            char b = userWord.charAt(j);
            if(a == b){
                sb.setCharAt(j, a);
            }
        }
        result = sb.toString();
        System.out.println(result);
        }
        while(!word.equalsIgnoreCase(result.substring(0, length)));
        System.out.println("Поздравляю! Вы победили!");
    }
}
