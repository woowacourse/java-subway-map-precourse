package subway.domain.Line;

import subway.domain.name.LineName;
import subway.domain.station.Station;
import subway.exception.AlreadyAddLineException;
import subway.exception.AlreadyAddStationException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private LineName name;
    // 추가 기능 구현
    private final List<Station> stations = new LinkedList<>();

    private Line(LineName name) {
        this.name = name;
    }

    public static Line of(String name) {
        return new Line(LineName.of(name));
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {

        if (isContains(station)) {
            throw new AlreadyAddStationException(station);
        }
        stations.add(station);
    }

    public boolean isContains(Station station) {
        return stations.contains(station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }
}
