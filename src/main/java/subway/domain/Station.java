package subway.domain;

import static subway.exception.ExceptionMessage.INVALID_STATION_NAME_CHARACTER;
import static subway.exception.ExceptionMessage.INVALID_STATION_NAME_LENGTH;
import static subway.exception.ExceptionMessage.INVALID_STATION_NAME_SUFFIX;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(INVALID_STATION_NAME_LENGTH.getMessage());
        }
        if (name.chars().anyMatch(character -> character < '가' || '힣' < character)) {
            throw new IllegalArgumentException(INVALID_STATION_NAME_CHARACTER.getMessage());
        }
        if (!name.endsWith("역")) {
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
