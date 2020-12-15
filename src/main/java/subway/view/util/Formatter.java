package subway.view.util;

public class Formatter {
    private static final String INFO_PREFIX = "[INFO]";
    private static final String ERROR_PREFIX = "\n[ERROR]";
    private static final String DELIMINATOR = " ";

    public static String Info(String message) {
        return String.join(DELIMINATOR, INFO_PREFIX, message);
    }

    public static String Error(String message) {
        return String.join(DELIMINATOR, ERROR_PREFIX, message+"\n");
    }
}
