package subway.view.output.station;

import subway.type.ExceptionType;

public class StationExceptionView {
    public static void printInvalidStationNameException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_STATION_NAME.getException());
    }

    public static void printInvalidStationNameLengthException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_STATION_NAME_LENGTH.getException());
    }

    public static void printInvalidStationNameLastCharacterException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_STATION_NAME_LAST_CHARACTER.getException());;
    }
}
