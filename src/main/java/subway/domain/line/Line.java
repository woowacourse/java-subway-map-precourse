package subway.domain.line;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<Station> sections;

    private Line(String name, List<Station> sections) {
        this.name = name;
        this.sections = sections;
    }

    public static Line createLine(String name, Station upwardEndStation, Station downwardEndStation) {
        LineNameValidator.validate(name);
        List<Station> sections = new ArrayList<>();
        sections.add(upwardEndStation);
        sections.add(downwardEndStation);
        return new Line(name, sections);
    }

    public void addSection(Station station, int sequence) {
        sections.add(sequence, station);
    }

    public void deleteSection(String stationName) {
        sections.removeIf(station -> Objects.equals(station.getName(), stationName));
    }

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public boolean isMatchedName(String name) {
        return this.name.equals(name);
    }

    public int countSections() {
        return sections.size();
    }

    public boolean isIncluded(String stationName) {
        return sections.stream()
                .anyMatch(station -> station.isMatchedName(stationName));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName()) &&
                Objects.equals(getSections(), line.getSections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSections());
    }
}
