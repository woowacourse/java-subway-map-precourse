package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stationList;

    public Line(String name) {
        this.name = name;
        stationList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addStation(Station station) {
        stationList.add(station);
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public boolean deleteStation(String name) {
        return stationList.removeIf(station -> station.getName().equals(name));
    }
}
