package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.station.Station;

public class Line {

    private String name;
    private final List<Station> stations = new ArrayList<>();

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

    public void addStationByIndex(Station station, int index) {
        stations.add(index, station);
    }

    public boolean isContainsStation(Station station) {
        for (Station each : stations) {
            if (each.getName().equals(station.getName())) {
                return true;
            }
        }
        return false;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }
}
