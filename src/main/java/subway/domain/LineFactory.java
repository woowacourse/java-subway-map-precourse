package subway.domain;

public class LineFactory {
    private static final int NAME_MIN_LENGTH = 2;
    private static final String ERR_SHORT_NAME_MSG =
            String.format("[ERROR] 노선의 이름은 %d글자 이상이어야 합니다.", NAME_MIN_LENGTH);
    public static final String ERR_OTHER_TERMINAL_NOT_EQUALS = "[ERROR] 상행선 종점역과 하행선 종점역은 같을 수 없습니다.";
    private static final String ERR_WRONG_LINE_NAME_SUFFIX = "[ERROR] 노선의 이름은 ~선 형태여야 합니다.";
    public static final String LINE = "선";
    public static Line makeLine(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERR_SHORT_NAME_MSG);
        }
        if (!name.endsWith(LINE)) {
            throw new IllegalArgumentException(ERR_WRONG_LINE_NAME_SUFFIX);
        }
        if (uplineTerminalStation.equals(downlineTerminalStation)){
            throw new IllegalArgumentException(ERR_OTHER_TERMINAL_NOT_EQUALS);
        }
        return new Line(name, uplineTerminalStation, downlineTerminalStation);
    }
}
