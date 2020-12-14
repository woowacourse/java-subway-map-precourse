package subway.screen;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.screenMessage.SectionScreenMessage;

class SectionScreen implements SubwayScreen, SectionScreenMessage {
    private static String sectionScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            sectionScreenInput = validateInput(scanner.nextLine());
            transfer(scanner);
        } while (!sectionScreenInput.equals(BACK));
    }

    @Override
    public void printScreen() {
        System.out.println(MENU);
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String validateInput(String input) {
        List<String> choices = Arrays.asList(MENU_CHOICES);
        if (!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
        return input;
    }

    @Override
    public void transfer(Scanner scanner) {
        inputAddSection(scanner);
        inputDeleteSection(scanner);
    }

    private void inputDeleteSection(Scanner scanner) {
        if (sectionScreenInput.equals(DELETE)) {
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
        if (sectionScreenInput.equals(ADD)) {
            System.out.println(MESSAGE_ADD_SECTION_INPUT_LINE_NAME);
            String lineName = scanner.nextLine();
            Line line = LineRepository.getLine(lineName); // 노선 얻기
            System.out.println(MESSAGE_ADD_SECTION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            System.out.println(MESSAGE_ADD_SECTION_INPUT_STATION_INDEX);
            String stationIndex = scanner.nextLine();
            line.addStation(stationName, stationIndex); // 구간 추가
            System.out.println(MESSAGE_SECTION_ADDED);
        }
    }
}
