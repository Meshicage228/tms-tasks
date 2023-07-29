package files;

import java.io.*;

public abstract class FileService {
    public static void fileDistributer(String fileName) {
        String directoryPath = "D:\\JavaProjects\\tms-tasks\\Lesson10-Files\\src\\main\\java\\files\\";
        try (LineNumberReader reader = new LineNumberReader(new FileReader(directoryPath + fileName + ".txt"));
             FileWriter writerValid = new FileWriter(directoryPath + "validNumbers.txt");
             FileWriter writerInvalid = new FileWriter(directoryPath + "invalidNumbers.txt")) {

             String line = reader.readLine();

             while (line != null) {
                System.out.println(line);
                if (line.length() != 15 && line.isBlank()) {
                    writerInvalid.write(line + " - invalid length\n");
                } else if (!(line.startsWith("docnum") || line.startsWith("contract"))) {
                    writerInvalid.write(line + " - invalid start\n");
                } else {
                    writerValid.write(line + "\n");
                }
                line = reader.readLine();
             }
        } catch (IOException ex) {
            System.out.println("Invalid name");
        }
    }
}
