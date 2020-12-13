package subway.view;

public class ErrorView {
    protected static final String ERROR = "[ERROR] ";
    private static final String ERROR_WRONG_OPTION = "선택할 수 없는 기능입니다.";
    private static final String ERROR_WRONG_LENGTH = "2자 미만은 입력할 수 없습니다.";
    private static final String ERROR_INPUT_IS_SPACE = "공백으로만 이루어진 입력은 허용하지 않습니다.";

    protected static void printError(String errorMessage) {
        System.out.println(ERROR + errorMessage);
        System.out.println();
    }

    public static void printOptionError() {
        printError(ERROR_WRONG_OPTION);
    }

    public static void printLengthError() {
        printError(ERROR_WRONG_LENGTH);
    }

    public static void printInputIsSpaceError() {
        printError(ERROR_INPUT_IS_SPACE);
    }
}
