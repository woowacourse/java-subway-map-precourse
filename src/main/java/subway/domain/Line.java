package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean containsStation(Station station) {
        return containsStation(station.getName());
    }

    public boolean containsStation(String name) {
        return stations.stream()
                .anyMatch(streamStation -> name.equals(streamStation.getName()));
    }
}
