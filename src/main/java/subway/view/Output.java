package subway.view;

import java.util.List;

public class Output {

    private static final String INFO_MESSAGE = "[INFO] %s\n";
    public static final String STATION_LIST = "## 역 목록";
    public static final String LINE_LIST = "## 역 노선";

    private Output() {
    }

    public static void print(String message) {
        printNewLine();
        System.out.println(message);
    }

    public static void printByList(List<?> list) {
        list.forEach(obj -> System.out.printf(INFO_MESSAGE, obj));
    }

    public static void printNewLine() {
        System.out.println();
    }
}
