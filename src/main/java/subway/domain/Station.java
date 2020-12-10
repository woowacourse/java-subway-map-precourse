package subway.domain;

import subway.view.General;
import subway.view.StationMessages;

public class Station {
    public static final int NAME_LENGTH_LOWER_BOUND = 2;

    private String name;

    public Station(String name) throws IllegalArgumentException {
        validateDuplicate(name);
        validateNameLength(name);
        this.name = name;
    }

    private boolean hasName(String name) {
        return StationRepository.stations().stream()
                .map(Station::getName)
                .anyMatch(stationName -> stationName.equals(name));
    }

    private void validateDuplicate(String name) throws IllegalArgumentException {
        if (hasName(name)) {
            throw new IllegalArgumentException(StationMessages.DUPLICATE_NAME_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateNameLength(String name) throws IllegalArgumentException {
        if (name.length() < NAME_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException(StationMessages.NAME_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
