package subway.domain;

import java.util.Objects;

public class Station {
    private static final int MIN_LENGTH_OF_STATION_NAME = 2;
    private String name;

    public Station(String name) {
        validateStationName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateStationName(String name) {
        if (name.length() < MIN_LENGTH_OF_STATION_NAME) {
            throw new IllegalArgumentException("[ERROR] 역의 이름은 2글자 이상이어야 합니다.");
        }
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

    @Override
    public String toString() {
        return "Station{" +
            "name='" + name + '\'' +
            '}';
    }
}
