package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {

    private static final int MINIMUM_SECTION_LENGTH = 2;

    private final List<Station> section = new LinkedList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean contains(String stationName) {
        Station find = StationRepository.findStationByName(stationName);
        return section.contains(find);
    }

    public boolean canRemove() {
        return section.size() > MINIMUM_SECTION_LENGTH;
    }

    public boolean isValidSection(int index) {
        return section.size() < index;
    }

    public void addStation(int index, String name) {
        Station station = StationRepository.findStationByName(name);
        section.add(index, station);
    }

    public void addStation(String name) {
        Station station = StationRepository.findStationByName(name);
        section.add(station);
    }

    public void removeStationByName(String name) {
        section.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
