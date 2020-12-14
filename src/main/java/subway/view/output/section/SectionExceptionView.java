package subway.view.output.section;

import subway.type.ExceptionType;

public class SectionExceptionView {
    public static void printInvalidSectionExistingStationNameInLine() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_SECTION_EXISTING_STATION_NAME_IN_LINE.getException());
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
}
