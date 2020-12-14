package subway.utils;

import subway.domain.station.Station;
import subway.view.OutputView;

public class StationValidator {

    public static void validateName(String name) {
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (shorterThanMinimalLength(name)) {
            throw new IllegalArgumentException(OutputView.ERROR_NAME_SHORT);
        }
    }

    private static boolean shorterThanMinimalLength(String name) {
        return name.length() < Station.MINIMUM_NAME_LENGTH;
    }

    private static void validateEnding(String name) {
        if (notMatchingEnding(name)) {
            throw new IllegalArgumentException(OutputView.ERROR_STATION_ENDING);
        }
    }

}
