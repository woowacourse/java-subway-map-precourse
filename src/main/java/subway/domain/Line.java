package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int ONE = 1;

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStation(String stationName) {
        stations.add(new Station(stationName));
    }

    public void addSection(String stationName, String order) {
        int index = parseInt(order) - ONE; // 역이 삽입되는 index = 순서 - 1
        stations.add(index, new Station(stationName));
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }

    public void deleteSection(String stationName) {
        stations.stream()
                .filter(station -> station.isEqualName(stationName))
                .findAny()
                .ifPresent(station -> stations.remove(station));
    }

    public boolean isStation(String stationName) {
        return stations.stream()
                       .anyMatch(station -> station.isEqualName(stationName));
    }

    public boolean isEqualName(String lineName) {
        return name.equals(lineName);
    }

    public boolean isBiggerThan(int number) {
        return (stations.size() >= number);
    }
}
