package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private static final List<Station> stationLine = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public Line addStation(Station station){
        stationLine.add(station);
        return this;
    }

    public boolean isSameName(String name) {
        return this.getName().equals(name);
    }

    public void insertStation(String stationName, int order) {
        stationLine.add(order+1, new Station(stationName));
    }
}
