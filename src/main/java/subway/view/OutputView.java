package subway.view;

import java.io.PrintStream;

public class OutputView {

    public static final String SUCCESS_PREFIX = "[INFO]";

    public static final String STATION_SAVED = "지하철 역이 등록되었습니다.";

    public void printStationSaved() {
        printSuccessMessage(STATION_SAVED);
    }

    private PrintStream printSuccessMessage(String message) {
        return System.out.printf("%s %s", SUCCESS_PREFIX, message);
    }
}
