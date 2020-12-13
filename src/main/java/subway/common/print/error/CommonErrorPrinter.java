package subway.common.print.error;

import subway.common.print.Prefix;

public class CommonErrorPrinter {
    private static final String SELECTION_INPUT_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "선택할 수 없는 기능입니다.";
    private static final String NOT_EXISTS_STATION_NAME_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "존재하지 않는 역 입니다.";
    private static final String NOT_EXISTS_LINE_NAME_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "존재하지 않는 노선 입니다.";

    public static void printSelectionInputErrorMessage() {
        System.out.println(SELECTION_INPUT_ERROR_MESSAGE);
    }

    public static void printNotExistsStationNameErrorMessage() {
        System.out.println(NOT_EXISTS_STATION_NAME_ERROR_MESSAGE);
    }

    public static void printNotExistsLineNameErrorMessage() {
        System.out.println(NOT_EXISTS_LINE_NAME_ERROR_MESSAGE);
    }
}
