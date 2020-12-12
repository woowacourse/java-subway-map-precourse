package subway.domain.station;

import subway.domain.Line.Line;
import subway.domain.name.LineName;
import subway.domain.name.StationName;
import subway.exception.AlreadyLinkedException;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Station implements Comparable<Station> {
    private StationName name;

    private final List<Line> lines = new LinkedList<>();

    private Station(StationName name) {
        this.name = name;
    }

    public static Station of(String name) {
        return new Station(StationName.of(name));
    }

    public boolean canRemove() {

        return lines.isEmpty();
    }

    public void clear() {
        lines.stream().forEach(line -> line.removeStations(this));
    }

    public void removeLine(Line line) {
        lines.remove(line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int compareTo(Station o) {
        return name.compareTo(o.name);
    }

    public boolean isSameName(String name) {
        return this.name.isSameName(name);
    }

    public void addLine(Line line) {
        if (lines.contains(line)) {
            throw new AlreadyLinkedException(line, this);
        }
        lines.add(line);
    }

    public boolean containLine(LineName lineName) {
        return lines.stream().anyMatch(line -> line.isSameName(lineName.toString()));
    }


    // 추가 기능 구현
}
