package additional;

import java.util.Scanner;

public class TaskOneMethod {
    public void doTask() {

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        if (option == 1) {
            String str = scanner.next();

            FunctionalInter<String> functionalInter = string -> {
                String answer = String.valueOf(new StringBuilder(str).reverse());
                System.out.println("Reverse : " + answer);
            };

            functionalInter.doSmth(str);
        } else if (option == 2) {
            Integer numberToFind = scanner.nextInt();

            FunctionalInter<Integer> functionalInter = number -> {
                int answer = 1;
                for (int i = 1; i <= number; i++) {
                    answer *= i;
                }
                System.out.println("Factorial " + number + " is : " + answer);
            };

            functionalInter.doSmth(numberToFind);
        } else {
            System.out.println("Wrong option");
        }
    }
}
