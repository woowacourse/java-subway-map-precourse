package subway.line.domain;

import subway.station.domain.Station;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private static final int INDEX_CORRECTION_VALUE = 1;

    private final List<Station> stations = new ArrayList<>();

    public Route(Station topStation, Station bottomStation) {
        stations.add(topStation);
        stations.add(bottomStation);
    }

    public void insert(int index, Station station) {
        stations.add(index - INDEX_CORRECTION_VALUE, station);
    }

    public boolean isExist(String stationName) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(stationName));
    }
}
