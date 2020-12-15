package subway.domain;

import subway.exception.SubwayException;

import static subway.util.TextConstant.*;

public class LineFactory {
    public static Line makeLine(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new SubwayException(ERR_SHORT_NAME_MSG);
        }
        if (!name.endsWith(LINE)) {
            throw new SubwayException(ERR_WRONG_LINE_NAME_SUFFIX);
        }
        if (uplineTerminalStation.equals(downlineTerminalStation)) {
            throw new SubwayException(ERR_OTHER_TERMINAL_NOT_EQUALS);
        }
        return new Line(name, uplineTerminalStation, downlineTerminalStation);
    }
}
