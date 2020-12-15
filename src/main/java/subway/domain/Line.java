package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private final Name name;
    private final List<Station> stations = new LinkedList<>();

    public Line(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    // stationOrder의 순서에 역(구간)을 삽입한다.
    public void addLineStation(int stationOrder, Station station) {
        stations.add(stationOrder, station);
    }

    public void deleteLineStation(Station station) {
        stations.removeIf(stations -> stations.equals(station));
    }

    public List<Station> getStations() {
        return stations;
    }

    @Override
    public boolean equals(Object object) {
        if (getClass() != object.getClass()) {
            return false;
        }
        boolean isEqualObject = false;
        Line line = (Line) object;
        if (getName().equals(line.getName())) {
            isEqualObject = true;
        }
        return isEqualObject;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        hashCode = prime * hashCode + getName().hashCode();
        return hashCode;
    }
}
