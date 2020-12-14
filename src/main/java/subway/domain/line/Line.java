package subway.domain.line;

import subway.domain.station.Station;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line {
    private final String name;
    private final List<Station> stationList;

    public Line(String name, List<Station> stationList) {
        this.name = name;
        this.stationList = stationList;
    }

    public String getName() {
        return name;
    }

    public static Line getLine(String lineName, Station startStation, Station endStation) {
        if (LineCheck.checkLineNameLength(lineName) && LineCheck.checkLineNameEndPoint(lineName)) {
        }
        return new Line(lineName, Arrays.asList(startStation, endStation));
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

    public boolean contains(Station station) {
        return stationList.contains(station);
    }

    public void insertSection(int index, Station station) {
        stationList.add(index, station);
    }
}
