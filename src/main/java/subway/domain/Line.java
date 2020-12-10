package subway.domain;

import subway.view.StationMessages;

import java.util.List;

public class Line {
    public static final int NAME_LENGTH_LOWER_BOUND = 2;

    private String name;
    private List<Station> stations;

    public Line(String name) throws IllegalArgumentException {
        validateDuplicate(name);
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean hasName(String name) {
        return LineRepository.lines().stream()
                .map(Line::getName)
                .anyMatch(stationName -> stationName.equals(name));
    }

    private void validateDuplicate(String name) throws IllegalArgumentException {
        if (hasName(name)) {
            throw new IllegalArgumentException(StationMessages.DUPLICATE_NAME_ERROR.getMessage());
        }
    }

    private void validateNameLength(String name) throws IllegalArgumentException {
        if (name.length() < NAME_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException(StationMessages.NAME_LENGTH_ERROR.getMessage());
        }
    }
}
