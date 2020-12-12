package subway.domain.Line;

import subway.domain.name.LineName;
import subway.domain.station.Station;
import subway.exception.AlreadyAddStationException;
import subway.exception.InvalidLineNameException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private LineName name;
    // 추가 기능 구현
    private final List<Station> stations = new LinkedList<>();
    private static final int STATIONS_MIN_INDEX = 1;
    private static final int ONE_INDEX = 1;


    private Line(LineName name) {
        this.name = name;
    }

    public static Line of(String name, Station start, Station end) {

        Line line = new Line(LineName.of(name));

        line.setStations(start, end);

        return line;
    }



    private void setStations(Station start, Station end) {
        stations.add(start);
        stations.add(end);
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

    public void addTo(int order, Station station) {

        if (isValidOrder(order))

            stations.add(order - ONE_INDEX, station);
    }

    private boolean isValidOrder(int order) {

        if (order < STATIONS_MIN_INDEX && order > stations.size()) {
            return false;
        }
        return true;
    }
}
