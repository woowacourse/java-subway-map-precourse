package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private static final int UP_END_INDEX = 0;

    private String name;
    private Station upEnd;
    private Station downEnd;

    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Station upEnd, Station downEnd) {
        this.name = name;
        this.upEnd = upEnd;
        this.downEnd = downEnd;
    }

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
        this.upEnd = stations.get(UP_END_INDEX);
        this.downEnd = stations.get(stations.size() - 1);
    }

    public String getName() {
        return name;
    }

    public Station getUpEnd() {
        return upEnd;
    }

    public Station getDownEnd() {
        return downEnd;
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

    public void addNewLink(Link newLink) {
        Station station = new Station(newLink.getStationName());
        int targetIndex = newLink.getOrder();
        stations.add(targetIndex, station);
    }
}
