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

    public void addStation(int order, Station station) {
        if (order < 1) {
            throw new IllegalArgumentException("순서는 1부터 가능합니다.");
        }

        if (order > stations.size()) {
            throw new IllegalArgumentException("순서는 현재 노선의 크기보다 클 수 없습니다.");
        }

        stations.add(order, station);
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

    @Override
    public String toString() {
        return name.toString();
    }
}
