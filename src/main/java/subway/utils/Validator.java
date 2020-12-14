package subway.utils;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final int NAME_MINIMUM_LENGTH = 2;

    public static boolean isValidNameLength(String name) {
        return name.length() >= NAME_MINIMUM_LENGTH;
    }

    public static boolean isNonDuplicateStationName(String name) {
        List<Station> stationList = StationRepository.stations();
        for (Station station : stationList) {
            String stationName = station.getName();
            if (stationName.equals(name)) return false;
        }
        return true;
    }

    public static boolean isValidMainMenuInput(String inputMsg) {
        List<String> validMainMsgList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "Q"));
        return validMainMsgList.contains(inputMsg);
    }
}
