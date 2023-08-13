import java.util.*;
public class MainTask {
    public static void streams() {
        List<Integer> list = new ArrayList<>(List.of(11, 14, 14, 8, 12, 16)).stream().distinct().toList();

        list.stream()
                .filter(integer -> integer % 2 == 0 && integer > 7 && integer <= 17)
                .forEach(System.out::println);

        list.stream()
                .map(integer -> integer * 2)
                .forEach(System.out::println);

        list.stream()
                .sorted(Comparator.naturalOrder())
                .limit(4)
                .forEach(System.out::println);

        long count = list.stream()
                .peek(System.out::println)
                .count();
        System.out.println(count);

        double average = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0d);
        System.out.println(average);
    }
}
