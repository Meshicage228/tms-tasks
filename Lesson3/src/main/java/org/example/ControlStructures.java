package org.example;

import java.util.Scanner;

public class ControlStructures {
    public static void main(String[] args) {

           /*  Управляющие конструкции  */
        // 1.
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()){
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

            String result = scan.nextInt() % 2 == 0 ? "Is even" : "Is odd";
            System.out.println(result);

        //4
            int t = scan.nextInt();

            if(t > -5) System.out.println("Тепло");
            else if (t <= -5 && t > -20) System.out.println("Нормально");
            else if (t <= -20) System.out.println("Холодно");

    }
}