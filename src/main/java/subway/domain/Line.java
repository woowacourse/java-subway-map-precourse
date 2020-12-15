package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private static final int FROM_ORDER_TO_INDEX = 1;
    private List<Station> sections = new LinkedList<>();

    public List<Station> getSections() {
        return sections;
    }

    public void addSectionByStation(Station station) {
        sections.add(station);
    }

    public void addSectionByOrderAndStation(int orderOfRoute, Station station) {
        sections.add(orderOfRoute - FROM_ORDER_TO_INDEX, station);
    }

    public boolean deleteSectionByName(String name) {
        return sections.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
