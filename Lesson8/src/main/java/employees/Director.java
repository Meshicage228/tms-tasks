package employees;

import service.EmployeeService;
import service.Post;

public class Director extends Employee{
    private Director[] directors = new Director[5];
    private Worker[] workers = new Worker[10];

    public Director(String name, String surname, float workExperience, Post post) {
        super(name, surname, workExperience, post);

    }
    @Override
    public float calculateSalary() {
        int countPeople = countSubordinates();
        if(countPeople <= 1){
            return super.calculateSalary();
        }
        return post.getCoef() * baseRate * workExperience * countPeople;
    }
    public void addWorker(Worker... worker){
        for(Worker work : worker){
            for (int i = 0; i < workers.length; i++){
                if(workers[i] == null){
                    workers[i] = work;
                    break;
                }
            }
        }
    }
    public void addDirector(Director... director){
        for(Director direct : director){
            for (int i = 0; i < directors.length; i++){
                if(directors[i] == null){
                    directors[i] = direct;
                    break;
                }
            }
        }
    }
    private int countSubordinates(){
        int counter = 0;
        for (Worker worker : workers) {
            if(worker != null) counter++;
            else break;
        }
        for (Director director : directors) {
            if(director != null) counter++;
            else break;
        }
        return counter;
    }

    public Director[] getDirectors() {
        return directors;
    }

    public Worker[] getWorkers() {
        return workers;
    }
    public void showSubordinates() {
        System.out.println(this + "\n" + "Sabordinates : ");
        EmployeeService.showInfo(this.getDirectors());
        EmployeeService.showInfo(this.getWorkers());
    }
    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' + ",salary='" + calculateSalary() + '\'' +
                '}';
    }
}
