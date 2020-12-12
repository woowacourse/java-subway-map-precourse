package subway.line;

import subway.station.Station;

public class Line {
    private String name;
    private EachLineStations stations;

    public Line(String name) {
        this.name = name;
        this.stations = new EachLineStations();
    }

    public Line(String name, EachLineStations stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.addStation(station);
    }
}
