package subway.view.outputview;

import java.util.List;

public class LineManagementOutputView {
    public static final String LINE_LIST = "## 노선 목록";
    public static final String INFO = "[INFO] ";
    public static final String ERROR = "[ERROR] ";

    public void printLines(List<String> lines) {
        System.out.println(LINE_LIST);
        lines.forEach(line -> System.out.println(INFO + line));
        System.out.println();
    }

    public void printActionComplete(String completeMessage) {
        System.out.println(INFO + completeMessage);
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR + errorMessage);
        System.out.println();
    }
}
