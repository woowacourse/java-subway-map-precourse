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

    public static String validateLineName(String lineName) {
        if (LineRepository.isPresentLine(lineName)) {
            throw new SubwayException(ERR_ALREADY_ADD_LINE_NAME_MSG);
        }
        if (lineName.length() < NAME_MIN_LENGTH) {
            throw new SubwayException(ERR_SHORT_NAME_MSG);
        }
        if (!lineName.endsWith(LINE)) {
            throw new SubwayException(ERR_WRONG_LINE_NAME_SUFFIX);
        }
        return lineName;
    }

    public static void makeLineValidate(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new SubwayException(ERR_SHORT_NAME_MSG);
        }
        if (!name.endsWith(LINE)) {
            throw new SubwayException(ERR_WRONG_LINE_NAME_SUFFIX);
        }
        if (uplineTerminalStation.equals(downlineTerminalStation)) {
            throw new SubwayException(ERR_OTHER_TERMINAL_NOT_EQUALS);
        }
    }

    public static void makeStationValidate(String name) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new SubwayException(ERR_STATION_SHORT_NAME_MSG);
        }
        if (!name.endsWith(STATION)) {
            throw new SubwayException(ERR_WRONG_STATION_NAME_SUFFIX);
        }
    }
}
