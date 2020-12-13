package subway.domain.entity;

import java.util.Objects;

public class Station {
    private static final int MINIMUM_STATION_NAME_LENGTH = 2;

    private final String name;

    public Station(String name) {
        validateStationName(name);
        this.name = name;
    }

    private void validateStationName(String name) {
        if (Objects.isNull(name)) {
            throw new StationNameException();
        }
        int trimNameLength = name.trim().length();
        if (trimNameLength < MINIMUM_STATION_NAME_LENGTH) {
            throw new StationNameException();
        }
    }

    public boolean matchesName(String name) {
        return Objects.equals(this.name, name);
    }

    public String getName() {
        return name;
    }
}
