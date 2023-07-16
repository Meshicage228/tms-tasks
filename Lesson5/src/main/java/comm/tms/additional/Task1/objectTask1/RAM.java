package comm.tms.additional.Task1.objectTask1;

public class RAM {
    private String title;
    private float volume;

    public RAM() {
    }

    public RAM(String title, float volume) {
        this.title = title;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "title='" + title + '\'' +
                ", volume=" + volume +
                '}';
    }
}
