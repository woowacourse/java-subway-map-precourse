package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    static final String EMPTY_INFO_MESSAGE = "---";
    static final String INFO_PREFIX = "[INFO] ";
    static final String NEWLINE_CHARACTER = "\n";

    private List<Station> stationLine = new ArrayList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public Line addStation(Station station) {
        stationLine.add(station);
        return this;
    }

    public boolean isSameName(String name) {
        return this.getName().equals(name);
    }

    public void insertStation(String stationName, int order) {
        if (order > stationLine.toArray().length + 1) {
            order = stationLine.toArray().length + 1;
        }
        stationLine.add(order - 1, new Station(stationName));
    }

    public boolean deleteStation(String stationName) {
        for (Station station : stationLine) {
            if (station.isSameName(stationName) && stationLine.toArray().length > 2) {
                stationLine.remove(station);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "";
        result += INFO_PREFIX + this.getName() + NEWLINE_CHARACTER;
        result += INFO_PREFIX + EMPTY_INFO_MESSAGE + NEWLINE_CHARACTER;
        for (Station station : stationLine) {
            result += INFO_PREFIX + station.getName() + NEWLINE_CHARACTER;
        }
        return result;
    }

    public boolean containStation(String stationName) {
        for (Station station : stationLine) {
            if (station.isSameName(stationName)) {
                return true;
            }
        }
        return false;
    }
}
