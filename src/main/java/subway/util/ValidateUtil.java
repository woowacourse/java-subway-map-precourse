package subway.util;

import static subway.util.TextConstant.*;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.exception.SubwayException;

public class ValidateUtil {
    public static boolean canDeleteStation(Station station) {
        if (LineRepository.lines().containsStation(station)) {
            throw new SubwayException(ERR_STATION_CASCADE_LINE_MSG);
        }
        return true;
    }
    public static int parseInt(String sequence) {
        try {
            return Integer.parseInt(sequence);
        } catch (NumberFormatException e) {
            throw new SubwayException(ERR_MUST_INPUT_INT_MSG);
        }
    }
}
