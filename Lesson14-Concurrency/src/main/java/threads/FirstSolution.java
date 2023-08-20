package threads;

public class FirstSolution {
    public static void main(String[] args) throws InterruptedException {

        // Первое решение

        ThreadExtends thread1 = new ThreadExtends();

        Thread thread2 = new Thread(new ThreadImpl());

        Thread thread3 = new Thread(new ThreadImpl());

        thread3.start();

        thread3.join();

        thread2.start();

        thread2.join();

        thread1.start();

        thread1.join();

    }
}
