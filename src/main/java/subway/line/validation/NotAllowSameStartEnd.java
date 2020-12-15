package subway.line.validation;

public class NotAllowSameStartEnd {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NO_ALLOW_SAME_START_END = ERROR_PREFIX + "상행 종점과 하행 종점은 같을 수 없습니다.";

    public static void validation(String startStationName, String endStationName) {
        if (startStationName.equals(endStationName)) {
            throw new IllegalArgumentException(NO_ALLOW_SAME_START_END);
        }
    }
}
