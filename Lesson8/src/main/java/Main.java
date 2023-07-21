import employees.*;
import service.*;

public class Main {
    public static void main(String[] args) {
        Director mainDirector = new Director("MainGustavo", "Fring1", 6, Post.DIRECTOR);

        Worker worker1 = new Worker("Vlad1", "Chel1", 0.7f, Post.WORKER);
        Worker worker2 = new Worker("Vlad2", "Chel2", 3, Post.WORKER);
        Worker worker3 = new Worker("Vlad3", "Chel3", 1.5f, Post.WORKER);
        Worker worker4 = new Worker("Vlad4", "Chel3", 1.2f, Post.WORKER);
        Worker worker5 = new Worker("Vlad5", "Chel3", 1.2f, Post.WORKER);



       /* mainDirector.showSubordinates();*/


        Director director1 = new Director("Gustavo1", "Fring2", 2.5f, Post.DIRECTOR);
        Director director2 = new Director("Gustavo2", "Fring3", 5, Post.DIRECTOR);

        mainDirector.addDirector(director1, director2);


        director1.addWorker(worker3, worker4);
        director2.addWorker(worker1, worker2);

        EmployeeService.showInfoFromDirector(mainDirector); // Инфо о всех вложенных директорах и их подчиненных

        System.out.println(EmployeeService.findWorkerByName(mainDirector, "Vlad4"));
        System.out.println(EmployeeService.findWorkerByName(director1, "Vlad3"));
        System.out.println(EmployeeService.findWorkerByName(director1, "Vlad1"));
    }
}
