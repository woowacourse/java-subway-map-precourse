package subway.view;

public class OutputView {
    public static final String ERROR_LABEL = "[ERROR] ";
    public static final String ERROR_NOT_NUMERIC = ERROR_LABEL + "선택할 수 없는 기능입니다.";
    public static final String ERROR_OUT_OF_RANGE = ERROR_LABEL + "선택할 수 없는 기능입니다.";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

}
