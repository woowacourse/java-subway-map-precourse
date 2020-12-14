package subway.domain.list;

import subway.domain.station.Station;
import subway.domain.station.StationCheck;

import java.util.Objects;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Line getLine(String lineName) {
        if (LineCheck.checkLineNameLength(lineName) && LineCheck.checkLineNameEndPoint(lineName)) {
        }
        return new Line(lineName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
