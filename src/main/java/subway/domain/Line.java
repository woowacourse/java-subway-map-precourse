package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Station> section = new LinkedList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean isContains(String stationName) {
        Station find = StationRepository.findStation(stationName);
        return section.contains(find);
    }

    public boolean isValidSection(int index) {
        return section.size() < index;
    }

    public void addStation(int index, String name) {
        Station station = StationRepository.findStation(name);
        section.add(index, station);
    }

    public void addStation(String name) {
        Station station = StationRepository.findStation(name);
        section.add(station);
    }

    public void removeStation(String name) {
        section.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
