package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubStationAt(int index, Station station) {
        if ((index < 0) || (stations.size() < index) || station == null) {
            return;
        }
        stations.add(index, station);
    }

    public void addSubStation(Station station) {
        if (station == null) {
            return;
        }
        stations.add(station);
    }

    public void deleteSubStation(Station station) {
        if (station != null) {
            stations.remove(station);
        }
    }

    public List<Station> getSubStations() {
        return stations;
    }
}
