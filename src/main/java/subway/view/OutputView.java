package subway.view;

import subway.view.resource.ErrorCode;
import subway.view.resource.Message;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String HEADER_SHARP = "## ";
    private static final String HEADER_INFO = "[INFO] ";
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String PARTITION = "---";
    private static final String LIST_TITLE = " 목록";

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

    public static void printMessage(Message message){
        printEnter();
        System.out.println(HEADER_SHARP + message);
    }

    public static void printResultMessage(Message message){
        printEnter();
        System.out.println(HEADER_INFO + message);
    }
    public static void printErrorMessage(ErrorCode message) {
        printEnter();
        System.out.println(ERROR_HEADER + message);
    }

    public static void printEnter(){
        System.out.println();
    }

}