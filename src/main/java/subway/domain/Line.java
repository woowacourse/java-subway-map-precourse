package subway.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private final int MIN_SECTION_INDEX = 0;
    private final int MIN_NAME_LENGTH = 2;

    private List<Station> stations;

    public Line(String name) {
        this.name = name;
        this.stations = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public void addStations(String... stationNames) {
        Arrays.stream(stationNames).forEach(stationName -> stations.add(new Station(stationName)));
    }

    public List<Station> getStations() {
        return stations;
    }

    public boolean addStation(int parseInt, String stationName) {
        if (parseInt < MIN_SECTION_INDEX || parseInt > stations.size()+1) {
            return false;
        }
        if (stationName.length() < MIN_NAME_LENGTH) {
            return false;
        }
        stations.add(parseInt-1, new Station(stationName)); // 구간의 순서가 1부터 시작하기 때문에 1을 뺀다.
        return true;
    }

    public boolean hasStation(String name) {
        return stations.stream().anyMatch(station -> station.getName().equals(name));
    }
}
