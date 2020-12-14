package subway.domain;

import java.util.List;

public class Line {
    private Name name;
    private LineStations stations;

    private Line(Name name, Station startStation, Station endStation) {
        this.name = name;
        stations = LineStations.create(startStation, endStation);
    }

    public static Line create(Name name, Station firstStation, Station lastStation) {
        return new Line(name, firstStation, lastStation);
    }

    public boolean isName(Name name) {
        return this.name.equals(name);
    }

    public void addStation(Order order, Station station) {
        stations.addStation(order.getIndex(), station);
    }

    public void deleteSection(Station station) {
        stations.deleteSection(station);
    }

    public void removeAllStations() {
        stations.removeAll();
    }

    public List<String> getStationNames() {
        return stations.getStationNames();
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Line) {
            return name.equals(((Line) o).name);
        }
        return false;
    }

}
