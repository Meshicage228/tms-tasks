package comm.tms.MainTask.Task2.People;

import comm.tms.MainTask.Task2.Service.PostInterface;

public class Accountant implements PostInterface {
    public Accountant() {
        postMessage();
    }

    @Override
    public void postMessage() {
        System.out.println("I am accountant");
    }
}
