package subway.domain;

import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

public class Station {
    private static final int MIN_LENGTH = 2;
    private String name;

    public Station(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < 2) {
            throw CustomException.from(ErrorMessage.STATION_NAME_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
