package realisationN1.employees;

import realisationN1.service.Post;

public abstract class Employee {
    protected final int baseRate = 1000;
    protected String name;
    protected String surname;
    protected float workExperience;
    protected Post post;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public Employee(String name, String surname, float workExperience, Post post) {
        this.name = name;
        this.surname = surname;
        this.workExperience = workExperience;
        this.post = post;
    }

    public float calculateSalary() {
        return post.getCoef() * baseRate * workExperience;
    }
}
