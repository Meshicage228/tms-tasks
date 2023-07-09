package org.example;

import java.util.Arrays;

import java.util.Scanner;

public class ArrayTasks {
    public static void main(String[] args) {
                /*  Массивы  */
        ArrayTasks tasks = new ArrayTasks();

        int[] arr;
        int[] arr2;

        //0. Проверка на вхождение числа

        arr = new int[10];

        FillAndShowArray(arr);

        System.out.print("Write number, which you want to find : ");

        int index = tasks.NumberExistsOrNot(arr, EnterNumber());

        if (index == -1) System.out.println("That number doesnt exist");
        else System.out.println("Number exists");

        //1. Удаление всех вхождений введенного числа

        arr = new int[12];
        int toDelete;

        FillAndShowArray(arr);

        do {
            System.out.print("Write number, which you want to delete : ");
            toDelete = EnterNumber();
            index = tasks.NumberExistsOrNot(arr, toDelete);
            if (index == -1) System.out.println("Number doesnt exist");
        } while (index == -1);

        tasks.DeleteAllMatches(arr, toDelete);

        //2. Максимальное / Минимальное / Среднее значение массива с введенным размером

        int size;
        do {
            System.out.print("Write size of array : ");
            size = EnterNumber();
        } while (size <= 0);

        arr = new int[size];
        FillAndShowArray(arr);
        tasks.ShowMaxMinMiddleValue(arr);

        //3. Сравнение среднего значения двух массивов

        arr = new int[5];
        arr2 = new int[5];

        FillAndShowArray(arr);
        FillAndShowArray(arr2);

        tasks.CompareTwoArrays(arr, arr2);

        /*  Дополнительные задачи  */

        //4. Массив из четных элементов другого массива

        for(;;){
            System.out.print("Write size of array : ");
            size = EnterNumber();
            if(size > 5 && size <= 10) break;
            else System.out.println("Incorrect size");
        }
        arr = new int[size];
        FillAndShowArray(arr);

        System.out.println(tasks.CreateEvenArray(arr));

        //5. Замена элементов с нечетным индексом на 0

        arr = new int[10]; FillAndShowArray(arr);

        tasks.RebuildArrayToZero(arr);

        //6. Сортировка массива строк

        String[] names = new String[]{"Vlad", "Zhenya", "Stepan", "Olya", "Anton"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));

        //7. Сортировка пузырьком

        arr = new int[10]; FillAndShowArray(arr);
        tasks.BubbleSort(arr);
    }
            /*  Методы  */
    public int NumberExistsOrNot(int[] arr, int key) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void DeleteAllMatches(int[] src, int key) {
        int size = 0;

        for (int j : src) {
            if (j != key) size++;
        }
        int[] dest = new int[size];
        size = 0;
        for (int j : src) {
            if (j != key) {
                dest[size++] = j;
            }
        }
        System.out.println("Array without that number : " + Arrays.toString(dest));
    }
    public void ShowMaxMinMiddleValue(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        float middleValue = 0;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
            if (min > arr[i]) min = arr[i];
            middleValue += arr[i];
        }
        System.out.println("Max value is : " + max + "; min value is : " + min + "; middleValue is : " + middleValue / arr.length);
    }
    public void CompareTwoArrays(int[] arr1, int[] arr2) {
        float sum1 = 0;
        float sum2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        sum1 /= arr1.length;
        sum2 /= arr1.length;

        if (sum1 > sum2) System.out.println("First array bigger than second one");
        else if (sum1 < sum2) System.out.println("Second array bigger than first one");
        else System.out.println("These arrays are equal");
    }
    public String CreateEvenArray(int[] src){
        int counter = 0;
        for(int j : src){
            if(j % 2 == 0) counter++;
        }
        if(counter == 0) return "This array doesnt contain even numbers";
        else {
            int[] evenArray = new int[counter];
            counter = 0;
            for(int j : src){
                if(j % 2 == 0)
                    evenArray[counter++] = j;
            }
            return "Even array : " + Arrays.toString(evenArray);
        }
    }
    public void RebuildArrayToZero(int[] arr){
        for(int i = 1; i < arr.length; i += 2)
            arr[i] = 0;
        System.out.println(Arrays.toString(arr));
    }
    public void BubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - 1 - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int swap = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = swap;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void FillAndShowArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 100 - 10);
        System.out.println(Arrays.toString(arr));
    }
    public static int EnterNumber() {
        return new Scanner(System.in).nextInt();
    }
}