package subway.domain;

public class LineFactory {
    private static final int NAME_MIN_LENGTH = 2;
    private static final String ERR_SHORT_NAME_MSG =
            String.format("[ERROR] 역의 이름은 %d글자 이상이어야 합니다.", NAME_MIN_LENGTH);

    public static Line makeLine(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ERR_SHORT_NAME_MSG);
        }
        return new Line(name, uplineTerminalStation, downlineTerminalStation);
    }
}
