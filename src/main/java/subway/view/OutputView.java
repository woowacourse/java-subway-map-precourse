package subway.view;

public class OutputView {
    private static final String INFO_MESSAGE = "[INFO] ";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void printInfo(String info) {
        System.out.println(INFO_MESSAGE + info);
    }

    public static void printError(String errorMessage) {
        System.out.println(ERROR_MESSAGE + errorMessage);
        System.out.println();
    }
}
