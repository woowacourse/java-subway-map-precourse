package subway.commonprint;

public class CommonPrinter {
    private static final String USER_FUNCTION_SELECTION_MESSAGE
        = "\n## 원하는 기능을 선택하세요.";

    public static void printUserFunctionSelectionMessage() {
        System.out.println(USER_FUNCTION_SELECTION_MESSAGE);
    }
}
