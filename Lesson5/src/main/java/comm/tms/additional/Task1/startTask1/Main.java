package comm.tms.additional.Task1.startTask1;

import comm.tms.additional.Task1.objectTask1.*; // Import all from package

public class Main {
    public static void main(String[] args) {
        Computer computer1 = new Computer(894.5f, "80XL");
        System.out.println(computer1);
        Computer computer2 = new Computer(1245.53f, "80XL", new HDD("Western", 500, "Inner"), new RAM("RAM", 1024));
        System.out.println(computer2);
    }
 }
