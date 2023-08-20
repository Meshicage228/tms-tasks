package anotherSolutions;

public class ThreadLogic {

    // Второе
    // Если будет много потоков, то это плохой вариант. А так вроде работает
    private boolean second = true;
    private boolean third = true;

    public synchronized void thirdDone() {
        third = false;
        second = true;
        notify();
    }

    public synchronized void secondDone() {
        second = false;
        notify();
    }

    public synchronized void secondWait() throws InterruptedException {
        while (third) {
            wait();
        }
    }

    public synchronized void firstWait() throws InterruptedException {
        while (second) {
            wait();
        }
    }
}
