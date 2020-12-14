package View.IoView;

import java.util.List;

public class OutputView {
    private static final String INFO_TAG = "[INFO] ";
    private static final String LINE_DELIMITER = "\n";

    public OutputView() {

    }

    public static void printManual(String manual) {
        System.out.println(manual);
    }

    public static void printAfterCommand(String message) {
        System.out.println(INFO_TAG + message);
    }

    public static void printAllInfo(List<String> Info, String prefixInfo) {
        String aggregatedInfo = INFO_TAG;
        aggregatedInfo += String.join(LINE_DELIMITER + INFO_TAG, Info);
        System.out.println(prefixInfo + LINE_DELIMITER + aggregatedInfo);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message + LINE_DELIMITER);
    }

}
