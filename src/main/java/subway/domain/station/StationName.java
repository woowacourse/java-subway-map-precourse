package subway.domain.station;

import subway.domain.exception.StationNameFormatException;
import subway.domain.exception.StationNameLengthException;

import java.util.Objects;

public class StationName {
    private static final int MINIMUM_STATION_NAME_SIZE = 2;
    private static final String STATION_IN_KOREAN = "역";

    private String name;

    private StationName(String name) {
        validateName(name);
        this.name = name;
    }

    public static StationName of(String name) {
        return new StationName(name);
    }

    private void validateName(String name) {
        validateEndWithStation(name);
        validateLength(name);
    }

    private void validateEndWithStation(String name) {
        if (!name.endsWith(STATION_IN_KOREAN)) {
            throw new StationNameFormatException();
        }
    }

    private void validateLength(String name) {
        if (!(name.length() - STATION_IN_KOREAN.length() >= MINIMUM_STATION_NAME_SIZE)) {
            throw new StationNameLengthException();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof StationName) {
            return Objects.equals(name, ((StationName) o).name);
        }

        return false;
    }
}
