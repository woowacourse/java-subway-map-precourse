package subway.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, Station... stations) {
        this.name = name;
        this.stations = new LinkedList<>(Arrays.asList(stations));
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void add(int index, Station station) {
        stations.add(index, station);
//TODO catch (IndexOutOfBoundsException e) error handling
    }

    public boolean remove(Station station) {
        return stations.remove(station);
    }
}
