package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private List<String> stations = new ArrayList<>();

    public Line(String name, List<String> station) {
        this.name = name;
        stations.addAll(station);
    }

    public String getName() {
        return name;
    }

    public List<String> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void addSection(String station, int order) {
        stations.add(order-1, station);
    }
    // 추가 기능 구현
}
