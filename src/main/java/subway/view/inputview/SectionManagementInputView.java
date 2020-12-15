package subway.view.inputview;

import subway.view.utils.InputValidator;

import java.util.Scanner;

public class SectionManagementInputView {
    public static final String VALID_DIGIT_PATTERN = "^[1-2]*$";
    public static final String SECTION_MANAGEMENT_VIEW = "## 구간 관리 화면";
    public static final String SECTION_ADD = "1. 구간 등록";
    public static final String SECTION_DELETE = "2. 구간 삭제";
    public static final String BACK = "B. 돌아가기";
    public static final String PLEASE_SELECT_ACTION = "## 원하는 기능을 선택하세요.";
    public static final String PLEASE_INPUT_LINE_NAME_FOR_ADD = "## 노선을 입력하세요.";
    public static final String PLEASE_INPUT_STATION_NAME_FOR_ADD = "## 역이름을 입력하세요.";
    public static final String PLEASE_INPUT_POSITION_FOR_ADD = "## 순서를 입력하세요.";
    public static final String PLEASE_INPUT_LINE_NAME_FOR_DELETE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String PLEASE_INPUT_STATION_NAME_FOR_DELETE = "## 삭제할 구간의 역을 입력하세요.";
    private final Scanner scanner;

    public SectionManagementInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCommand() {
        System.out.println(PLEASE_SELECT_ACTION);
        String command = this.scanner.nextLine().trim();
        System.out.println();
        InputValidator.validateSectionManagementViewInput(VALID_DIGIT_PATTERN, command);
        return command;
    }

    public void showOptions() {
        System.out.println(SECTION_MANAGEMENT_VIEW);
        System.out.println(SECTION_ADD);
        System.out.println(SECTION_DELETE);
        System.out.println(BACK);
        System.out.println();
    }

    public String inputLineNameForAdd() {
        System.out.println(PLEASE_INPUT_LINE_NAME_FOR_ADD);
        String lineName = this.scanner.nextLine().trim();
        System.out.println();
        return lineName;
    }

    public String inputStationNameForAdd() {
        System.out.println(PLEASE_INPUT_STATION_NAME_FOR_ADD);
        String stationName = this.scanner.nextLine().trim();
        System.out.println();
        return stationName;
    }

    public String inputPositionForAdd() {
        System.out.println(PLEASE_INPUT_POSITION_FOR_ADD);
        String position = this.scanner.nextLine().trim();
        System.out.println();
        return position;
    }

    public String inputLineNameForDelete() {
        System.out.println(PLEASE_INPUT_LINE_NAME_FOR_DELETE);
        String position = this.scanner.nextLine().trim();
        System.out.println();
        return position;
    }

    public String inputStationNameForDelete() {
        System.out.println(PLEASE_INPUT_STATION_NAME_FOR_DELETE);
        String position = this.scanner.nextLine().trim();
        System.out.println();
        return position;
    }
}
