package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<String> stations = new ArrayList<>();

    public Line(String name, List<String> station) {
        this.name = name;
        stations.addAll(station);
    }

    public String getName() {
        return name;
    }

    public List<String> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void addSection(String station, int order) {
        int index = order-1;
        stations.add(index, station);
    }

    public void deleteLineByName(String stationName) {
        this.stations.removeIf(station -> Objects.equals(station, stationName));
    }
}
