package subway.common.print.error;

import subway.common.print.Prefix;

public class CommonErrorPrinter {
    private static final String SELECTION_INPUT_ERROR_MESSAGE
        = "\n" + Prefix.ERROR_PREFIX + "선택할 수 없는 기능입니다.";

    public static void printSelectionInputErrorMessage() {
        System.out.println(SELECTION_INPUT_ERROR_MESSAGE);
    }
}
