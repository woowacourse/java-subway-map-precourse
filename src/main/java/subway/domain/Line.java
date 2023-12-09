package subway.domain;

import static subway.exception.ExceptionMessage.INVALID_ADD_SECTION_INDEX;

import java.util.Arrays;
import java.util.List;

public class Line {
    private final String name;
    private final Section sections;

    public Line(String name, Station... stations) {
        this.name = name;
        this.sections = new Section(Arrays.asList(stations));
    }

    public void addSection(Station station, int index) {
        if (index < 1 || index > sections.size()) {
            throw new IllegalArgumentException(INVALID_ADD_SECTION_INDEX.getMessage());
        }
        sections.add(index - 1, station);
    }

    public void removeSection(Station station) {
        sections.remove(station);
    }

    public Station getAscendingStation() {
        return this.sections.getAscendingStation();
    }

    public Station getDescendingStation() {
        return this.sections.getDescendingStation();
    }

    public boolean contains(Station station) {
        return this.sections.contains(station);
    }

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return this.sections.getSection();
    }
}
