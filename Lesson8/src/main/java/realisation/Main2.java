package realisation;
import realisation.employees2.*;
import realisation.service2.*;

public class Main2 {
    public static void main(String[] args) {
        Director mainDirector = new Director("MainGustavo", "Fring1", 6);

        Worker worker1 = new Worker("Петров", "Chel1", 0.7f);
        Worker worker2 = new Worker("Анастасия", "Chel2", 3);
        Worker worker3 = new Worker("Егоров", "Chel4", 1.5f);
        Worker worker5 = new Worker("Чел", "Chel5", 1.2f);


        mainDirector.addEmployee(worker1, worker2);
        EmployeeService.showInfoFromDirector(mainDirector);
        System.out.println("After add a new director : ");


        Director director1 = new Director("Gustavo1", "Fring2", 2.5f);
        Director director2 = new Director("Gustavo2", "Fring3", 5  );


        mainDirector.addEmployee(director1);

        director1.addEmployee(worker3);
        director1.addEmployee(director2);
        director2.addEmployee(worker5);

        EmployeeService.showInfoFromDirector(mainDirector);

        System.out.println(EmployeeService.findWorkerByName(mainDirector, "Чел"));
        System.out.println(EmployeeService.findWorkerByName(director1, "Ч"));
        System.out.println(EmployeeService.findWorkerByName(director1, "Vlad1"));

    }
}
