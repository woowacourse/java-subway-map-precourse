package subway.domain;

public class Station {
    public static final int NAME_MIN_LENGTH = 2;

    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[INFO] " + name + "\n";
    }
}
