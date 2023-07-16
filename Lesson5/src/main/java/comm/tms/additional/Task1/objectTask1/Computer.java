package comm.tms.additional.Task1.objectTask1;

public class Computer {
    private float cost;
    private String model;
    private HDD hdd;
    private RAM ram;

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

    @Override
    public String toString() {
        return "Computer{" +
                "cost=" + cost +
                ", model='" + model + '\'' +
                ", hdd=" + hdd +
                ", ram=" + ram +
                '}';
    }
}
