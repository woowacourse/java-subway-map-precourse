package subway.domain.program;

import subway.domain.Line;
import subway.domain.controller.LineManageController;
import subway.domain.input.LineManageInput;

import java.util.Scanner;

public class LineManageProgram {

    static final String LINE_MANAGE_SCREEN = "## 노선 관리 화면";
    static final String LINE_ENROLL = "1. 노선 등록";
    static final String LINE_DELETE = "2. 노선 삭제";
    static final String LINE_INQUIRY = "3. 노선 조회";
    static final String GO_BACK = "B. 돌아가기";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";
    static final String INPUT_UP_TRAIN_TERMINAL = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    static final String INPUT_DOWN_TRAIN_TERMINAL = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    static final String INPUT_ENROLL_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    static final String INFO = "[INFO] ";
    static final String LINE_ENROLLED = "지하철 노선이 등록되었습니다";
    static final String INPUT_DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    static final String LINE_DELETED = "지하철 노선이 삭제되었습니다.";
    static final String LINE_CATEGORY = "노선 목록";
    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_BACK = "B";

    private boolean goBack = false;

    LineManageInput input = new LineManageInput();
    LineManageController controller = new LineManageController();

    public String getSelectFunction(Scanner scanner) {
        System.out.println(LINE_MANAGE_SCREEN);
        System.out.println(LINE_ENROLL);
        System.out.println(LINE_DELETE);
        System.out.println(LINE_INQUIRY);
        System.out.println(GO_BACK);
        System.out.println(SELECT_FUNCTION);
        return input.inputLineManageScreen(scanner);
    }

    public void printEnrollLine(Scanner scanner, String function) {
        if (function.equals(FUNCTION_ONE)) {
            System.out.println(INPUT_ENROLL_LINE_NAME);
            Line line = new Line(input.inputEnrollLine(scanner));
            System.out.println(INPUT_UP_TRAIN_TERMINAL);
            controller.processUpDownTrain(scanner, line);
            System.out.println(INPUT_DOWN_TRAIN_TERMINAL);
            controller.processUpDownTrain(scanner, line);
            controller.processEnrollLine(line);
            System.out.println(INFO + LINE_ENROLLED);
        }
    }

    public void printDeleteLine(Scanner scanner, String function) {
        if (function.equals(FUNCTION_TWO)) {
            System.out.println(INPUT_DELETE_LINE_NAME);
            controller.processDeleteLine(scanner);
            System.out.println(INFO + LINE_DELETED);
        }
    }

    public void printAllLine(String function) {
        if (function.equals(FUNCTION_THREE)) {
            System.out.println(LINE_CATEGORY);
            controller.printAllLines();
        }
    }

    public void checkGoBack(String function) {
        if (function.equals(FUNCTION_BACK)) {
            this.goBack = true;
        }
    }

    public void printLineManageProgram(Scanner scanner) {
        this.goBack = false;
        while (!goBack) {
            try {
                String function = getSelectFunction(scanner);
                printEnrollLine(scanner, function);
                printDeleteLine(scanner, function);
                printAllLine(function);
                checkGoBack(function);
            } catch (IllegalArgumentException illegalArgumentException) {
            }
        }
    }



}
