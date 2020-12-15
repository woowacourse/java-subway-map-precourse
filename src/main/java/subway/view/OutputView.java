package subway.view;

import subway.domain.MainActions;
import subway.domain.DetailActions;

public class OutputView {
    public static final String INFO_HEAD = "[INFO] ";
    public static final String NOTICE_HEAD = "## ";
    private static final String ERROR_HEAD = "[ERROR] ";
    private static final String DELIMITER_NUMBER_ACTION = ". ";
    private static final String SPACE = " ";
    private static final String NOTICE_MANAGE = " 관리";
    private static final String NOTICE_PRINTING = " 출력";

    public static void printMain() {
        System.out.println();
        System.out.println(NOTICE_HEAD + "메인 화면");
        System.out.println(MainActions.STATION.getActionNumber() + DELIMITER_NUMBER_ACTION + MainActions.STATION.getActionName() + NOTICE_MANAGE);
        System.out.println(MainActions.LINE.getActionNumber() + DELIMITER_NUMBER_ACTION + MainActions.LINE.getActionName() + NOTICE_MANAGE);
        System.out.println(MainActions.WAY.getActionNumber() + DELIMITER_NUMBER_ACTION + MainActions.WAY.getActionName() + NOTICE_MANAGE);
        System.out.println(MainActions.SUBWAY.getActionNumber() + DELIMITER_NUMBER_ACTION + MainActions.SUBWAY.getActionName() + NOTICE_PRINTING);
        System.out.println(MainActions.FINISH.getActionNumber() + DELIMITER_NUMBER_ACTION + MainActions.FINISH.getActionName());
        System.out.println();
    }

    public static void printDetailAction(MainActions mainActions) {
        System.out.println();
        System.out.println(NOTICE_HEAD + mainActions.getActionName() + " 관리 화면");
        System.out.println(DetailActions.ENROLL.getActionNumber() + DELIMITER_NUMBER_ACTION + mainActions.getActionName() + SPACE + DetailActions.ENROLL.getActionName());
        System.out.println(DetailActions.REMOVE.getActionNumber() + DELIMITER_NUMBER_ACTION + mainActions.getActionName() + SPACE + DetailActions.REMOVE.getActionName());
        if (!mainActions.equals(MainActions.WAY)) {
            System.out.println(DetailActions.RESEARCH.getActionNumber() + DELIMITER_NUMBER_ACTION + mainActions.getActionName() + SPACE + DetailActions.RESEARCH.getActionName());
        }
        System.out.println(DetailActions.BACK.getActionNumber() + DELIMITER_NUMBER_ACTION + DetailActions.BACK.getActionName());
        System.out.println();
    }

    public static void printError(String message) {
        System.out.println();
        System.out.println(ERROR_HEAD + message);
    }

    public static void printOneLine() {
        System.out.println();
    }
}
