package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final String name;
    private final List<Station> section = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStationByIndex(int index, Station station) {
        section.add(index, station);
    }

    // 추가 기능 구현

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(name, line.name) && Objects.equals(section, line.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, section);
    }
    @Override
    public String toString() {
        return name;
    }
}
