package subway.function.station.printer.error;

import subway.common.print.Prefix;

public class StationManagementErrorPrinter {
    private static final String NEW_STATION_NAME_LENGTH_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "역 이름은 2글자 이상이어야 합니다.";
    private static final String ALREADY_EXISTS_STATION_NAME_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "이미 등록되어있는 역 이름 입니다.";
    private static final String NOT_EXISTS_STATION_NAME_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "존재하지 않는 역 입니다.";
    private static final String REGISTERED_IN_LINE_STATION_NAME_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "노선에 등록된 역은 삭제할 수 없습니다.";

    public static void printNewStationNameLengthErrorMessage() {
        System.out.println(NEW_STATION_NAME_LENGTH_ERROR_MESSAGE);
    }

    public static void printAlreadyExistsStationNameErrorMessage() {
        System.out.println(ALREADY_EXISTS_STATION_NAME_ERROR_MESSAGE);
    }

    public static void printNotExistsStationNameErrorMessage() {
        System.out.println(NOT_EXISTS_STATION_NAME_ERROR_MESSAGE);
    }

    public static void printRegisteredInLineStationNameErrorMessage() {
        System.out.println(REGISTERED_IN_LINE_STATION_NAME_ERROR_MESSAGE);
    }
}
