package subway.view.output.station;

import subway.type.ExceptionType;

/**
 * StationExceptionView.java : 지하철 역 예외 처리 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
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

    public static void printInvalidStationNameInTransitMapException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_STATION_NAME_IN_TRANSIT_MAP.getException());
    }

    public static void printInvalidStationNameExistenceException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_STATION_NAME_EXISTENCE.getException());
    }
}
