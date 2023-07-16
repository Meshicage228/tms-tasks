package comm.tms.mainTask.task2.People;

import comm.tms.mainTask.task2.Service.PostInterface;

public class Accountant implements PostInterface {
    public Accountant() {
        postMessage();
    }

    @Override
    public void postMessage() {
        System.out.println("I am accountant");
    }
}
