package realisationN1;

import realisationN1.employees.*;
import realisationN1.service.*;

public class Main {
    public static void main(String[] args) {
        Director mainDirector = new Director("MainGustavo", "Fring1", 6, Post.DIRECTOR);

        Worker worker1 = new Worker("Vlad1", "Chel1", 0.7f, Post.WORKER);
        Worker worker2 = new Worker("Vlad2", "Chel2", 3, Post.WORKER);
        Worker worker3 = new Worker("Vlad3", "Chel3", 1.5f, Post.WORKER);
        Worker worker5 = new Worker("Vlad5", "Chel3", 1.2f, Post.WORKER);


        mainDirector.addWorker(worker1, worker2);
        mainDirector.showSubordinates();
        System.out.println("After add a new director : ");


        Director director1 = new Director("Gustavo1", "Fring2", 2.5f, Post.DIRECTOR);
        Director director2 = new Director("Gustavo2", "Fring3", 5, Post.DIRECTOR);


        mainDirector.addDirector(director1);

        director1.addWorker(worker3);
        director1.addDirector(director2);
        director2.addWorker(worker5);

        EmployeeService.showInfoFromDirector(mainDirector);

        System.out.println(EmployeeService.findWorkerByName(mainDirector, "Vlad4"));
        System.out.println(EmployeeService.findWorkerByName(director1, "Vlad3"));
        System.out.println(EmployeeService.findWorkerByName(director1, "Vlad1"));
    }
}