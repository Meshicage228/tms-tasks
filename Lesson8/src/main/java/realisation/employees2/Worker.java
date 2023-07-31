package realisation.employees2;

import realisation.service2.Post;

public class Worker extends Employee {
    public Worker(String name, String surname, float workExperience) {
        super(name, surname, workExperience);
    }

    @Override
    public Post getPost() {
        return Post.WORKER;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' + ",salary='" + super.calculateSalary() + '\'' +
                '}';
    }
}
