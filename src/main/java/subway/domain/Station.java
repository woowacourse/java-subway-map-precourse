package subway.domain;

import subway.exception.StationAlreadyExistsException;
import subway.exception.StationNameLengthException;

public class Station {

    private final String name;

    private Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        validateLength(name);
        validateExists(name);
        return new Station(name);
    }

    public void save() {
        StationRepository.addStation(this);
    }

    public String getName() {
        return name;
    }

    private static void validateLength(String name) {
        if (name.length() < 2) {
            throw new StationNameLengthException(name);
        }
        if (5 < name.length()) {
            throw new StationNameLengthException(name);
        }
    }

    private static void validateExists(String name) {
        if (LineRepository.exists(name)) {
            throw new StationAlreadyExistsException(name);
        }
    }
}
