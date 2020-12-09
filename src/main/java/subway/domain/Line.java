package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new LinkedList<>();

    public Line(String name, Station start, Station end) {
        this.name = name;
        this.stations.add(start);
        this.stations.add(end);
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
}
