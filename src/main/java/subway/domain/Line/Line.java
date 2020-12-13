package subway.domain.Line;

import subway.domain.name.LineName;
import subway.domain.station.Station;
import subway.exception.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line implements Comparable<Line> {

    private LineName name;

    private final List<Station> stations = new LinkedList<>();
    private static final int STATIONS_MIN_INDEX = 1;
    private static final int ONE_INDEX = 1;
    private static final int STATIONS_MIN_CAPACITY = 2;


    private Line(LineName name) {
        this.name = name;
    }

    public static Line of(String name, Station start, Station end) {

        if (validateStations(start, end)) {
            throw new DuplicateStationException();
        }

        Line line = new Line(LineName.of(name));

        line.setStations(start, end);

        return line;
    }

    private static boolean validateStations(Station start, Station end) {
        return start.equals(end);
    }

    private void setStations(Station start, Station end) {
        addStation(start);
        addStation(end);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        if (isContains(station)) {
            throw new AlreadyAddStationException(station);
        }
        stations.add(station);
        station.addLine(this);
    }


    public void clear() {
        stations.stream().forEach(station -> {
            station.removeLine(this);
        });
    }

    public void removeStation(Station station) {

        if (!canRemoveStation()) {
            throw new CannotRemoveException(this);
        }

        station.removeLine(this);
        stations.remove(station);
    }

    private boolean isContains(Station station) {
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

    public boolean isSameName(String name) {
        return this.name.equals(LineName.of(name));
    }

    public void addTo(int order, Station station) {

        if (!isValidOrder(order)) {
            throw new InvalidOrderException();
        }
        station.addLine(this);
        stations.add(order - ONE_INDEX, station);
    }

    private boolean isValidOrder(int order) {

        if (order >= STATIONS_MIN_INDEX && order <= stations.size() + ONE_INDEX) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    private boolean canRemoveStation() {
        return stations.size() > STATIONS_MIN_CAPACITY;
    }

    @Override
    public int compareTo(Line o) {
        return name.compareTo(o.name);
    }
}
