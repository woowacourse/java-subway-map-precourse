package subway.view;

import java.util.List;

public class OutputView {
    private static final String HEADER_SHARP = "## ";
    private static final String INPUT_FUNCTION_INDEX_MESSAGE = "원하는 기능을 선택하세요.";

    public static void printFunctionTitle(String functionHeader) {
        System.out.println(HEADER_SHARP + functionHeader);
    }

    public static void printFunctionList(List<String> functionList) {
        for (String function : functionList) {
            System.out.println(function);
        }
        System.out.println();
    }

    public static void printInputFunctionIndex() {
        System.out.println(HEADER_SHARP + INPUT_FUNCTION_INDEX_MESSAGE);
    }
}
