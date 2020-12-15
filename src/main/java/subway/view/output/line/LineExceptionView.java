package subway.view.output.line;

import subway.type.ExceptionType;

/**
 * LineExceptionView.java : 지하철 노선 예외 처리 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class LineExceptionView {
    public static void printInvalidLineNameException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_LINE_NAME.getException());
    }

    public static void printInvalidLineNameLengthException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_LINE_NAME_LENGTH.getException());
    }

    public static void printInvalidLineNameLastCharacterException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_LINE_NAME_LAST_CHARACTER.getException());
    }

    public static void printInvalidLineStationNamesExistenceException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_LINE_STATION_NAMES_EXISTENCE.getException());
    }

    public static void printInvalidLineSameStationNamesException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_LINE_SAME_STATION_NAMES.getException());
    }

    public static void printInvalidLineNameExistenceException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_LINE_NAME_EXISTENCE.getException());
    }
}
