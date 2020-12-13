package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stationOfLine = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public List<Station> getStationOfLine() {
        return stationOfLine;
    }

    public void insertStationInLine(Station station) {
        this.stationOfLine.add(station);
    }

    public boolean isEqual(String name) {
        if (this.name.compareTo(name) == 0) return true;
        return false;
    }

}
