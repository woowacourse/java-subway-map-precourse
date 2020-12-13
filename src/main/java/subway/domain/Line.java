package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private Name name;
    private List<Station> stations;

    private Line(Name name, Station firstStation, Station lastStation) {
        if (firstStation.equals(lastStation)) {
            throw new IllegalArgumentException("상행 종점과 하행 종점이 같을 수 없습니다.");
        }

        this.name = name;

        stations = new LinkedList<>();

        stations.add(firstStation);
        firstStation.onLine();

        stations.add(lastStation);
        lastStation.onLine();
    }

    public static Line create(Name name, Station firstStation, Station lastStation) {
        return new Line(name, firstStation, lastStation);
    }

    public Name getName() {
        return name;
    }

    public boolean isName(Name name) {
        return this.name.equals(name);
    }

    public void addStation(Order order, Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 노선에 포함된 역입니다.");
        }

        if (order.isBiggerThan(stations.size())) {
            throw new IllegalArgumentException("순서는 현재 포함된 역 개수보다 클 수 없습니다.");
        }

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

    public List<String> getStationNames() {
        return stations.stream()
                .map(Station::toString)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
