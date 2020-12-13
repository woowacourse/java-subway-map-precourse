package subway.view.output.line;

import subway.type.ExceptionType;

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
}
