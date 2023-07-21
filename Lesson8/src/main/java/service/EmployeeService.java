package service;

import employees.Director;
import employees.Worker;

public abstract class EmployeeService {
    public static boolean findWorkerByName(Director currentDirector, String name) {

        for (Worker worker : currentDirector.getWorkers()) { // Проверяем всех Worker у текущего директора
            if(worker != null){
                if(worker.getName().equals(name)) {
                    return true;
                }
            }
            else break;
        }
        for (Director nextDirector : currentDirector.getDirectors()) {
            if (nextDirector != null) {
                if(nextDirector.getName().equals(name)) { // Проверяем всех Director у текущего директора
                    return true;
                }
                return findWorkerByName(nextDirector, name); // идем к другому подчиненному директору если такой есть
            }
            else break;
        }
        return false;
    }
    public static void showInfo(Director... directors){
        for (Director empl : directors) {
            if(empl != null) {
                System.out.println(empl.toString());
            }
            else break;
        }
    }
    public static void showInfo(Worker... workers){
        for (Worker empl : workers) {
            if(empl != null) {
                System.out.println(empl.toString());
            }
            else break;
        }
    }
}
