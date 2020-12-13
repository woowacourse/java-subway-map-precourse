package subway.view;

public class ErrorView {
    protected static final String ERROR = "[ERROR] ";
    private static final String ERROR_WRONG_OPTION = "선택할 수 없는 기능입니다.";

    public static void printOptionError() {
        System.out.println(ERROR + ERROR_WRONG_OPTION);
    }
}
