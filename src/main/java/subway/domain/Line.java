package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String INFO = "[INFO] ";

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
}
