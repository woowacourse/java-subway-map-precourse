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

    // 추가 기능 구현

    public List<Station> getStations() {
        return stations;
    }

    public void addStationByOrder(Station station, int order) {
        this.stations.add(order, station);
    }
}
