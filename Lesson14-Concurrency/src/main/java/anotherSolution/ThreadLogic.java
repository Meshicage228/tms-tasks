package anotherSolution;

public class ThreadLogic {

    // Если будет много потоков, то это плохой вариант. А так вроде работает
    private boolean first = false;
    private boolean second = true;
    private boolean third = true;

    public synchronized void thirdDone() {
        third = false;
        second = true;
        notify();
    }

    public synchronized void secondDone() {
        second = false;
        first = true;
        notify();
    }

    public synchronized void thirdWait() throws InterruptedException {
        while (first) {
            wait();
        }
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
