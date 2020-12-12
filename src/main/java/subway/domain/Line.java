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
        return (Line) stationLine;
    }
}
