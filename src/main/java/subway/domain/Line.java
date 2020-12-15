package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    public static final int NAME_MIN_LENGTH = 2;

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

    public void addStation(int index, Station station) {
        stations.add(index, station);
    }

    public boolean deleteStation(Station target) {
        return stations.removeIf(station -> Objects.equals(station, target));
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    @Override
    public String toString() {
        return "[INFO] " + name + "\n";
    }
}
