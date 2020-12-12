package subway.station.domain;

import java.util.Objects;
import subway.station.exception.ShorterThanMinStationNameException;

public class Station {

    public static final int MIN_NAME_SIZE = 2;

    private final String name;

    private Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        if (name.length() < MIN_NAME_SIZE) {
            throw new ShorterThanMinStationNameException(name);
        }

        return new Station(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
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
