package subway.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String HEADER_SHARP = "## ";
    private static final String HEADER_INFO = "[INFO] ";
    private static final String PARTITION = "---";
    private static final String LIST_TITLE = " 목록";
    private static final String INPUT_FUNCTION_INDEX_MESSAGE = "원하는 기능을 선택하세요.";
    private static final String INPUT_REGISTER_VALUE_MESSAGE = "등록할 %s 이름을 입력하세요.";
    private static final String REGISTER_SUCCESS_MESSAGE = "지하철 %s이 등록되었습니다.";
    private static final String INPUT_DELETE_VALUE_MESSAGE = "삭제할 %s 이름을 입력하세요.";
    private static final String DELETE_SUCCESS_MESSAGE = "지하철 %s이 삭제되었습니다.";
    private static final String INPUT_FIRST_STATION_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_LAST_STATION_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_VALUE_MESSAGE = "%s 이름을 입력하세요.";
    private static final String INPUT_INDEX_MESSAGE = "순서를 입력하세요.";
    private static final String INPUT_VALUE_OF_DELETE_SECTION = "삭제할 구간의 %s을 입력하세요.";

    public static void printTitle(String functionHeader) {
        System.out.println();
        System.out.println(HEADER_SHARP + functionHeader);
    }

    public static void printListTitle(String screenName) {
        System.out.println();
        System.out.println(HEADER_SHARP + screenName + LIST_TITLE);
    }

    public static void printFunctionList(List<String> functionList) {
        for (String function : functionList) {
            System.out.println(function);
        }
        System.out.println();
    }

    public static void printInputFunctionIndex() {
        System.out.println(HEADER_SHARP + INPUT_FUNCTION_INDEX_MESSAGE);
    }

    public static void printInputRegisterValue(String screenName) {
        System.out.println();
        System.out.printf(HEADER_SHARP + INPUT_REGISTER_VALUE_MESSAGE + "\n", screenName);
    }

    public static void printRegisterFirstStation() {
        System.out.println();
        System.out.println(HEADER_SHARP + INPUT_FIRST_STATION_MESSAGE);
    }

    public static void printRegisterLastStation() {
        System.out.println();
        System.out.println(HEADER_SHARP + INPUT_LAST_STATION_MESSAGE);
    }

    public static void printRegisterSuccess(String screenName) {
        System.out.println();
        System.out.printf(HEADER_INFO + REGISTER_SUCCESS_MESSAGE + "\n", screenName);
    }

    public static void printInputDeleteValue(String screenNam) {
        System.out.println();
        System.out.printf(HEADER_SHARP + INPUT_DELETE_VALUE_MESSAGE + "\n", screenNam);
    }

    public static void printDeleteSuccess(String screenNam) {
        System.out.println();
        System.out.printf(HEADER_INFO + DELETE_SUCCESS_MESSAGE + "\n", screenNam);
    }

    public static void printInputValue(String screenName) {
        System.out.println();
        System.out.printf(HEADER_SHARP + INPUT_VALUE_MESSAGE + "\n", screenName);
    }

    public static void printInputIndex() {
        System.out.println();
        System.out.println(HEADER_SHARP + INPUT_INDEX_MESSAGE);
    }

    public static void printInputValueOfDeleteSection(String screenName) {
        System.out.println();
        System.out.printf(HEADER_SHARP + INPUT_VALUE_OF_DELETE_SECTION + "\n", screenName);
    }

    public static void printSubwayMap(Map<String, List<String>> subwayMap) {
        for (String line : subwayMap.keySet()) {
            System.out.println(HEADER_INFO + line);
            System.out.println(HEADER_INFO + PARTITION);
            for (String station : subwayMap.get(line)) {
                System.out.println(HEADER_INFO + station);
            }
            System.out.println();
        }
    }

}