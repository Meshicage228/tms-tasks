package org.example;

import java.util.Arrays;

import java.util.Scanner;

public class ArrayTasks {
    public static void main(String[] args) {
                /*  Массивы  */
        ArrayTasks tasks = new ArrayTasks();

        int[] arr;
        int[] arr2 = new int[0];

       //1. Проверка на вхождение числа

        arr = new int[10];

        FillAndShowArray(arr);

        System.out.print("Write number, which you want to find : ");

        int index = tasks.NumberExistsOrNot(arr, EnterNumber());

        if(index == -1) System.out.println("That number doesnt exist");
        else System.out.println("Number exists");

        //2. Удаление всех вхождений введенного числа

        arr = new int[12];
        int toDelete;

        FillAndShowArray(arr);

        do{
            System.out.print("Write number, which you want to delete : ");
            toDelete = EnterNumber();
            index = tasks.NumberExistsOrNot(arr, toDelete);
            if(index == -1) System.out.println("Number doesnt exist");
        }while(index == -1);

        tasks.DeleteAllMatches(arr, arr2, toDelete);

        //3. Максимальное / Минимальное / Среднее значение массива с введенным размером

        int size = 0;
        do{
            System.out.print("Write size of array : ");
            size = EnterNumber();
        }while (size <= 0);

        arr = new int[size];
        FillAndShowArray(arr);
        tasks.ShowMaxMinMiddleValue(arr);

        //4. Сравнение среднего значения двух массивов

        arr = new int[5];
        arr2 = new int[5];

        FillAndShowArray(arr);
        FillAndShowArray(arr2);

        tasks.CompareTwoArrays(arr, arr2);
    }
            /*  Методы  */
    public int NumberExistsOrNot(int[] arr, int key){
        int index = -1;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void DeleteAllMatches(int[] src, int[]dest, int key){
        int size = 0;

        for (int j : src) {
            if (j != key) size++;
        }
        dest = new int[size];
        size = 0;
        for (int j : src) {
            if (j != key) {
                dest[size++] = j;
            }
        }
        System.out.println("Array without that number : " + Arrays.toString(dest));
    }
    public void ShowMaxMinMiddleValue(int[] arr){
        int max = arr[0];
        int min = arr[0];
        float middleValue = 0;
        for(int i = 1 ; i < arr.length; i++){
            if(max < arr[i]) max = arr[i];
            if(min > arr[i]) min = arr[i];
            middleValue += arr[i];
        }
        System.out.println("Max value is : " + max + "; min value is : " + min + "; middleValue is : " + middleValue / arr.length);
    }
    public void CompareTwoArrays(int[] arr1, int[] arr2){
        float sum1 = 0;
        float sum2 = 0;
        for(int i = 0; i < arr1.length; i++){
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        sum1 /= arr1.length;
        sum2 /= arr1.length;

        if(sum1 > sum2) System.out.println("First array bigger than second one");
        else if(sum1 < sum2) System.out.println("Second array bigger than first one");
        else System.out.println("These arrays are equal");
    }
    public static void FillAndShowArray(int[] arr){
        for(int i = 0; i < arr.length; i++)
            arr[i] = (int)(Math.random()* 100 - 10);
        System.out.println(Arrays.toString(arr));
    }
    public static int EnterNumber(){
        return new Scanner(System.in).nextInt();
    }
}