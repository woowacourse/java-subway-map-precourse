package subway.view.outputview;

import java.util.List;

public class MainOutputView {
    public static final String EXIT_PROGRAM = "프로그램이 종료되었습니다.";
    public static final String SUBWAY_LIST = "## 지하철 노선도";
    public static final String INFO = "[INFO] ";
    public static final String ERROR = "[ERROR] ";
    public static final String SPLIT_LINE = "---";

    public void printProgramExit() {
        System.out.println(EXIT_PROGRAM);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR + errorMessage);
        System.out.println();
    }

    public void printSubwayList() {
        System.out.println(SUBWAY_LIST);
    }

    public void printStationsInLine(String lineName, List<String> stationNames) {
        System.out.println(INFO + lineName);
        System.out.println(INFO + SPLIT_LINE);
        stationNames.forEach(stationName -> System.out.println(INFO + stationName));
        System.out.println();
    }
}