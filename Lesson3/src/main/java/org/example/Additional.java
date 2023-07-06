package org.example;

import java.util.Scanner;

public class Additional {
    public static void main(String[] args) {
        /*  Дополнительные задания  */
        Additional tasks = new Additional();

        //1. Таблица умножения

        tasks.ShowMultiplicationTable();

        //2. Первые 11 чисел Фибоначи

        tasks.FibonacciNumbers();

        //3. Задача про процент и банк

        tasks.BankDepositPerMonth();

    }
    public void ShowMultiplicationTable(){
        for(int i = 1; i < 11; i++){
            for(int j = 1 ; j < 11; j++){
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
    public void FibonacciNumbers(){
        int firstNumber = 0, secondNumber = 1, numberToShow;
        System.out.print(firstNumber + " " + secondNumber + " ");

        for(int i = 0; i!= 9; i++){
            numberToShow = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = numberToShow;
            System.out.print(numberToShow + " ");
        }
    }
    public void BankDepositPerMonth(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Write amount of money : ");
        float depositAmount = scan.nextFloat();

        System.out.print("Write number of months : ");
        int months = scan.nextInt();

        float moneyForMonth = depositAmount / months;
        float totalAmount = 0;

        for(int i = 0; i < months; i++){
            moneyForMonth += depositAmount * 0.07f;
            totalAmount += moneyForMonth;
        }
        System.out.println("Bank will give you " + totalAmount + " for " + months + " months");
    }
}
