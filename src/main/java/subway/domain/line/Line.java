package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.station.Station;

public class Line {

    private final List<Station> stations = new ArrayList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAllStation(List<Station> stationsList) {
        stations.addAll(stationsList);
    }

    public void addStationByIndex(Station station, int index) {
        stations.add(index, station);
    }

    public void deleteStationByName(String name) {
        stations.removeIf(station -> station.getName().equals(name));
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
