package realisation.employees2;


import realisation.service2.Post;

public abstract class Employee {
    protected final int baseRate = 1000;
    protected String name;
    protected String surname;
    protected float workExperience;
    protected Post post;

    public Post getPost() {
        return post;
    }

    public String getName() {
        return name;
    }

    public Employee(String name, String surname, float workExperience) {
        this.name = name;
        this.surname = surname;
        this.workExperience = workExperience;
    }

    public float calculateSalary() {
        return post.getCoef() * baseRate * workExperience;
    }

}
