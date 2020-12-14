package subway.domain.line;

import subway.domain.station.Station;

import java.util.ArrayList;
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

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return sections;
    }

    public boolean isMatchedName(String name) {
        return this.name.equals(name);
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
