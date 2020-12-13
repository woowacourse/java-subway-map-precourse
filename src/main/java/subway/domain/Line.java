package subway.domain;

import java.util.List;

public class Line {
    private Name name;
    private List<Station> stations;

    public Line(Name name, Station firstStation, Station lastStation) {
        this.name = name;

        stations.add(firstStation);
        firstStation.onLine();

        stations.add(lastStation);
        lastStation.onLine();
    }

    public Name getName() {
        return name;
    }

    public boolean isName(Name name) {
        return this.name.equals(name);
    }

    public void addStation(Order order, Station station) {
        stations.add(order.getValue(), station);
        station.onLine();
    }

    public void deleteSection(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException("해당 노선에 존재하지 않는 역입니다.");
        }

        stations.remove(station);
        station.outOfLine();
    }

    public void removeAllStations() {
        stations.stream().forEach(Station::outOfLine);
        stations = null;
    }

    public int getStationCount() {
        return stations.size();
    }

    public boolean isContains(Station station) {
        return stations.contains(station);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
