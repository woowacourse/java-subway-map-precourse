package subway.console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;

class SectionScreen implements SubwayScreen {
    private static final String SECTION_SCREEN_MANAGER_MENU = "## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기";
    private static final String MESSAGE_ADD_SECTION_INPUT_LINE_NAME = "## 노선을 입력하세요.";
    private static final String MESSAGE_ADD_SECTION_INPUT_STATION_NAME = "## 역이름을 입력하세요.";
    private static final String MESSAGE_ADD_SECTION_INPUT_STATION_INDEX = "## 순서를 입력하세요.";
    private static final String MESSAGE_SECTION_ADDED = "[INFO] 구간이 등록되었습니다.";
    private static final String MESSAGE_DELETE_SECTION_INPUT_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String MESSAGE_DELETE_SECTION_INPUT_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";
    private static final String MESSAGE_SECTION_DELETED = "[INFO] 구간이 삭제되었습니다.";
    private static final String[] SECTION_MENU_CHOICES = {"1", "2", "B"};
    private static final String SECTION_SCREEN_SELECT_ADD = SECTION_MENU_CHOICES[0];
    private static final String SECTION_SCREEN_SELECT_DELETE = SECTION_MENU_CHOICES[1];
    private static final String SECTION_SCREEN_SELECT_GO_BACK = SECTION_MENU_CHOICES[2];
    private static final String ERROR_INVALID_INPUT_INDEX = "[ERROR] 순서는 숫자를 입력해주세요!";
    private static String sectionScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            sectionScreenInput = getInput(scanner);
            validateInput(sectionScreenInput);
            transfer(scanner);
        } while (!sectionScreenInput.equals(SECTION_SCREEN_SELECT_GO_BACK));
    }

    @Override
    public void printScreen() {
        System.out.println(SECTION_SCREEN_MANAGER_MENU);
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String getInput(Scanner scanner) {
        sectionScreenInput = scanner.nextLine();
        validateInput(sectionScreenInput);
        return sectionScreenInput;
    }

    @Override
    public void validateInput(String input) {
        List<String> choices = Arrays.asList(SECTION_MENU_CHOICES);
        if(!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
    }

    @Override
    public void transfer(Scanner scanner) {
        inputAddSection(scanner);
        inputDeleteSection(scanner);
    }

    private void inputDeleteSection(Scanner scanner) {
        if (sectionScreenInput.equals(SECTION_SCREEN_SELECT_DELETE)) {
            System.out.println(MESSAGE_DELETE_SECTION_INPUT_LINE_NAME);
            // 삭제할 노선 이름 검사
            // 노선에 포함된 역 두 개 이하일 때 예외 처리
            System.out.println(MESSAGE_DELETE_SECTION_INPUT_STATION_NAME);
            // 노선에서 역 삭제
            System.out.println(MESSAGE_SECTION_DELETED);
        }
    }

    private void inputAddSection(Scanner scanner) {
        if (sectionScreenInput.equals(SECTION_SCREEN_SELECT_ADD)) {
            System.out.println(MESSAGE_ADD_SECTION_INPUT_LINE_NAME);
            String lineName = scanner.nextLine();
            Line line = LineRepository.getLine(lineName); // 노선 얻기
            System.out.println(MESSAGE_ADD_SECTION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            System.out.println(MESSAGE_ADD_SECTION_INPUT_STATION_INDEX);
            String stationIndex = scanner.nextLine();
            int index = validateIndex(stationIndex); // 인덱스 숫자로 변환
            line.addStation(stationName, index);
            System.out.println(MESSAGE_SECTION_ADDED);
        }
    }

    private int validateIndex(String stationIndex) {
        try {
            return Integer.parseInt(stationIndex);
        } catch (IllegalArgumentException e) {
           throw new IllegalArgumentException(ERROR_INVALID_INPUT_INDEX);
        }
    }
}
