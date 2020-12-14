package subway.domain.validator;

import subway.domain.Station;
import subway.domain.exception.*;

public class LineValidator {
    private LineValidator() {
    }

    public static void checkNotExistingLine(boolean isContain) {
        if (isContain) {
            throw new AlreadyExistingLineException();
        }
    }

    public static void checkEndStationsAreDifferent(Station start, Station end) {
        if (start.equals(end)) {
            throw new DuplicatedEndStationsException();
        }
    }

    public static void checkIsNotOnLine(boolean isContain) {
        if (isContain) {
            throw new DuplicatedStationOnLineException();
        }
    }

    public static void checkIsOnLine(boolean isContain) {
        if (!isContain) {
            throw new NonExistingStationOnLine();
        }
    }

    public static void checkIsValidOrder(int index, int maximum) {
        if (index > maximum) {
            throw new InvalidOrderException();
        }
    }
}
