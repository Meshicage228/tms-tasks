package anotherSolutions;

public class SecondSolution {
    public static void main(String[] args) throws InterruptedException {

        // Второе решение

        ThreadLogic threadLogic = new ThreadLogic();
        Thread first = new Thread(() -> {
            try {
                threadLogic.firstWait();
                for (int i = 0; i < 10; i++) {
                    System.out.println("First");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread second = new Thread(() -> {
            try {
                threadLogic.secondWait();
                for (int i = 0; i < 10; i++) {
                    System.out.println("Second");
                }
                threadLogic.secondDone();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread third = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Third");
            }
            threadLogic.thirdDone();
        });

        third.start();
        second.start();
        first.start();

        third.join();
        second.join();
        first.join();

        System.out.println("The end");
    }
}
