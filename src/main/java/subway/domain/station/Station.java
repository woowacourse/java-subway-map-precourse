package subway.domain.station;

public class Station {

    public static final int MIN_NAME_LENGTH = 2;

    private final String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
