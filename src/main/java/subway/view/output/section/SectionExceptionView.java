package subway.view.output.section;

import subway.type.ExceptionType;

public class SectionExceptionView {
    public static void printInvalidSectionExistingStationNameInLine() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_SECTION_EXISTING_STATION_NAME_IN_LINE.getException());
    }
}
