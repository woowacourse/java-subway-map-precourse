package subway.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private final String name;
    private final List<Station> stations;

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getStationNumber() {
        return stations.size();
    }

    public boolean isExistStationInLine(String stationName) {
        return stations.stream().anyMatch(station -> Objects.equals(station.getName(), stationName));
    }

    public void addRoute(int index, String StationName) {
        Station station = new Station(StationName);
        if (index == getStationNumber()) {
            stations.add(station);
            return;
        }
        stations.add(index, station);
    }

    public void deleteRoute(String stationName) {
        stations.removeIf(station -> Objects.equals(station.getName(), stationName));
    }
}
