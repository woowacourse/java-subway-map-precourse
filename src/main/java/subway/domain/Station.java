package subway.domain;

import subway.view.StationMessages;

public class Station {
    public static final int NAME_LENGTH_LOWER_BOUND = 2;

    private String name;

    public Station(String name) throws IllegalArgumentException {
        StationRepository.validateDuplicate(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) throws IllegalArgumentException {
        if (name.length() < NAME_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException(StationMessages.NAME_LENGTH_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
