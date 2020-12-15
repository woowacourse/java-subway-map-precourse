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

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addStation(int index, Station station) {
        try {
            stations.add(index, station);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new IllegalArgumentException("[ERROR] 가능하지 않는 순서입니다.");
        }
    }

    public boolean deleteStation(Station target) {
        return stations.removeIf(station -> Objects.equals(station, target));
    }

    public boolean isContainedStationName(String name) {
        return stations.stream().anyMatch(station -> Objects.equals(station.getName(), name));
    }

    @Override
    public String toString() {
        return "[INFO] " + name + "\n";
    }
}
