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

// 추가 기능 구현
    public void addStations(String[] stationNames){
        for(String station : stationNames){
            stations.add(new Station(station));
        }
    }

    public List<Station> getStations() {
        return stations;
    }
}
