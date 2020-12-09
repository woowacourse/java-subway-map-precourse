package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addStation(int index, Station station) {
        stations.add(index, station);
    }

    public boolean hasStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCapacitiy(int order) {
        return order <= stations.size() + 1;
    }

    public boolean isStationDeletable() {
        return stations.size() > 2;
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
