package subway.view.linesectionoutput;

import subway.view.OutputView;

public class LineSectionOutputView extends OutputView {
    private static final String LINE_CONTROLLER_OPTION = "구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기";

    private static final String ENTER_LINE_NAME_FOR_REGISTRATION = "노선을 입력하세요.";
    private static final String ENTER_STATION_NAME_FOR_REGISTRATION = "역이름을 입력하세요.";
    private static final String ENTER_ORDER_FOR_REGISTRATION = "순서를 입력하세요.";
    private static final String ENTER_LINE_NAME_FOR_DELETION = "삭제할 구간의 노선을 입력하세요.";
    private static final String ENTER_STATION_NAME_FOR_DELETION = "삭제할 구간의 역을 입력하세요.";

    public static void printOption () {
        printOutput(LINE_CONTROLLER_OPTION);
        printNewLine();
    }

    public static void printLineSectionRegisterLineNameInstruction() {
        printOutput(ENTER_LINE_NAME_FOR_REGISTRATION);
    }

    public static void printLineSectionRegisterStationNameInstruction() {
        printOutput(ENTER_STATION_NAME_FOR_REGISTRATION);
    }

    public static void printLineSectionRegisterOrderInstruction() {
        printOutput(ENTER_ORDER_FOR_REGISTRATION);
    }

    public static void printLineSectionDeletionLineNameInstruction() {
        printOutput(ENTER_LINE_NAME_FOR_DELETION);
    }

    public static void printLineSectionDeletionStationNameInstruction() {
        printOutput(ENTER_STATION_NAME_FOR_DELETION);
    }
}
