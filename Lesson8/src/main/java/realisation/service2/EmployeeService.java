package realisation.service2;


import realisation.employees2.*;

public abstract class EmployeeService {
    public static boolean findWorkerByName(Director currentDirector, String name) {
        for (Employee employee : currentDirector.getEmployeeArr()) {
            if (employee != null) {
                if (employee.getName().equals(name)) {
                    return true;
                }
                else if(employee.getPost().equals(Post.DIRECTOR)){
                    return findWorkerByName((Director) employee, name);
                }
            } else break;
        }
        return false;
    }
    public static void showInfoFromDirector(Director director) {
        System.out.println("..............................................");
        System.out.println(director.toString());
        for (Employee employee : director.getEmployeeArr()) {
            if (employee != null) {
                if (employee.getPost().equals(Post.DIRECTOR)) {
                    showInfoFromDirector((Director) employee);
                }
                else System.out.println(employee.toString());
            } else break;
        }
    }
}

