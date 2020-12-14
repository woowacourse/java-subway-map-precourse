package subway.util;

import subway.domain.Station;

import java.util.List;

public class StationError {

    public static boolean checkDuplicateName(String name, List<Station> stations) {
        for(Station station : stations) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
