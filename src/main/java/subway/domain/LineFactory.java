package subway.domain;

import static subway.util.TextConstant.*;

public class LineFactory {
    public static Line makeLine(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERR_SHORT_NAME_MSG);
        }
        if (!name.endsWith(LINE)) {
            throw new IllegalArgumentException(ERR_WRONG_LINE_NAME_SUFFIX);
        }
        if (uplineTerminalStation.equals(downlineTerminalStation)) {
            throw new IllegalArgumentException(ERR_OTHER_TERMINAL_NOT_EQUALS);
        }
        return new Line(name, uplineTerminalStation, downlineTerminalStation);
    }
}
