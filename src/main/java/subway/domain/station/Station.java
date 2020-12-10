package subway.domain.station;

import subway.domain.StationLine;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private List<StationLine> stationLines = new ArrayList<>();

    private Station(String name) {
        this.name = name;
    }

    public static Station of(String name) {
        return new Station(name);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
