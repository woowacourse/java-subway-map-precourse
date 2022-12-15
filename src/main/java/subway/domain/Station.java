package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Station {
    private final String name;
    private final List<Line> lines = new LinkedList<>();

    public Station(String name) {
        this.name = name;
    }

    public void addLines(List<Line> lines) {
        this.lines.addAll(lines);
    }

    public String getName() {
        return name;
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
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
