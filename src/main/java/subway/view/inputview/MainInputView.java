package subway.view.inputview;

import subway.view.utils.InputValidator;

import java.util.Scanner;

public class MainInputView {
    public static final String VALID_DIGIT_PATTERN = "^[1-4]*$";
    public static final String MAIN_VIEW = "## 메인 화면";
    public static final String STATION_MANAGEMENT = "1. 역 관리";
    public static final String LINE_MANAGEMENT = "2. 노선 관리";
    public static final String SECTION_MANAGEMENT = "3. 구간 관리";
    public static final String SUBWAY_LINES_PRINT = "4. 지하철 노선도 출력";
    public static final String EXIT = "Q. 종료";
    public static final String PLEASE_SELECT_MODE = "## 원하는 기능을 선택하세요.";
    private final Scanner scanner;

    public MainInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputCommand() {
        System.out.println(PLEASE_SELECT_MODE);
        String command = this.scanner.nextLine().trim();
        System.out.println();
        InputValidator.validateMainViewInput(VALID_DIGIT_PATTERN, command);
        return command;
    }

    public void showOptions() {
        System.out.println(MAIN_VIEW);
        System.out.println(STATION_MANAGEMENT);
        System.out.println(LINE_MANAGEMENT);
        System.out.println(SECTION_MANAGEMENT);
        System.out.println(SUBWAY_LINES_PRINT);
        System.out.println(EXIT);
        System.out.println();
    }
}
