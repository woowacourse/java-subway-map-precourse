package subway.function.line;

import subway.commonprint.Prefix;

public class LinePrinter {
    private static final String NEW_LINE_NAME_INPUT_MESSAGE
        = "\n## 등록할 노선 이름을 입력하세요.";
    private static final String NEW_LINE_UP_END_STATION_NAME_INPUT_MESSAGE
        = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String NEW_LINE_DOWN_END_STATION_NAME_INPUT_MESSAGE
        = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String NEW_LINE_REGISTRATION_SUCCESS_MESSAGE
        = "\n" + Prefix.INFO_PREFIX + "지하철 노선이 등록되었습니다.";
    private static final String LINE_LIST_TITLE
        = "\n" + "## 노선 목록";
    private static final String LINE_NAME_TO_DELETE_INPUT_MESSAGE
        = "\n## 삭제할 노선 이름을 입력하세요.";
    private static final String LINE_DELETE_SUCCESS_MESSAGE
        = "\n" + Prefix.INFO_PREFIX + "지하철 노선이 삭제되었습니다.";

    public static void printNewLineNameInputMessage() {
        System.out.println(NEW_LINE_NAME_INPUT_MESSAGE);
    }

    public static void printLineUpEndStationNameInputMessage() {
        System.out.println(NEW_LINE_UP_END_STATION_NAME_INPUT_MESSAGE);
    }

    public static void printLineDownEndStationNameInputMessage() {
        System.out.println(NEW_LINE_DOWN_END_STATION_NAME_INPUT_MESSAGE);
    }

    public static void printNewLineRegistrationSuccessMessage() {
        System.out.println(NEW_LINE_REGISTRATION_SUCCESS_MESSAGE);
    }

    public static void printLineListTitle() {
        System.out.println(LINE_LIST_TITLE);
    }

    public static void printLineNameToDeleteInputMessage() {
        System.out.println(LINE_NAME_TO_DELETE_INPUT_MESSAGE);
    }

    public static void printLineDeleteSuccessMessage() {
        System.out.println(LINE_DELETE_SUCCESS_MESSAGE);
    }
}
