import additional.TaskOneMethod;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
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
        LocalDate nextThursday = localDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println(nextThursday);

        // Additional
        new TaskOneMethod().doTask();
    }
}
