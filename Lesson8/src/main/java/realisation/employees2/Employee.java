package realisation.employees2;


import realisation.service2.Post;

public abstract class Employee {
    protected final int baseRate = 1000;
    protected String name;
    protected String surname;
    protected float workExperience;

    public abstract Post getPost();

    public String getName() {
        return name;
    }

    public Employee(String name, String surname, float workExperience) {
        this.name = name;
        this.surname = surname;
        this.workExperience = workExperience;
    }

    public float calculateSalary() {
        return getPost().getCoef() * baseRate * workExperience;
    }

}
