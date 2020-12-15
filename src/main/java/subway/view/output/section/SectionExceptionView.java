package subway.view.output.section;

import subway.type.ExceptionType;

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
