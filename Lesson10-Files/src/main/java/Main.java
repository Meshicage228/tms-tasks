import files.FileService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Write name of the source file : ");
        String nameOfFile = new Scanner(System.in).nextLine();
        FileService.fileDistributer(nameOfFile);
    }
}
