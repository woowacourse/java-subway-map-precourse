package subway.section;

import subway.line.domain.Line;
import subway.station.domain.Station;
import subway.station.exception.AlreadyExistStationException;

public class SectionValidator {
    private SectionValidator() {
    }

    public static void validateRegistration(Line line, Station station, int order) {
        validateDuplication(line, station);
    }

    private static void validateDuplication(Line line, Station station) {
        if (line.isExist(station.getName())) {
            throw new AlreadyExistStationException();
        }
    }
}
