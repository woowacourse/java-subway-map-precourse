package subway.line.validation;

import subway.common.Prefix;

public class NotAllowSameStartEnd {
    private static final String NO_ALLOW_SAME_START_END = Prefix.ERROR.getPrefix() + "상행 종점과 하행 종점은 같을 수 없습니다.";

    public static void validation(String startStationName, String endStationName) {
        if (startStationName.equals(endStationName)) {
            throw new IllegalArgumentException(NO_ALLOW_SAME_START_END);
        }
    }
}
