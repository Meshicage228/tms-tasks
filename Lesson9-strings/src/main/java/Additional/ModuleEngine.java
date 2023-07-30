package Additional;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class ModuleEngine {

    public static void main(String[] args) throws IOException, InterruptedException{
        // Та же проблема не знаю как загрузить уже скомпилированный файл
        String pathFile = "Lesson9-strings/src/main/java/Additional/myfile.java";

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("notepad.exe " + pathFile);
        process.waitFor();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, pathFile);

        try {
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:Lesson9-strings/src/main/java/Additional/myfile")});
            Class<?> myClass = urlClassLoader.loadClass("Additional.myfile"); // Тут грузит старое ( с прошлой компиляции)

            Method[] classMethods =  myClass.getDeclaredMethods();

            System.out.println(Arrays.toString(classMethods));

            classMethods[1].invoke(myClass);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InvocationTargetException | IllegalAccessException e) {
            System.out.println("Cannot invoke");
        }


    }

}
