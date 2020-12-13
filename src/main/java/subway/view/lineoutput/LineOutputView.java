package subway.view.lineoutput;

import subway.view.OutputView;

public class LineOutputView extends OutputView {
    private static final String LINE_CONTROLLER_OPTION = "노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";

    private static final String ENTER_LINE_NAME_TO_REGISTER = "등록할 노선 이름을 입력하세요.";
    private static final String ENTER_LINE_NAME_TO_DELETE = "삭제할 노선 이름을 입력하세요.";
    private static final String PRINT_LINE_LIST = "노선 목록";

    public static void printOption () {
        printOutput(LINE_CONTROLLER_OPTION);
        printNewLine();
    }
    public static void printLineRegisterInstruction() {
        printOutput(ENTER_LINE_NAME_TO_REGISTER);
    }

    public static void printLineDeleteInstruction() {
        printOutput(ENTER_LINE_NAME_TO_DELETE);
    }

    public static void printLineList() {
        printOutput(PRINT_LINE_LIST);
    }
}
