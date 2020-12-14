package subway.domain;

import java.util.*;

public class Line {
    private static final String ERR_OUT_OF_BOUND = "노선의 길이 범위를 벗어나는 순서값입니다.";
    private static final String ERR_DUPLICATE_STATION_IN_LINE = "동일 노선에 동일한 이름의 역이 존재합니다.";
    private final String name;
    private final List<Station> stations;

    public Line(String name) {
        this.name = name;
        this.stations = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getLength() {
        return stations.size();
    }

    public void add(int index, Station station) {
        checkDuplicateStationInLine(station);
        try {
            stations.add(index, station);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ERR_OUT_OF_BOUND);
        }
    }

    public void add(Station... stationList) {
        for (Station station : stationList) {
            stations.add(stations.size(), station);
        }
    }

    private void checkDuplicateStationInLine(Station station) {
        if (hasStation(station)) {
            throw new IllegalArgumentException(ERR_DUPLICATE_STATION_IN_LINE);
        }
    }

    public boolean hasStation(Station station) {
        return stations.contains(station);
    }

    public boolean remove(Station station) {
        return stations.remove(station);
    }
}
