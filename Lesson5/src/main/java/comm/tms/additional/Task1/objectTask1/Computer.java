package comm.tms.additional.Task1.objectTask1;

public class Computer {
    float cost;
    String model;
    HDD hdd;
    RAM ram;

    public Computer() {
    }
    public Computer(float cost, String model) {
        this(cost, model, new HDD(), new RAM());
    }

    public Computer(float cost, String model, HDD hdd, RAM ram) {
        this.cost = cost;
        this.model = model;
        this.hdd = hdd;
        this.ram = ram;
    }
}
