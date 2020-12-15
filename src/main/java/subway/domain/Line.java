package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    private String name;
    private List<Station> section = new ArrayList<>();

    public Line(String name, Station upward, Station downward) {
        this.name = name;
        addSection(upward);
        addSection(downward);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addSection(Station station) {
        section.add(station);
    }

    public void addSection(int index, Station station) {
        section.add(index-1, station);
    }

    public List<Station> getSection() {
        return section;
    }

    public void deleteSection(int index) {
        section.remove(index);
    }
}
