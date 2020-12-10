package subway.domain;

import subway.view.LineMessages;
import subway.view.StationMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    public static final int NAME_LENGTH_LOWER_BOUND = 2;

    private String name;
    private final List<Station> sections = new ArrayList<>();

    public Line(String name, String upwardDestination, String downwardDestination) throws IllegalArgumentException {
        validateDuplicate(name);
        validateNameLength(name);
        StationRepository.validateRegistration(upwardDestination);
        StationRepository.validateRegistration(downwardDestination);
        this.name = name;
        this.sections.add(new Station(upwardDestination));
        this.sections.add(new Station(downwardDestination));
    }

    public String getName() {
        return name;
    }

    public List<Station> sections(Line line) {
        return Collections.unmodifiableList(sections);
    }

    public void addSection(Line line, Station station, int location) {
        sections.add(location, station);
    }

    private boolean hasName(String name) {
        return LineRepository.lines().stream()
                .map(Line::getName)
                .anyMatch(stationName -> stationName.equals(name));
    }

    private void validateDuplicate(String name) throws IllegalArgumentException {
        if (hasName(name)) {
            throw new IllegalArgumentException(LineMessages.DUPLICATE_NAME_ERROR.getMessage());
        }
    }

    private void validateNameLength(String name) throws IllegalArgumentException {
        if (name.length() < NAME_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException(LineMessages.NAME_LENGTH_ERROR.getMessage());
        }
    }
}
