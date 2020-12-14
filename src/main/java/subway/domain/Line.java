package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    // 추가 기능 구현
    public void addStation(int position, Station station) {
        stations.add(position, station);
    }

    public void removeStation(Station station) {
        stations.remove(station);
    }

    public boolean containsStation(Station station) {
        return stations.contains(station);
    }
}
