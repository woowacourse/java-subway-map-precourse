package subway.view;

import subway.domain.Line;
import subway.domain.MainFunctions;
import subway.domain.DetailFunctions;
import subway.domain.Station;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String INFO_HEAD = "[INFO] ";
    public static final String NOTICE_HEAD = "## ";
    private static final String ERROR_HEAD = "[ERROR] ";
    private static final String DELIMITER_LINE_STATION = "---";
    private static final String DELIMITER_NUMBER_FUNCTION = ". ";
    private static final String SPACE = " ";
    private static final String NOTICE_MANAGE = " 관리";
    private static final String NOTICE_PRINTING = " 출력";

    public static void printMain() {
        System.out.println();
        System.out.println(NOTICE_HEAD +"메인 화면");
        System.out.println(MainFunctions.STATION.getFunctionNumber() + DELIMITER_NUMBER_FUNCTION + MainFunctions.STATION.getFunctionName() + NOTICE_MANAGE);
        System.out.println(MainFunctions.LINE.getFunctionNumber() + DELIMITER_NUMBER_FUNCTION + MainFunctions.LINE.getFunctionName() + NOTICE_MANAGE);
        System.out.println(MainFunctions.WAY.getFunctionNumber() + DELIMITER_NUMBER_FUNCTION + MainFunctions.WAY.getFunctionName() + NOTICE_MANAGE);
        System.out.println(MainFunctions.SUBWAY.getFunctionNumber() + DELIMITER_NUMBER_FUNCTION + MainFunctions.SUBWAY.getFunctionName() + NOTICE_PRINTING);
        System.out.println(MainFunctions.FINISH.getFunctionNumber() + DELIMITER_NUMBER_FUNCTION + MainFunctions.FINISH.getFunctionName());
        System.out.println();
    }

    public static void printDetailFunction(MainFunctions mainFunction) {
        System.out.println(NOTICE_HEAD + mainFunction.getFunctionName() + " 관리 화면");
        System.out.println(DetailFunctions.ENROLL.getFunctionNumber() + DELIMITER_NUMBER_FUNCTION + mainFunction.getFunctionName() + SPACE + DetailFunctions.ENROLL.getFunctionName());
        System.out.println(DetailFunctions.REMOVE.getFunctionNumber() + DELIMITER_NUMBER_FUNCTION + mainFunction.getFunctionName() + SPACE + DetailFunctions.REMOVE.getFunctionName());
        if (!mainFunction.equals(MainFunctions.WAY)) {
            System.out.println(DetailFunctions.RESEARCH.getFunctionNumber() + DELIMITER_NUMBER_FUNCTION + mainFunction.getFunctionName() + SPACE + DetailFunctions.RESEARCH.getFunctionName());
        }
        System.out.println(DetailFunctions.BACK.getFunctionNumber() + DELIMITER_NUMBER_FUNCTION + DetailFunctions.BACK.getFunctionName());
        System.out.println();
    }

    public static void printOneLine() {
        System.out.println();
    }

    public static void printSubway(Map<Line, List<Station>> subway) {
        System.out.println(NOTICE_HEAD + MainFunctions.SUBWAY.getFunctionName());
        for (Line line : subway.keySet()) {
            System.out.println(INFO_HEAD + line.getName());
            System.out.println(INFO_HEAD + DELIMITER_LINE_STATION);
            subway.get(line).forEach(station -> System.out.println(INFO_HEAD + station.getName()));
            System.out.println();
        }
    }

    public static void printError(String message) {
        System.out.println();
        System.out.println(ERROR_HEAD +message);
    }
}
