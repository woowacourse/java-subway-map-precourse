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

    // 추가 기능 구현
}
