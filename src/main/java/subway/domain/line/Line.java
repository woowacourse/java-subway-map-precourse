package subway.domain.line;

import subway.domain.StationLine;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<StationLine> stationLines = new ArrayList<>();

    private Line(String name) {
        this.name = name;
    }

    public static Line of(String name) {
        return new Line(name);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
