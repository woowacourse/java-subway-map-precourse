package subway.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private final String name;
    private final List<Station> sections = new LinkedList<>();

    public Line(String name, Station... stations) {
        this.name = name;
        this.sections.addAll(Arrays.asList(stations));
    }

    public void addSection(Station station, int index) {
        if (index < 1 || index > sections.size()) {
            throw new IllegalArgumentException("입력한 순서에 구간을 추가할 수 없습니다.");
        }
        sections.add(index - 1, station);
    }

    public void removeSection(Station station) {
        sections.remove(station);
    }

    public Station getAscendingStation() {
        return this.sections.get(0);
    }

    public Station getDescendingStation() {
        return this.sections.get(this.sections.size() - 1);
    }

    public boolean contains(Station station) {
        return this.sections.contains(station);
    }

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return Collections.unmodifiableList(this.sections);
    }
}
