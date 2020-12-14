package subway.utils;

import subway.domain.exception.InvalidLineNameException;
import subway.domain.exception.InvalidOrderException;
import subway.domain.exception.InvalidStationNameException;

import java.util.regex.Pattern;

public class InputValidator {
    private static String STATION_NAME_PATTERN = "[가-힣]+역";
    private static String LINE_NAME_PATTERN = "[0-9가-힣]+선";
    private static String SECTION_ORDER_PATTERN = "[0-9]*";

    public static void validStationName(String input) {
        if (!Pattern.matches(STATION_NAME_PATTERN, input)) {
            throw new InvalidStationNameException();
        }
    }

    public static void validLineName(String input) {
        if (!Pattern.matches(LINE_NAME_PATTERN, input)) {
            throw new InvalidLineNameException();
        }
    }

    public static void validSectionOrder(String input) {
        if (!Pattern.matches(SECTION_ORDER_PATTERN, input)) {
            throw new InvalidOrderException();
        }
    }
}
