package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private String firstStation;
    private String lastStation;
    private List<Station> section = new ArrayList<>();

    public Line(String name, String firstStation, String lastStation) {
        this.name = name;
        this.firstStation = firstStation;
        this.lastStation = lastStation;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean isContain(String name) {
        return section.contains(new Station(name));
    }

    public boolean isMinLength() {
        return section.size() >= Constants.MIN_LINE_LENGTH;
    }

    public void addStationInSection(int idx, String name) {
        section.add(idx - 1, new Station(name));
        if (idx == section.size()) {
            lastStation = name;
        }
        if (idx == 1) {
            firstStation = name;
        }
    }

    public void deleteStationInSection(String name) {
        section.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public List<Station> getSection() {
        return Collections.unmodifiableList(section);
    }
}
