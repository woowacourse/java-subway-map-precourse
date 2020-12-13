package subway.view;

public class OutputView {
    protected static final String OUTPUT = "## ";
    private static final String GIVE_OPTION = "원하는 기능을 선택하세요.";

    public static void printOutput(String outputMessage) {
        System.out.println(OUTPUT + outputMessage);
    }

    public static void printOptionInstruction() {
        printOutput(GIVE_OPTION);
    }

    public static void printNewLine() {
        System.out.println();
    }
}