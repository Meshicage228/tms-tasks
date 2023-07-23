package realisationNumber2.employees2;


import realisationNumber2.service2.Post;

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

    public Employee(String name, String surname, float workExperience, Post post) {
        this.name = name;
        this.surname = surname;
        this.workExperience = workExperience;
        this.post = post;
    }

    public float calculateSalary() {
        return post.getCoef() * baseRate * workExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "baseRate=" + baseRate +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", workExperience=" + workExperience +
                ", post=" + post +
                '}';
    }
}
