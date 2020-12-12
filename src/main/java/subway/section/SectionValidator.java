package subway.section;

import subway.line.domain.Line;
import subway.section.exception.InvalidOrderException;
import subway.section.exception.NotRegisteredStationException;
import subway.section.exception.TooShortToRemoveException;
import subway.station.domain.Station;
import subway.station.exception.AlreadyExistStationException;

public class SectionValidator {
    private SectionValidator() {
    }

    public static void validateRegistration(Line line, Station station, int order) {
        validateDuplication(line, station);
        validateOrder(line, order);
    }

    private static void validateDuplication(Line line, Station station) {
        if (line.isExist(station.getName())) {
            throw new AlreadyExistStationException();
        }
    }

    private static void validateOrder(Line line, int order) {
        if (!line.isValidOrder(order)) {
            throw new InvalidOrderException();
        }
    }

    public static void validateRemoval(Line line, Station station) {
        validateExistence(line, station);
        validateLineSize(line);
    }

    private static void validateExistence(Line line, Station station) {
        if (!line.isExist(station.getName())) {
            throw new NotRegisteredStationException();
        }
    }

    private static void validateLineSize(Line line) {
        if (!line.isEnoughSize()) {
            throw new TooShortToRemoveException();
        }
    }
}
