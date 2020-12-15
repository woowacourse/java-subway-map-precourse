package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String INFO = "[INFO] ";
    private static final String STATION_NUMBER_MESSAGE = "[ERROR] 노선의 역 개수가 2개 이하이므로 삭제할 수 없습니다.";

    private String name;
    private List<Station> stationsOnLine = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public void registerStation(Station station) {
        stationsOnLine.add(station);
    }

    public boolean isStationRegistered(String stationName) {
        for (Station station : stationsOnLine) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

    public void printStations() {
        for (Station station : stationsOnLine) {
            System.out.println(INFO + station.getName());
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String lineName) {
        return this.name.equals(lineName);
    }

    public int getSize() {
        return stationsOnLine.size();
    }

    public void insert(Station station, int order) {
        stationsOnLine.add(order-1, station);
    }

    public void remove(String stationName) {
        if (stationsOnLine.size() <= 2) {
            throw new IllegalArgumentException(STATION_NUMBER_MESSAGE);
        }
        stationsOnLine.remove(new Station(stationName));
    }
}
