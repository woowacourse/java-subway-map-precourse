package subway.utils;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.view.OutputView;

public class LineValidator {

    public static void validateName(String name) {
        validateLength(name);
    }

    public static void validateRemove(Line line, Station station) {
        validateMinimumAmount(line);
        validateExisting(line, station);
    }

    public static void validateExisting(Line line, Station station) {
        if (!isDuplicate(line, station)) {
            throw new IllegalArgumentException(OutputView.ERROR_NO_STATION);
        }
    }

    public static void validateNoDuplicate(Line line, Station station) {
        if(isDuplicate(line, station)) {
            throw new IllegalArgumentException(OutputView.ERROR_DUPLICATE_STATION);
        }
    }

    public static void validateIndex(Line line, int index) {
        if(lowerThanMinimumIndex(index) || higherThanMaximumIndex(line, index)) {
            throw new IllegalArgumentException(OutputView.ERROR_INDEX);
        }
    }

    private static void validateLength(String name) {
        if (shorterThanMinimalLength(name)) {
            throw new IllegalArgumentException(OutputView.ERROR_NAME_SHORT);
        }
    }

    private static boolean shorterThanMinimalLength(String name) {
        return name.length() < Line.MINIMUM_NAME_LENGTH;
    }

    private static boolean isDuplicate(Line line, Station station) {
        return line.hasStation(station.getName());
    }

    private static void validateMinimumAmount(Line line) {
        if (isLessThanEqualToMinimumAmount(line.getStations().size())) {
            throw new IllegalArgumentException(OutputView.ERROR_SIZE_SMALL);
        }
    }

    private static boolean isLessThanEqualToMinimumAmount(int size) {
        return size <= Line.MINIMUM_STATION_AMOUNT;
    }

    private static boolean lowerThanMinimumIndex(int index) {
        return index < Line.MINIMUM_INDEX;
    }

    private static boolean higherThanMaximumIndex(Line line, int index) {
        return index > line.getStations().size();
    }
}
