package threads;

import threads.ThreadExtends;
import threads.ThreadImpl;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ThreadExtends thread1 = new ThreadExtends();

        Thread thread2 = new Thread(new ThreadImpl());

        Thread thread3 = new Thread(new ThreadImpl());

       /*
        Можно и так создать

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        */

        thread3.start();

        thread3.join();

        thread2.start();

        thread2.join();

        thread1.start();

        thread1.join();

    }
}
