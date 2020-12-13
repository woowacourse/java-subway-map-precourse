package subway.domain;

import java.util.Objects;

public final class Station {

    private final StationName stationName;

    public Station(final String name) {
        this.stationName = new StationName(name);
    }

    public String getName() {
        return stationName.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Station)) { return false; }
        Station station = (Station) o;
        return Objects.equals(stationName, station.stationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName);
    }
}
