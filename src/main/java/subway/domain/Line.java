package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, List<Station> terminals) {
        this.name = name;
        this.stations = terminals;
    }

    public String getName() {
        return name;
    }

    public int getLength() { return stations.size(); }

    public boolean validateStation(Station station) {
        return stations.contains(station);
    }

    public void addStation(Station station, int idx) {
        stations.add(idx-1, station);
    }

    public void deleteStation(Station station) {
        stations.remove(station);
    }
}
