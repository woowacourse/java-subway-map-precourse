package subway.domain.program;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.controller.SectionManageController;
import subway.domain.input.SectionManageInput;
import java.util.Scanner;

public class SectionManageProgram {

    static final String SECTION_MANAGE_SCREEN = "## 구간 관리 화면";
    static final String SECTION_ENROLL = "1. 구간 등록";
    static final String SECTION_DELETE = "2. 구간 삭제";
    static final String GO_BACK = "B. 돌아가기";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";
    static final String INPUT_STATION_NAME = "## 역이름을 입력하세요.";
    static final String INPUT_ORDER = "## 순서를 입력하세요.";
    static final String INPUT_LINE_NAME = "## 노선을 입력하세요.";
    static final String INFO = "[INFO] ";
    static final String SECTION_ENROLLED = "구간이 등록되었습니다";
    static final String INPUT_DELETE_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    static final String INPUT_DELETE_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";
    static final String SECTION_DELETED = "구간이 삭제되었습니다.";
    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_BACK = "B";

    private boolean goBack = false;

    SectionManageInput input = new SectionManageInput();
    SectionManageController controller = new SectionManageController();

    public String getSelectFunction(Scanner scanner) {
        System.out.println("\n" + SECTION_MANAGE_SCREEN);
        System.out.println(SECTION_ENROLL);
        System.out.println(SECTION_DELETE);
        System.out.println(GO_BACK + "\n");
        System.out.println(SELECT_FUNCTION);
        return input.inputSectionManageScreen(scanner);
    }

    public void printEnrollSection(Scanner scanner, String function) {
        if (function.equals(FUNCTION_ONE)) {
            System.out.println("\n" + INPUT_LINE_NAME);
            Line line = input.inputLine(scanner);
            System.out.println("\n" + INPUT_STATION_NAME);
            Station station = input.inputStation(scanner);
            System.out.println("\n" + INPUT_ORDER);
            int order = input.inputStationOrder(scanner);
            controller.processEnrollSection(line, station, order);
            System.out.println("\n" + INFO + SECTION_ENROLLED);
        }
    }

    public void printDeleteSection(Scanner scanner, String function) {
        if (function.equals(FUNCTION_TWO)) {
            System.out.println("\n" + INPUT_DELETE_LINE_NAME);
            Line line = input.inputLine(scanner);
            System.out.println("\n" + INPUT_DELETE_STATION_NAME);
            Station station = input.inputStation(scanner);
            controller.processDeleteSection(line, station);
            System.out.println("\n" + INFO + SECTION_DELETED);
        }
    }

    public void checkGoBack(String function) {
        if (function.equals(FUNCTION_BACK)) {
            this.goBack = true;
        }
    }

    public void printSectionManageProgram(Scanner scanner) {
        this.goBack = false;
        while (!goBack) {
            try {
                String function = getSelectFunction(scanner);
                printEnrollSection(scanner, function);
                printDeleteSection(scanner, function);
                checkGoBack(function);
            } catch (IllegalArgumentException illegalArgumentException) {
            }
        }
    }



}
