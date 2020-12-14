package subway.screen;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.screenMessage.SectionScreenMessage;

class SectionScreen implements SubwayScreen, SectionScreenMessage {
    private static final String[] SECTION_MENU_CHOICES = {"1", "2", "B"};
    private static final String SECTION_SCREEN_SELECT_ADD = SECTION_MENU_CHOICES[0];
    private static final String SECTION_SCREEN_SELECT_DELETE = SECTION_MENU_CHOICES[1];
    private static final String SECTION_SCREEN_SELECT_GO_BACK = SECTION_MENU_CHOICES[2];

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
            String lineName = scanner.nextLine();
            Line line = LineRepository.getLine(lineName); // 노선 얻기
            System.out.println(MESSAGE_DELETE_SECTION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            line.deleteStation(stationName); // 노선에서 구간 삭제
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
             // 인덱스 숫자로 변환
            line.addStation(stationName, stationIndex); // 구간 추가
            System.out.println(MESSAGE_SECTION_ADDED);
        }
    }


}
