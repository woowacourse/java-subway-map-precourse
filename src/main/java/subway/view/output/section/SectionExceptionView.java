package subway.view.output.section;

import subway.type.ExceptionType;

/**
 * SectionExceptionView.java : 지하철 구간 예외 처리 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SectionExceptionView {
    public static void printInvalidSectionStationNameInLineExistenceException() {
        System.out.println();
        System.out.println(
                ExceptionType.INVALID_SECTION_STATION_NAME_IN_LINE_ALREADY_EXISTENCE.getException());
    }

    public static void printInvalidSectionOrderReplacementLengthException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_SECTION_ORDER_REPLACEMENT_LENGTH.getException());
    }

    public static void printInvalidSectionOrderNumberException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_SECTION_ORDER_NUMBER.getException());
    }

    public static void printInvalidSectionOrderNumberByStationsException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_SECTION_ORDER_NUMBER_BY_STATIONS.getException());
    }

    public static void printInvalidNumberOfSectionStationsInLineException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_NUMBER_OF_SECTION_STATIONS_IN_LINE.getException());
    }
}
