package subway.util;

import subway.domain.LineRepository;
import subway.domain.Station;

import java.util.List;

public class SectionValidator {
    private static final int SIZE = 2;

    public static boolean checkValidStation(String name, List<Station> stationList) {
        for (Station station : stationList) {
            if (station.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkValidDelete(String name, List<Station> stationList) {
        if (stationList.size() <= SIZE) {
            return false;
        }
        return true;
    }

    public static boolean checkValidIndex(String index, String lineName) {
        int lineSize = LineRepository.findLineByName(lineName).size();
        if (Integer.parseInt(index) > 0 && Integer.parseInt(index) <= lineSize) {
            return true;
        }
        return false;
    }

}
