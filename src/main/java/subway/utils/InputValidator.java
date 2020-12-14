package subway.utils;

import subway.domain.exception.InvalidStationNameException;

import java.util.regex.Pattern;

public class InputValidator {
    private static String STATION_NAME_PATTERN = "[가-힣]+역";

    public static void validStationName(String input) {
        if (!Pattern.matches(STATION_NAME_PATTERN, input)) {
            throw new InvalidStationNameException();
        };
    }
}
