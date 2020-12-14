package subway.utils;

import java.util.regex.Pattern;
import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.view.ErrorView;

public class NameValidator {

    public static void validateStation(String name) {
        validateMinimumLength(name, Station.MINIMUM_NAME_LENGTH);
        validateKoreanNumeric(name);
        validateEnding(name, Station.ENDING);
    }

    public static void validateLine(String name) {
        validateMinimumLength(name, Line.MINIMUM_NAME_LENGTH);
        validateKoreanNumeric(name);
        validateEnding(name, Line.ENDING);
    }

    private static void validateMinimumLength(String name, int minimumLength) {
        if (shorterThanMinimalLength(name, minimumLength)) {
            throw new IllegalArgumentException(ErrorView.NAME_SHORT);
        }
    }

    private static boolean shorterThanMinimalLength(String name, int minimumLength) {
        return name.length() < minimumLength;
    }

    private static void validateKoreanNumeric(String name) {
        String koreanPattern = "[가-힣0-9]*$";
        if (patternNotMatch(name, koreanPattern)) {
            throw new IllegalArgumentException(ErrorView.NAME_ELEMENT);
        }
    }

    private static boolean patternNotMatch(String name, String koreanPattern) {
        return !Pattern.matches(koreanPattern, name);
    }

    private static void validateEnding(String name, String ending) {
        if (notMatchingEnding(name, ending)) {
            endingErrorThrowDependingOn(ending);
        }
    }

    private static boolean notMatchingEnding(String name, String ending) {
        return !name.endsWith(ending);
    }

    private static void endingErrorThrowDependingOn(String ending) {
        if(ending.equals(Line.ENDING)) {
            throw new IllegalArgumentException(ErrorView.LINE_ENDING);
        }
        throw new IllegalArgumentException(ErrorView.STATION_ENDING);
    }
}
