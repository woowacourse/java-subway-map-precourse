package subway.domain.program;

import subway.domain.controller.StationManageController;
import subway.domain.input.StationManageInput;

import java.util.Scanner;

public class StationManageProgram {

    static final String STATION_MANAGE_SCREEN = "## 역 관리 화면";
    static final String STATION_ENROLL = "1. 역 등록";
    static final String STATION_DELETE = "2. 역 삭제";
    static final String STATION_INQUIRY = "3. 역 조회";
    static final String GO_BACK = "B. 돌아가기";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";
    static final String INPUT_ENROLL_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    static final String INFO = "[INFO] ";
    static final String STATION_ENROLLED = "지하철 역이 등록되었습니다";
    static final String INPUT_DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    static final String STATION_DELETED = "지하철 역이 삭제되었습니다.";
    static final String STATION_CATEGORY = "## 역 목록";
    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_BACK = "B";

    private boolean goBack = false;

    StationManageController controller = new StationManageController();
    StationManageInput input = new StationManageInput();

    public String getSelectFunction(Scanner scanner) {
        System.out.println("\n" + STATION_MANAGE_SCREEN);
        System.out.println(STATION_ENROLL);
        System.out.println(STATION_DELETE);
        System.out.println(STATION_INQUIRY);
        System.out.println(GO_BACK + "\n");
        System.out.println(SELECT_FUNCTION);
        return input.inputStationManageScreen(scanner);
    }

    public void printEnrollStation(Scanner scanner, String function) {
        if (function.equals(FUNCTION_ONE)) {
            System.out.println("\n" + INPUT_ENROLL_STATION_NAME);
            controller.processEnrollStation(scanner);
            System.out.println("\n"+ INFO + STATION_ENROLLED);
        }
    }

    public void printDeleteStation(Scanner scanner, String function) {
        if (function.equals(FUNCTION_TWO)) {
            System.out.println("\n" + INPUT_DELETE_STATION_NAME);
            controller.processDeleteStation(scanner);
            System.out.println("\n" + INFO + STATION_DELETED);
        }
    }

    public void printAllStation(String function) {
        if (function.equals(FUNCTION_THREE)) {
            System.out.println("\n" + STATION_CATEGORY);
            controller.printAllStations();
        }
    }

    public void checkGoBack(String function) {
        if (function.equals(FUNCTION_BACK)) {
            this.goBack = true;
        }
    }

    public void printStationManageProgram(Scanner scanner) {
        this.goBack = false;
        while (!goBack) {
            try {
                String function = getSelectFunction(scanner);
                printEnrollStation(scanner, function);
                printDeleteStation(scanner, function);
                printAllStation(function);
                checkGoBack(function);
            } catch (IllegalArgumentException illegalArgumentException) {
            }
        }
    }

}
