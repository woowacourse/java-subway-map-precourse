package subway.util;

import subway.domain.Station;

import java.util.List;

public class StationValidator {

    private static final int SIZE = 2;

    public static boolean checkDuplicateName(String name, List<Station> stations) {
        for(Station station : stations) {
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
