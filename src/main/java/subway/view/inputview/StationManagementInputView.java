package subway.view.inputview;

import subway.view.utils.InputValidator;

import java.util.Scanner;

public class StationManagementInputView {
    public static final String VALID_DIGIT_PATTERN = "^[1-3]*$";
    public static final String STATION_MANAGEMENT_VIEW = "## 역 관리 화면";
    public static final String STATION_ADD = "1. 역 등록";
    public static final String STATION_DELETE = "2. 역 삭제";
    public static final String STATION_PRINT = "3. 역 조회";
    public static final String BACK = "B. 돌아가기";
    public static final String PLEASE_SELECT_ACTION = "## 원하는 기능을 선택하세요.";
    public static final String PLEASE_INPUT_STATION_NAME_TO_ADD = "## 등록할 역 이름을 입력하세요.";
    public static final String PLEASE_INPUT_STATION_NAME_TO_DELETE = "## 삭제할 역 이름을 입력하세요.";
    private final Scanner scanner;


    public StationManagementInputView(Scanner scanner) {
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
        System.out.println(STATION_MANAGEMENT_VIEW);
        System.out.println(STATION_ADD);
        System.out.println(STATION_DELETE);
        System.out.println(STATION_PRINT);
        System.out.println(BACK);
        System.out.println();
    }

    public String inputStationNameToAdd() {
        System.out.println(PLEASE_INPUT_STATION_NAME_TO_ADD);
        String stationName = this.scanner.nextLine().trim();
        System.out.println();
        return stationName;
    }

    public String inputStationNameToDelete() {
        System.out.println(PLEASE_INPUT_STATION_NAME_TO_DELETE);
        String stationName = this.scanner.nextLine().trim();
        System.out.println();
        return stationName;
    }
}
