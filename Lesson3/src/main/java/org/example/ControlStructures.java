package org.example;

import java.util.Scanner;

public class ControlStructures {
    public static void main(String[] args) {

           /*  Управляющие конструкции  */
        // 1.
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()){
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Wrong number");
        }

        // 2.
            int expectedMonth = scan.nextInt();

            if(expectedMonth == 12 || expectedMonth == 1 || expectedMonth == 2)
                System.out.println("Winter");
            else if (expectedMonth > 2 && expectedMonth < 6)
                System.out.println("Spring");
            else if (expectedMonth > 5 && expectedMonth < 9)
                System.out.println("Summer");
            else if (expectedMonth > 8 && expectedMonth < 12)
                System.out.println("Autumn");
            else System.out.println("Wrong number");

        //3
            if(scan.nextInt() % 2 == 0) System.out.println("The number is even");
            else System.out.println("The number is odd");

        //4
            int t = scan.nextInt();

            if(t > -5) System.out.println("Тепло");
            else if (t <= -5 && t > -20) System.out.println("Нормально");
            else if (t <= -20) System.out.println("Холодно");

    }
}