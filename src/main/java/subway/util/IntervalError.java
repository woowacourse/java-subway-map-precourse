package subway.util;

import subway.domain.Station;

import java.util.List;

public class IntervalError {

    public static boolean checkValidStation(String name, List<Station> stationList) {
        for (Station station : stationList) {
            if (station.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}
