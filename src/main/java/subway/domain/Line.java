package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private final List<Station> stations = new LinkedList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    @Override
    public String toString() {
        return "[INFO] " + name + "\n";
    }
}
