package org.example;

import java.util.Scanner;

public class ControlStructures {
    public static void main(String[] args) {

           /*  Управляющие конструкции  */

        ControlStructures tasks = new ControlStructures();

        // 1.

        tasks.TimeOfYear();

        // 2.

        tasks.TimeOfYearIfStructure();

        //3

        tasks.NumberOddOrEven();

        //4

        tasks.FeelingOfTemperature();
    }
    public void TimeOfYear(){
        switch (EnterNumber()){
            case 12,1,2:
                System.out.println("Winter");
                break;
            case 3,4,5:
                System.out.println("Spring");
                break;
            case 6,7,8:
                System.out.println("Summer");
                break;
            case 9,10,11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Wrong number");
        }
    }
    public void TimeOfYearIfStructure(){
        int expectedMonth = EnterNumber();

        if(expectedMonth == 12 || expectedMonth == 1 || expectedMonth == 2)
            System.out.println("Winter");
        else if (expectedMonth > 2 && expectedMonth < 6)
            System.out.println("Spring");
        else if (expectedMonth > 5 && expectedMonth < 9)
            System.out.println("Summer");
        else if (expectedMonth > 8 && expectedMonth < 12)
            System.out.println("Autumn");
        else System.out.println("Wrong number");
    }
    public void NumberOddOrEven(){
        String result = EnterNumber() % 2 == 0 ? "Is even" : "Is odd";
        System.out.println(result);
    }
    public void FeelingOfTemperature(){
        int t = EnterNumber();

        if(t > -5) System.out.println("Тепло");
        else if (t <= -5 && t > -20) System.out.println("Нормально");
        else if (t <= -20) System.out.println("Холодно");
    }
    private static int EnterNumber(){
        return new Scanner(System.in).nextInt();
    }
}