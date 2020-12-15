package subway.utils;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.view.ErrorMessage;

public class LineValidator {

    public static void validateStationRemove(Line line, Station station) {
        validateMinimumAmount(line);
        validateExisting(line, station);
    }

    public static void validateExisting(Line line, Station station) {
        if (!isDuplicate(line, station)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_NO_CONNECTION);
        }
    }

    public static void validateNoDuplicate(Line line, Station station) {
        if (isDuplicate(line, station)) {
            throw new IllegalArgumentException(ErrorMessage.LINE_STATION_DUPLICATE);
        }
    }

    public static void validateIndex(Line line, int index) {
        if (lowerThanMinimumIndex(index) || higherThanMaximumIndex(line, index)) {
            throw new IllegalArgumentException(ErrorMessage.INDEX_INVALID);
        }
    }

    private static boolean isDuplicate(Line line, Station station) {
        return line.hasStation(station.getName());
    }

    private static void validateMinimumAmount(Line line) {
        if (isLessThanEqualToMinimumAmount(line.getStations().size())) {
            throw new IllegalArgumentException(ErrorMessage.LINE_MINIMAL_STATIONS);
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
