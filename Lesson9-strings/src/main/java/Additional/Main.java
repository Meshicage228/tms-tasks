package Additional;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("notepad.exe D:/JavaProjects/tms-tasks/Lesson9-strings/src/main/java/Additional/myfile.java");

        int a = new Scanner(System.in).nextInt(); // Stop

        Class cl = null;
        try {
            cl = Class.forName("myfile");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods){
            System.out.println(method.getName());
        }
        methods[1].invoke(cl);
    }
}
