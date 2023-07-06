package org.example;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
                 /*  Циклы  */

        Loop tasks = new Loop();

        //1. Вывод нечетных чисел

        tasks.OddNumbers();

        //2. От 5 до 1

        tasks.FromFiveToOne();

        //3. Сумма от 1 до введенного числа

        System.out.println(tasks.SumFromOne());

    }
    public void OddNumbers(){
        for(int i = 0; i < 100; i++)
            if(i % 2 == 1)
                System.out.print(i + " ");
    }
    public void FromFiveToOne(){
        for(int i = 5 ; i > 0; i--)
            System.out.print(i + " ");
    }
    public int SumFromOne(){
        Scanner scan = new Scanner(System.in);
        int number;
        int sum = 0;

        do {
            System.out.println("Write positive number");
            number = scan.nextInt();
        }while(number <= 0);

        for (int i = 1; i <= number; i++)
            sum += i;

        return sum;
    }
}
