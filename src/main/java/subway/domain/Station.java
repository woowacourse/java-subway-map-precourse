package subway.domain;

import subway.exception.AlreadyRegisteredStationNameException;
import subway.exception.StationNameLengthException;

public class Station {

    private final String name;

    private Station(String name) {
        this.name = name;
    }

    public static Station from(String name) {
        validateLength(name);
        return new Station(name);
    }

    public void save() {
        validateExists(name);
        StationRepository.addStation(this);
    }

    public String getName() {
        return name;
    }

    private static void validateLength(String name) {
        if (name.length() < 2) {
            throw new StationNameLengthException(name);
        }
    }

    private static void validateExists(String name) {
        if (StationRepository.exists(name)) {
            throw new AlreadyRegisteredStationNameException(name);
        }
    }
}
