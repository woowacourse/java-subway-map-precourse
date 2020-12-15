package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> sections;

    public Line(String name) {
        this.name = name;
        this.sections = new LinkedList<>();
    }

    public List<Station> sections() {
        return Collections.unmodifiableList(sections);
    }

    public void addStationAt(int index, Station station) {
        sections.add(index, station);
    }

    public void removeStation(Station station) {
        sections.remove(station);
    }

    public boolean contains(Station station) {
        return sections.contains(station);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        this.sections.add(station);
    }

    // 추가 기능 구현
}
