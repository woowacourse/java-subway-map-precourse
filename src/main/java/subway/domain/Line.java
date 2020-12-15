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

    public boolean isStationContainInLine(String name) {
        for (Station section : sections) {
            if (section.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void addStationInSection(int idx, String name) {
        sections.add(idx - 1, new Station(name));
        updateTerminalStations();
    }

    public void deleteStationInSection(String name) {
        sections.removeIf(station -> Objects.equals(station.getName(), name));
        updateTerminalStations();
    }

    public List<Station> getSection() {
        return Collections.unmodifiableList(sections);
    }

    private void updateTerminalStations() {
        firstStation = sections.get(0).getName();
        lastStation = sections.get(sections.size() - 1).getName();
    }
}
