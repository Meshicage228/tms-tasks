package comm.tms.mainTask.task2.people;

import comm.tms.mainTask.task2.peopleService.Post;

public abstract class InfoEmployee {
    protected Post post;

    public InfoEmployee() {
    }

    public InfoEmployee(Post post) {
        this.post = post;
        post.printMessage();
    }

}
