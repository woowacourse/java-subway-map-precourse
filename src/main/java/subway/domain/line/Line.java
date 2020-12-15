package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.station.Station;

public class Line {

    private String name;
    private static final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addAllStation(List<Station> stationsList) {
        stations.addAll(stationsList);
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }
}
