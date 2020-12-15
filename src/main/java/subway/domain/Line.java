package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private List<Station> stationList = new ArrayList<>();

    public void add(Station station) {
        stationList.add(station);
    }

    public int size() {
        return stationList.size();
    }
}
