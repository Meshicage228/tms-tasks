package comm.tms.mainTask.task2.peopleService;

public enum Post {
    DIRECTOR("I am director"),
    ACCOUNTANT("I am accountant"),
    WORKER("I am worker");
    private String message;

    Post(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
