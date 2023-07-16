package comm.tms.mainTask.task2.People;

import comm.tms.mainTask.task2.Service.PostInterface;

public class Worker implements PostInterface {
    public Worker() {
        postMessage();
    }

    @Override
    public void postMessage() {
        System.out.println("I am worker");
    }
}
