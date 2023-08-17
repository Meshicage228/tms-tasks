import additional.TaskOneMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1.

        System.out.println("Write date in format : YYYY-MM-dd");
        String str = new Scanner(System.in).nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");

        try {
            LocalDate localDate = LocalDate.parse(str, dateTimeFormatter);
            System.out.println(localDate.getDayOfWeek());
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date");
        }

        //2.
        LocalDate localDate = LocalDate.now();
        switch (localDate.getDayOfWeek()) {
            case MONDAY -> System.out.println(localDate.plusDays(8));
            case TUESDAY -> System.out.println(localDate.plusDays(7));
            case WEDNESDAY -> System.out.println(localDate.plusDays(6));
            case THURSDAY -> System.out.println(localDate.plusDays(5));
            case FRIDAY -> System.out.println(localDate.plusDays(4));
            case SATURDAY -> System.out.println(localDate.plusDays(3));
            case SUNDAY -> System.out.println(localDate.plusDays(2));
        }

        // Additional
        new TaskOneMethod().doTask();
    }
}
