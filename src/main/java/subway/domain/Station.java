package subway.domain;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        // TODO 이름 2글자 이상인지 확인할 것
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String stationName) {
        return this.name.equals(stationName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
