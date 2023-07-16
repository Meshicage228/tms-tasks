package comm.tms.additional.Task1.objectTask1;

public class HDD {
    private String title;
    private float volume;
    private TypeOfHdd type;

    public HDD() {
    }

    public HDD(String title, float volume, TypeOfHdd type) {
        this.title = title;
        this.volume = volume;
        this.type = type;
    }

    @Override
    public String toString() {
        return "HDD{" +
                "title='" + title + '\'' +
                ", volume=" + volume +
                ", type='" + type + '\'' +
                '}';
    }
}
