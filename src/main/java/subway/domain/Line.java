package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;

    private static final List<Station> lineStations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addLineStation(Station station){
        lineStations.add(station);
    }
}
