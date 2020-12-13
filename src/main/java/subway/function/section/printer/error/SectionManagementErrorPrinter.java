package subway.function.section.printer.error;

import subway.common.print.Prefix;

public class SectionManagementErrorPrinter {
    private static final String STATION_ALREADY_EXISTS_IN_LINE_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "선택한 노선에 선택한 역이 이미 존재합니다.";
    private static final String ORDER_NOT_NUMBER_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "숫자만 입력할 수 있습니다.";
    private static final String ORDER_RANGE_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "범위에서 벗어난 순서 입니다.";
    private static final String NO_MORE_THAN_TWO_STATIONS_EXISTS_IN_LINE_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "선택한 노선에 포함된 역이 두개 이하이기 때문에, 구간 삭제를 할 수 없습니다.";
    private static final String NOT_EXISTS_STATION_IN_LINE_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "선택한 역은 선택한 노선에 존재하지 않습니다.";

    public static void printStationAlreadyExistsInLineErrorMessage() {
        System.out.println(STATION_ALREADY_EXISTS_IN_LINE_ERROR_MESSAGE);
    }

    public static void printOrderNotNumberErrorMessage() {
        System.out.println(ORDER_NOT_NUMBER_ERROR_MESSAGE);
    }

    public static void printOrderRangeErrorMessage() {
        System.out.println(ORDER_RANGE_ERROR_MESSAGE);
    }

    public static void printNoMoreThanTwoStationsExistsInLineErrorMessage() {
        System.out.println(NO_MORE_THAN_TWO_STATIONS_EXISTS_IN_LINE_ERROR_MESSAGE);
    }

    public static void printNotExistsStationInLineErrorMessage() {
        System.out.println(NOT_EXISTS_STATION_IN_LINE_ERROR_MESSAGE);
    }
}
