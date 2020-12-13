package subway.line;

import subway.station.Station;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> lines;

    public Line(String name) {
        this.name = name;
        this.lines = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        lines.add(station);
    }

    public boolean isStationInLine(String stationName) {
        for (Station station : lines) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }
}
