package comm.tms.MainTask.Task2.People;

import comm.tms.MainTask.Task2.Service.PostInterface;

public class Director implements PostInterface {
    public Director() {
        postMessage();
    }

    @Override
    public void postMessage() {
        System.out.println("I am DIRECTOR!!!!");
    }
}
