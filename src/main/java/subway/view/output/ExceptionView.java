package subway.view.output;

import subway.type.ExceptionType;

public class ExceptionView {
    public static void printInvalidFeatureChoiceException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_FEATURE_CHOICE.getException());
    }

    public static void printInvalidStationNameException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_STATION_NAME.getException());
    }

    public static void printInvalidStationNameLengthException() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_STATION_NAME_LENGTH.getException());
    }

    public static void printInvalidStationNameLastCharacter() {
        System.out.println();
        System.out.println(ExceptionType.INVALID_STATION_NAME_LAST_CHARACTER.getException());;
    }
}
