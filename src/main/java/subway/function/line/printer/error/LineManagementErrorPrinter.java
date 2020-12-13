package subway.function.line.printer.error;

import subway.common.print.Prefix;

public class LineManagementErrorPrinter {
    private static final String NEW_LINE_NAME_LESS_THAN_MIN_LENGTH_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "노선 이름은 2글자 이상이어야 합니다.";
    private static final String NEW_LINE_NAME_ALREADY_EXISTS_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "이미 등록되어있는 노선 이름입니다.";
    private static final String UP_AND_DOWN_END_STATION_EQUAL_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "상행 종점역과 하행 종점역은 달라야 합니다.";

    public static void printNewLineNameLessThanMinLengthErrorMessage() {
        System.out.println(NEW_LINE_NAME_LESS_THAN_MIN_LENGTH_ERROR_MESSAGE);
    }

    public static void printNewLineNameAlreadyExistsErrorMessage() {
        System.out.println(NEW_LINE_NAME_ALREADY_EXISTS_ERROR_MESSAGE);
    }

    public static void printUpAndDownEndStationEqualErrorMessage() {
        System.out.println(UP_AND_DOWN_END_STATION_EQUAL_ERROR_MESSAGE);
    }
}
