package subway.domain;

import java.util.LinkedList;

public class Line {

    private String name;
    private final LinkedList<Station> stations = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addFirst(Station station) {
        this.stations.addFirst(station);
    }

    public void addLast(Station station) {
        this.stations.addLast(station);
    }

    public boolean hasStation(String name) {
        for (Station station : this.stations) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
