package view.io;

import java.util.List;

public class OutputView {

    private static final String INFO_TAG = "[INFO] ";
    private static final String LINE_DELIMITER = "\n";
    private static final int START = 0;
    //private static final int
    public OutputView() {

    }

    public static void printManual(String manual) {
        System.out.println(manual);
    }

    public static void printAfterCommand(String message) {
        System.out.println(INFO_TAG + message + LINE_DELIMITER);
    }

    public static void printAllInfo(List<String> Info, String prefixInfo) {
        String aggregatedInfo = INFO_TAG;
        aggregatedInfo += String.join(LINE_DELIMITER + INFO_TAG, Info);
        System.out.println(prefixInfo + LINE_DELIMITER + aggregatedInfo + LINE_DELIMITER);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message + LINE_DELIMITER);
    }

}
