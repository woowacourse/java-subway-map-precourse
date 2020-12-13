package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, Station firstStation, Station lastStation) {
        this.name = name;
        stations.add(firstStation);
        stations.add(lastStation);
    }

    public String getName() {
        return name;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public void addStation(int order, Station station) {
        if (order < 1) {
            throw new IllegalArgumentException("순서는 1부터 가능합니다.");
        }

        if (order > stations.size()) {
            throw new IllegalArgumentException("순서는 현재 노선의 크기보다 클 수 없습니다.");
        }

        this.stations.add(order, station);
    }

    @Override
    public String toString() {
        return name;
    }
}
