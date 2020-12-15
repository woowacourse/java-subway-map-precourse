package subway.view.inputview;

import subway.view.utils.InputValidator;

import java.util.Scanner;

public class LineManagementInputView {
    public static final String VALID_DIGIT_PATTERN = "^[1-3]*$";
    public static final String LINE_MANAGEMENT_VIEW = "## 노선 관리 화면";
    public static final String LINE_ADD = "1. 노선 등록";
    public static final String LINE_DELETE = "2. 노선 삭제";
    public static final String LINE_PRINT = "3. 노선 조회";
    public static final String BACK = "B. 돌아가기";
    public static final String PLEASE_SELECT_ACTION = "## 원하는 기능을 선택하세요.";
    public static final String PLEASE_INPUT_LINE_NAME_TO_ADD = "## 등록할 노선 이름을 입력하세요.";
    public static final String PLEASE_INPUT_LINE_NAME_TO_DELETE = "## 삭제할 노선 이름을 입력하세요.";
    public static final String PLEASE_INPUT_UPWARD_END_STATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String PLEASE_INPUT_DOWNWARD_END_STATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private final Scanner scanner;


    public LineManagementInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCommand() {
        System.out.println(PLEASE_SELECT_ACTION);
        String command = this.scanner.nextLine().trim();
        System.out.println();
        InputValidator.validateStationOrLineManagementViewInput(VALID_DIGIT_PATTERN, command);
        return command;
    }

    public void showOptions() {
        System.out.println(LINE_MANAGEMENT_VIEW);
        System.out.println(LINE_ADD);
        System.out.println(LINE_DELETE);
        System.out.println(LINE_PRINT);
        System.out.println(BACK);
        System.out.println();
    }

    public String inputLineNameToAdd() {
        System.out.println(PLEASE_INPUT_LINE_NAME_TO_ADD);
        String lineName = this.scanner.nextLine().trim();
        System.out.println();
        return lineName;
    }

    public String inputLineNametoDelete() {
        System.out.println(PLEASE_INPUT_LINE_NAME_TO_DELETE);
        String lineName = this.scanner.nextLine().trim();
        System.out.println();
        return lineName;
    }

    public String inputUpwardEndStationName() {
        System.out.println(PLEASE_INPUT_UPWARD_END_STATION);
        String stationName = this.scanner.nextLine().trim();
        System.out.println();
        return stationName;
    }

    public String inputDownwardEndStationName() {
        System.out.println(PLEASE_INPUT_DOWNWARD_END_STATION);
        String stationName = this.scanner.nextLine().trim();
        System.out.println();
        return stationName;
    }
}
