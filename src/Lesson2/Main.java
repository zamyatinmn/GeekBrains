package Lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        //Задание 1
        int[] arrayInt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i = 0; i < arrayInt.length; i++) {
            if(arrayInt[i] == 0){
                arrayInt[i] = 1;
            } else{
                arrayInt[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arrayInt));

        //Задание 2
        int[] arrNull = new int[8];
        for (int i = 0, m = 0; i < arrNull.length; i++) {
            arrNull[i] = m;
            m += 3;
        }
        System.out.println(Arrays.toString(arrNull));

        //Задание 3
        int[] arrMult = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrMult.length; i++) {
            if(arrMult[i] < 6){
                arrMult[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrMult));

        //Задание 4
        int[][] arr2d = new int[5][5];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                if(i == j){
                    arr2d[i][j] = 1;
                }
                if(i + j == arr2d.length - 1){
                    arr2d[i][j] = 1;
                }
            }

        }
        printArr2d(arr2d);

        //Задание 5
        int[] minMaxArr = getRandomArr(10);
        printArr(minMaxArr);
        int max = 0;
        int min = minMaxArr[0];
        for (int i = 0; i < minMaxArr.length; i++) {
            if(minMaxArr[i] > max){
                max = minMaxArr[i];
            }
            if(minMaxArr[i] < min){
                min = minMaxArr[i];
            }
        }
        System.out.println("Максимальный элемент массива -  " + max);
        System.out.println("Минимальный элемент массива -  " + min);

        //Задание 6
        int[] testArr = {2,2,2,1,2,2,10,1};
        System.out.println(checkBalance(testArr));

        //Задание 7
        displacer(minMaxArr, -3);
        printArr(minMaxArr);
    }

    public static void printArr2d(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int[] getRandomArr(int length){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static boolean checkBalance(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int sumRight = 0;
        int i = arr.length - 1;
        while(sum > sumRight){
            sumRight += arr[i];
            sum -= arr[i];
            i--;
        }
        if(sum == sumRight){
            return true;
        } else{
            return false;
        }
    }

    public static int[] displacer(int[] array, int n){

        while(n > 0){
            int last = array[array.length - 1];
            for (int i = 0; i < array.length; i++) {
                int cur = array[i];
                array[i] = last;
                last = cur;
            }
            n--;
        }
        while(n < 0){
            int last = array[0];
            for (int i = array.length - 1; i >= 0; i--) {
                int cur = array[i];
                array[i] = last;
                last = cur;
            }
            n++;
        }
        return array;
    }

}
