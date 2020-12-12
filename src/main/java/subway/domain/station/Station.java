package subway.domain.station;

import java.util.Objects;

public class Station {
    private final StationName stationName;

    private Station(StationName stationName) {
        this.stationName = stationName;
    }

    public StationName getName() {
        return stationName;
    }

    // 추가 기능 구현

    public static Station of(StationName stationName) {
        return new Station(stationName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(stationName, station.stationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName);
    }


}
