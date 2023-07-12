package comm.tms.additional.Task1.objectTask1;

public class HDD {
    String title;
    float volume;
    String type;

    public HDD() {
    }

    public HDD(String title, float volume, String type) {
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
