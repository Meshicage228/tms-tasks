package realisationN1.employees;

import realisationN1.service.Post;

public class Worker extends Employee {
    public Worker(String name, String surname, float workExperience, Post post) {
        super(name, surname, workExperience, post);
    }
    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' + ",salary='" + super.calculateSalary() + '\'' +
                '}';
    }
}
