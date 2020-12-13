package subway.common;

public class InfoMessage {
    private static final String INFO_PREFIX = "[INFO] ";

    private InfoMessage() {
    }

    public static void print(String message) {
        System.out.println(INFO_PREFIX + message);
    }

}
