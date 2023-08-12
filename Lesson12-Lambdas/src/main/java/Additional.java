import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Additional {
    public static void streamAndNames() {
        List<String> arr = new ArrayList<>(List.of("  ", "vlad", "Zhorh", "Vladimir", "Cake"));

        String nameWrite = new Scanner(System.in).nextLine();
        long count = arr.stream()
                .filter(val -> val.equalsIgnoreCase(nameWrite))
                .count();
        System.out.println("Matches : " + count);

        arr.stream()
                .filter(s -> s.toLowerCase().startsWith("a"))
                .forEach(System.out::println);

        System.out.println(arr);

        String s = arr.stream()
                .filter(val -> !val.isEmpty() && !val.isBlank())
                .sorted()
                .findFirst()
                .orElse("Empty!");
        System.out.println(s);
    }
}
