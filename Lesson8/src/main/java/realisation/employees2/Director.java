package realisation.employees2;


import realisation.service2.*;

public class Director extends Employee {
    Employee[] employeeArr = new Employee[12];

    public Director(String name, String surname, float workExperience) {
        super(name, surname, workExperience);
        this.post = Post.DIRECTOR;
    }

    @Override
    public float calculateSalary() {
        int countPeople = countSubordinates();
        if (countPeople <= 1) {
            return super.calculateSalary();
        }
        return super.calculateSalary() * countPeople;
    }

    public void addEmployee(Employee... employee) {
        for (Employee work : employee) {
            for (int i = 0; i < employeeArr.length; i++) {
                if (employeeArr[i] == null) {
                    employeeArr[i] = work;
                    break;
                }
            }
        }
    }

    private int countSubordinates() {
        int counter = 0;
        for (Employee empl : employeeArr) {
            if (empl != null) {
                counter++;
            } else break;
        }
        return counter;
    }

    public Employee[] getEmployeeArr() {
        return employeeArr;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' + ",salary='" + calculateSalary() + '\'' +
                '}';
    }
}
