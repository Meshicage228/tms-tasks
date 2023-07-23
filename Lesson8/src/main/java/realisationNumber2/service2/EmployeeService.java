package realisationNumber2.service2;


import realisationNumber2.employees2.*;

public abstract class EmployeeService {
    public static boolean findWorkerByName(Director currentDirector, String name) {
        for (Employee employee : currentDirector.getEmployeeArr()) {
            if (employee != null) {
                switch (employee.getPost()) {
                    case WORKER: {
                        if (employee.getName().equals(name)) {
                            return true;
                        }
                        break;
                    }
                    case DIRECTOR: {
                        if (employee.getName().equals(name)) {
                            return true;
                        }
                        return findWorkerByName((Director) employee, name);
                    }
                }
            } else break;
        }
        return false;
    }

    public static void showInfo(Employee... employees) {
        for (Employee empl : employees) {
            if (empl != null) {
                System.out.println(empl.toString());
            } else break;
        }
    }

    public static void showInfoFromDirector(Director director) {
        director.showSubordinates();
        System.out.println("..............................................");
        for (Employee employee : director.getEmployeeArr()) {
            if (employee != null) {
                if (employee.getPost().equals(Post.DIRECTOR)) {
                    showInfoFromDirector((Director) employee);
                }
            } else break;
        }
    }
}

