package subway.domain;

import subway.Constant;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    public List<Station> stations = new ArrayList<Station>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean existStation(String stationName) {
        return stations.stream().noneMatch(s -> s.getName().equals(stationName));
    }

    public void addStation(String stationName, int order) {
        stations.add(order, new Station(stationName));
    }

    public boolean checkStationSize() {
        return stations.size() <= Constant.MIN_LENGTH;
    }
}
