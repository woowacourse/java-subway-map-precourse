package subway.domain.station;

import java.util.Objects;

public class Station {
    private String name;
    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Station getStation(String stationName) {
        if (StationCheck.checkStationNameLength(stationName) && StationCheck.checkStationNameEndPoint(stationName)) {
        }
        return new Station(stationName);
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
