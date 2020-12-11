package subway.console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.LineRepository;

public class LineScreen implements SubwayScreen {
    private static final String LINE_SCREEN_MANAGER_MENU = "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";
    private static final String MESSAGE_ADD_LINE_INPUT_LINE_NAME = "\n## 등록할 노선 이름을 입력하세요.";
    private static final String MESSAGE_ADD_LINE_INPUT_UP_END_STATION_OF_LINE = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String MESSAGE_ADD_LINE_INPUT_DOWN_END_STATION_OF_LINE = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String MESSAGE_LINE_ADDED = "\n[INFO] 지하철 노선이 등록되었습니다.";
    private static final String MESSAGE_DELETE_LINE_INPUT_LINE_NAME = "\n## 삭제할 노선 이름을 입력하세요.";
    private static final String MESSAGE_LINE_DELETED = "\n[INFO] 지하철 노선이 삭제되었습니다.";
    private static final String MESSAGE_STATION_LIST = "\n## 노선 목록";
    private static final String[] LINE_MENU_CHOICES = {"1", "2", "3", "B"};
    private static final String LINE_SCREEN_SELECT_ADD = LINE_MENU_CHOICES[0];
    private static final String LINE_SCREEN_SELECT_DELETE = LINE_MENU_CHOICES[1];
    private static final String LINE_SCREEN_SELECT_DISPLAY_ALL = LINE_MENU_CHOICES[2];
    private static final String LINE_SCREEN_SELECT_GO_BACK = LINE_MENU_CHOICES[3];
    private static String lineScreenInput;

    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            lineScreenInput = getInput(scanner);
            validateInput(lineScreenInput);
            transfer(scanner);
        } while (!lineScreenInput.equals(LINE_SCREEN_SELECT_GO_BACK));
    }

    @Override
    public void printScreen() {
        System.out.println(LINE_SCREEN_MANAGER_MENU);
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String getInput(Scanner scanner) {
        lineScreenInput = scanner.nextLine();
        validateInput(lineScreenInput);
        return lineScreenInput;
    }

    @Override
    public void validateInput(String input) {
        List<String> choices = Arrays.asList(LINE_MENU_CHOICES);
        if(!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
    }

    @Override
    public void transfer(Scanner scanner) {
        inputAddLine(scanner);
        inputDeleteLine(scanner);
        inputDisplayAllLines();
    }

    private void inputDisplayAllLines() {
        if (lineScreenInput.equals(LINE_SCREEN_SELECT_DISPLAY_ALL)) {
            LineRepository.displayAllLines();
        }
    }

    private void inputDeleteLine(Scanner scanner) {
    }

    private void inputAddLine(Scanner scanner) {
        if (lineScreenInput.equals(LINE_SCREEN_SELECT_ADD)) {
            System.out.println(MESSAGE_ADD_LINE_INPUT_LINE_NAME);
            String lineName = scanner.nextLine();
            System.out.println(MESSAGE_ADD_LINE_INPUT_UP_END_STATION_OF_LINE);
            String upEndStation = scanner.nextLine();
            System.out.println(MESSAGE_ADD_LINE_INPUT_DOWN_END_STATION_OF_LINE);
            String downEndStation = scanner.nextLine();
            LineRepository.initializeLine(lineName, upEndStation, downEndStation);
        }
    }


}
