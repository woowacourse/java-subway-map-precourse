package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Station> stations;

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
