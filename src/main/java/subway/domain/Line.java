package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<String> stations;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(String station) {
        stations.add(station);
    }

    // 추가 기능 구현
}
