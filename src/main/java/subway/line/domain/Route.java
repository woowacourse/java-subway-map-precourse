package subway.line.domain;

import subway.station.domain.Station;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private final List<Station> stations = new ArrayList<>();

    public Route(Station topStation, Station bottomStation) {
        stations.add(topStation);
        stations.add(bottomStation);
    }
}
