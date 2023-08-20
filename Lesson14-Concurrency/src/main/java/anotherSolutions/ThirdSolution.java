package anotherSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ThirdSolution {
    public static void main(String[] args) throws InterruptedException {
        // Третье решение

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        };
        List<Thread> list = new ArrayList<>(Stream.generate(() -> new Thread(runnable))
                .limit(3)
                .toList());

        Collections.reverse(list);

        for (Thread thread : list) {
            thread.start();
            thread.join();
        }
    }
}
