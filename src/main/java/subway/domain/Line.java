package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private final List<Station> stationList = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void enrollStation(Station station){
        stationList.add(station);
    }

    public List<Station> getStationList() {
        return Collections.unmodifiableList(stationList);
    }
}
