package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private String name;
    private Station upEnd;
    private Station downEnd;

    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public Line(String name, Station upEnd, Station downEnd) {
        this.name = name;
        this.upEnd = upEnd;
        this.downEnd = downEnd;
    }

    public Line(String name, List<Station> stations, Station upEnd, Station downEnd) {
        this.name = name;
        this.stations = stations;
        this.upEnd = upEnd;
        this.downEnd = downEnd;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
