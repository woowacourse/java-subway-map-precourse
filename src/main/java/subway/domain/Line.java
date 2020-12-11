package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isContaining(Station station) {
        return stations.contains(station);
    }

    public boolean equalName(String newName) {
        return name.equals(newName);
    }

        // 추가 기능 구현
}
