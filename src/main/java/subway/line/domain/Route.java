package subway.line.domain;

import subway.station.domain.Station;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private static final int INDEX_CORRECTION_VALUE = 1;
    private static final int MIN_OF_ORDER = 1;
    private static final int MIN_SIZE_FOR_REMOVAL = 2;

    private final List<Station> stations = new ArrayList<>();

    public Route(Station topStation, Station bottomStation) {
        stations.add(topStation);
        stations.add(bottomStation);
    }

    public void insert(int order, Station station) {
        stations.add(order - INDEX_CORRECTION_VALUE, station);
    }

    public void remove(Station station) {
        stations.remove(station);
    }

    public boolean isExist(String stationName) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(stationName));
    }

    public boolean isValidOrder(int order) {
        return order >= MIN_OF_ORDER && order <= stations.size() + INDEX_CORRECTION_VALUE;
    }

    public boolean isEnoughSize() {
        return stations.size() > MIN_SIZE_FOR_REMOVAL;
    }
}
