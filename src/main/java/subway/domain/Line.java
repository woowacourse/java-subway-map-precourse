package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(String stationName) {
        stations.add(new Station(stationName));
    }

    public boolean isStation(String stationName) {
        for (Station station : stations) {
            if (station.isEqualName(stationName)) {
                return true;
            }
        }
        return false;
    }
}
