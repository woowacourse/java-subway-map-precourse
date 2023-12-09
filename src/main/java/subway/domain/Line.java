package subway.domain;

import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NAME;
import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NAME_CHARACTER;
import static subway.exception.ExceptionMessage.INVALID_ADD_LINE_NAME_SUFFIX;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private final String name;
    private final List<Station> sections = new LinkedList<>();

    public Line(String name, Station... stations) {
        validate(name);
        this.name = name;
        this.sections.addAll(Arrays.asList(stations));
    }

    private void validate(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NAME.getMessage());
        }
        if (name.chars().anyMatch(character -> character < '가' || '힣' < character)) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NAME_CHARACTER.getMessage());
        }
        if (!name.endsWith("선")) {
            throw new IllegalArgumentException(INVALID_ADD_LINE_NAME_SUFFIX.getMessage());
        }
    }

    public void addSection(Station station, int index) {
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
}
