package subway.domain;

import java.util.LinkedList;

public class Line {
    private static final String ERROR_INDEX_NOT_IN_RANGE = "[ERROR] 잘못된 순서입니다.";
    private static final String ERROR_STATION_ALREADY_ON_LINE = "[ERROR] 이미 존재하는 역입니다.";
    private static final String ERROR_STATION_NOT_ON_LINE = "[ERROR] 노선에 해당 역이 없습니다.";
    private String name; // 변경 불가능
    private LinkedList<Station> stationsOnLine; // 해당 노선에 소속된 역(들)

    public Line(String name) { // 변경 불가능
        this.name = name;
    }

    public String getName() { // 변경 불가능
        return name;
    }

    public void addStation(Station station, int index) {
        if(isStationInLine(station)) {
            throw new IllegalArgumentException(ERROR_STATION_ALREADY_ON_LINE);
        }
        if(isIndexInRange(index)) {
            throw new IllegalArgumentException(ERROR_INDEX_NOT_IN_RANGE);
        }
        stationsOnLine.add(index, station);
    }

    public void deleteStation(Station station) {
        if(!isStationInLine(station)) {
            throw new IllegalArgumentException(ERROR_STATION_NOT_ON_LINE);
        }
        stationsOnLine.remove(station);
    }

    private boolean isIndexInRange(int index) {
        return index < stationsOnLine.size() && index >= 0;
    }

    private boolean isStationInLine(Station station) {
        return stationsOnLine.contains(station);
    }
}
