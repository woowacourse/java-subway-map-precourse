package subway.view.outputview;

import static subway.view.outputview.OutputView.*;

public class ErrorOutputView {
    private static String ERROR_SYMBOL = "\n[ERROR] ";
    private static String INVALID_MENU = "선택할 수 없는 기능입니다.\n";
    private static String INVALID_STATION_NAME = "역 이름이 잘못되었습니다.\n";
    private static String INVALID_LINE_NAME = "노선 이름이 잘못되었습니다.\n";
    private static String EXIST_STATION_NAME = "이미 등록된 역 이름입니다.\n";
    private static String EXIST_LINE_NAME = "이미 등록된 노선 이름입니다.\n";
    private static String NOT_EXIST_STATION = "해당 역이 존재하지 않습니다.\n";
    private static String NOT_EXIST_LINE = "해당 노선이 존재하지 않습니다.\n";
    private static String STATION_IN_LINE = "해당 역이 노선에 존재합니다.\n";
    private static String EQUAL_FIRST_LAST_STATION = "상행/하행 종점역 이름이 같습니다.\n";
    private static String INVALID_ORDER_NUMBER = "순서는 숫자가 입력될 수 없습니다.\n";
    private static String INVALID_ORDER_RANGE = "구간의 범위를 초과하였습니다.\n";
    private static String INVALID_LINE_SIZE = "노선의 역이 2개 이하로, 역을 제거할 수 없습니다.\n";

    public static void invalidMenu() {
        stringBuilder.append(ERROR_SYMBOL);
        stringBuilder.append(INVALID_MENU);
        print();
    }

    public static void existStation() {
        stringBuilder.append(ERROR_SYMBOL);
        stringBuilder.append(EXIST_STATION_NAME);
        print();
    }

    public static void invalidStationName() {
        stringBuilder.append(ERROR_SYMBOL);
        stringBuilder.append(INVALID_STATION_NAME);
        print();
    }

    public static void notExistStation() {
        stringBuilder.append(ERROR_SYMBOL);
        stringBuilder.append(NOT_EXIST_STATION);
        print();
    }

    public static void notStationInLine() {
        stringBuilder.append(ERROR_SYMBOL);
        stringBuilder.append(STATION_IN_LINE);
        print();
    }
}
