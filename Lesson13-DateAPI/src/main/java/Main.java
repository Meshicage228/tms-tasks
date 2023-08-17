import additional.TaskOneMethod;

import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.spi.LocaleServiceProvider;

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
        switch (localDate.getDayOfWeek()){
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
