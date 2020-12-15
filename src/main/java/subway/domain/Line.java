package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private String name;

    private List<Station> stations = new ArrayList<Station>();

    public Line(String name) {
        this.name = name;
    }

    public void addStation(Station station) {
        stations.add(station);
        station.addNumberOnLines();
    }

    public List<Station> getStations() {
        return stations;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object object) {
        if (object instanceof Line) {
            return ((Line) object).name.equals(this.name);
        }
        return false;
    }

    public String toString() {
        return name;
    }
}
