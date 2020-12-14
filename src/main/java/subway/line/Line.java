package subway.line;

import subway.station.Station;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private LinkedList<Station> stations;

    public Line(String name, Station upEndStation, Station downEndStation) {
        this.name = name;
        this.stations = new LinkedList<>();
        this.stations.add(upEndStation);
        this.stations.add(downEndStation);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station, int order) {
        int orderIdx = order - 1;
        int numOfStations = stations.size();
        if (orderIdx > numOfStations || numOfStations < 0) {
            throw new IllegalArgumentException("추가할 수 없는 순서 입니다.");
        }
        stations.add(orderIdx, station);
    }

    public boolean isStationInLine(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }
}
