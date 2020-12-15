package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private LineName name;
    private List<Station> stations = new ArrayList<>();

    public Line(LineName name) {
        this.name = name;
    }

    public LineName getName() {
        return name;
    }

    public void addStations(Station station) {
        station.setRegister(true);
        stations.add(station);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Line) {
            Line anotherStation = (Line) object;
            return name.equals(anotherStation.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return Constants.INFORMATION + name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int size() {
        return stations.size();
    }

    public void addStations(int index, Station station) {
        stations.add(index, station);
    }

}
