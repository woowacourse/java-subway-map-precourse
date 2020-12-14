package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private String firstStation;
    private String lastStation;
    private List<Station> sections = new ArrayList<>();

    public Line(String name, String firstStation, String lastStation) {
        this.name = name;
        this.firstStation = firstStation;
        this.lastStation = lastStation;
        this.sections.add(new Station(firstStation));
        this.sections.add(new Station(lastStation));
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public boolean isContain(String name) {
        for (Station section : sections) {
            if (section.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public boolean isMinLength() {
        return sections.size() >= Constants.MIN_NAME_LENGTH;
    }

    public void addStationInSection(int idx, String name) {
        sections.add(idx - 1, new Station(name));
        if (idx == sections.size()) {
            lastStation = name;
        }
        if (idx == 1) {
            firstStation = name;
        }
    }

    public void deleteStationInSection(String name) {
        sections.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public List<Station> getSection() {
        return Collections.unmodifiableList(sections);
    }
}
