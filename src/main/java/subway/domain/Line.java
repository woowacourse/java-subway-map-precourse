package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public void addStreamStation(String upstreamStation, String downstreamStation) {
        stations.add(new Station(upstreamStation));
        stations.add(new Station(downstreamStation));
    }
}
