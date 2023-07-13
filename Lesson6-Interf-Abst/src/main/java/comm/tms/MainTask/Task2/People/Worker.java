package comm.tms.MainTask.Task2.People;

import comm.tms.MainTask.Task2.Service.PostInterface;

public class Worker implements PostInterface {
    public Worker() {
        postMessage();
    }

    @Override
    public void postMessage() {
        System.out.println("I am worker");
    }
}
