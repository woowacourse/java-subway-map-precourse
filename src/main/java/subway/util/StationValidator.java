package subway.util;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class StationValidator {

    private static final int SIZE = 2;

    public static boolean checkValidStationName(String name) {
        if (checkValidName(name) && !checkDuplicateName(name)) {
            return true;
        }
        return false;
    }

    public static boolean checkDuplicateName(String name) {
        for(Station station : StationRepository.stations()) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkValidName(String name) {
        if (name.length() >= SIZE) {
            return true;
        }
        return false;
    }
}
