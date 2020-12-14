package subway.view;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Line;

public class OutputView {

    public static final String NOTICE_HEADER = "## ";
    public static final String INFO_HEADER = "[INFO] ";
    public static final String ERROR_HEADER = "[ERROR] ";
    public static final String BORDER_LINE = "---";
    public static final String DOT = ". ";
    public static final String NEWLINE = "\n";
    public static final String CHOOSE_ACTION = "원하는 기능을 선택하세요.";
    public static final String SUBWAY_MAP_TITLE = "지하철 노선도";

    public static void printInfo(String info) {
        println(INFO_HEADER + info);
    }

    public static void printNotice(String notice) {
        println(NEWLINE + NOTICE_HEADER + notice);
    }

    public static void printError(Exception exception) {
        println(NEWLINE + ERROR_HEADER + exception.getMessage());
    }

    public static void printMenu(String title, String menuString) {
        printNotice(title + NEWLINE + menuString + NEWLINE + NEWLINE +
                NOTICE_HEADER + CHOOSE_ACTION);
    }

    public static void printSubwayMap(List<Line> lines) {
        printNotice(SUBWAY_MAP_TITLE + NEWLINE +
                lines.stream().map(OutputView::lineToString)
                        .collect(Collectors.joining(NEWLINE)));
    }

    private static String lineToString(Line line) {
        return INFO_HEADER + line.getName() + NEWLINE +
                INFO_HEADER + BORDER_LINE + NEWLINE +
                line.getSections().stream()
                        .map(station -> INFO_HEADER + station.getName() + NEWLINE)
                        .collect(Collectors.joining());
    }

    public static void println(String string) {
        System.out.println(string);
    }
}
