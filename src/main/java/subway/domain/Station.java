package subway.domain;

import subway.domain.exception.ExistentNameException;
import subway.domain.exception.UnvalidNameLengthException;
import subway.domain.exception.NonExistentNameException;
import subway.domain.exception.RegisteredStationException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private static final int MINIMUM_LENGTH = 2;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean validateAddStationName(String stationName, String stationMessage) {
        if (!StationRepository.validateNewName(stationName)) {
            throw new ExistentNameException(stationMessage);
        }
        if (!validateStationNameLength(stationName)) {
            throw new UnvalidNameLengthException();
        }
        return true;
    }

    public static boolean validateDeleteStationName(String stationName, String stationMessage) {
        if (StationRepository.validateNewName(stationName)) {
            throw new NonExistentNameException(stationMessage);
        }
        if (!LineRepository.validateNewStationName(stationName)) {
            throw new RegisteredStationException();
        }
        return true;
    }

    private static boolean validateStationNameLength(String stationName) {
        if (stationName.length() >=  MINIMUM_LENGTH) {
            return true;
        }
        return false;
    }
}
