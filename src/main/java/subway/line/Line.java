package subway.line;

import subway.station.Station;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, Station upEndStation, Station downEndStation) {
        this.name = name;
        this.stations = new ArrayList<>();
        this.stations.add(upEndStation);
        this.stations.add(downEndStation);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
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
