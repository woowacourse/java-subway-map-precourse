package subway.domain;

import static subway.exception.ExceptionMessage.INVALID_STATION_NAME_CHARACTER;
import static subway.exception.ExceptionMessage.INVALID_STATION_NAME_LENGTH;
import static subway.exception.ExceptionMessage.INVALID_STATION_NAME_SUFFIX;

import java.util.Objects;

public class Station {
    private static final int MIN_STATION_NAME_LENGTH = 3;
    private static final char MIN_KOREAN_STATION_NAME = '가';
    private static final char MAX_KOREAN_STATION_NAME = '힣';
    private static final String STATION_NAME_SUFFIX = "역";
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateStationNameLength(name);
        validateStationNameCharacter(name);
        validateStationNameSuffix(name);
    }

    private static void validateStationNameLength(String name) {
        if (name.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_STATION_NAME_LENGTH.getMessage());
        }
    }

    private static void validateStationNameCharacter(String name) {
        if (name.chars()
                .anyMatch(character -> character < MIN_KOREAN_STATION_NAME || MAX_KOREAN_STATION_NAME < character)) {
            throw new IllegalArgumentException(INVALID_STATION_NAME_CHARACTER.getMessage());
        }
    }

    private static void validateStationNameSuffix(String name) {
        if (!name.endsWith(STATION_NAME_SUFFIX)) {
            throw new IllegalArgumentException(INVALID_STATION_NAME_SUFFIX.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Station)) {
            return false;
        }
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
