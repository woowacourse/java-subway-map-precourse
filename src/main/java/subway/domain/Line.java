package subway.domain;

import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
    public void insertStationInLineIndex(Station station, int idx) {
        this.stationOfLine.add(idx,station);
    }

    public boolean isEqual(String name) {
        if (this.name.compareTo(name) == 0) return true;
        return false;
    }

    public boolean isContainStation(String name) {
        for (Station station : stationOfLine) {
            if (station.getName().compareTo(name) == 0) return true;
        }
        return false;
    }
}
