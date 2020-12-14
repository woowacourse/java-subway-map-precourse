package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    private List<Station> stationList = new LinkedList<>();

    public void addStation(String stationName) {
        stationList.add(new Station(stationName));
    }

    public void addStation(String stationName, int index) {
        stationList.add(index-1, new Station(stationName));
    }

    public boolean deleteStation(String stationName) {
        return stationList.removeIf(station -> Objects.equals(station.getName(), stationName));
    }

    /*public boolean equal(String lineName) {
        return name.equals(lineName);
    }*/

}
