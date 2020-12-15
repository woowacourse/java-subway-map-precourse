package subway.domain;

import subway.util.ValidateUtil;

public class LineFactory {
    public static Line makeLine(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        ValidateUtil.makeLineValidate(name, uplineTerminalStation, downlineTerminalStation);
        return new Line(name, uplineTerminalStation, downlineTerminalStation);
    }
}
