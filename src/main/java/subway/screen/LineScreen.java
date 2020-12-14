package subway.screen;

import java.util.Arrays;
import java.util.Scanner;
import subway.domain.LineRepository;
import subway.screenMessage.LineScreenMessage;

class LineScreen implements SubwayScreen, LineScreenMessage {
    private String lineScreenInput;

    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            lineScreenInput = validateInput(scanner.nextLine());
            transfer(scanner);
        } while (!lineScreenInput.equals(BACK));
    }

    @Override
    public void printScreen() {
        System.out.println(MENU);
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String validateInput(String input) {
        if (!Arrays.asList(MENU_CHOICES).contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
        return input;
    }

    @Override
    public void transfer(Scanner scanner) {
        inputAddLine(scanner);
        inputDeleteLine(scanner);
        inputDisplayAllLines();
    }

    private void inputDisplayAllLines() {
        if (lineScreenInput.equals(DISPLAY)) {
            System.out.println(MESSAGE_STATION_LIST);
            LineRepository.displayAllLines();
        }
    }

    private void inputDeleteLine(Scanner scanner) {
        if (lineScreenInput.equals(DELETE)) {
            System.out.println(MESSAGE_INPUT_LINE_NAME_TO_DELETE);
            String lineName = scanner.nextLine();
            LineRepository.deleteLineByName(lineName);
            System.out.println(MESSAGE_LINE_DELETED);
        }
    }

    private void inputAddLine(Scanner scanner) {
        if (lineScreenInput.equals(ADD)) {
            System.out.println(MESSAGE_INPUT_LINE_NAME_TO_ADD);
            String lineName = scanner.nextLine();
            LineRepository.validateLineName(lineName);
            System.out.println(MESSAGE_INPUT_UP_END_STATION_OF_LINE_TO_ADD);
            String upEndStation = scanner.nextLine();
            System.out.println(MESSAGE_INPUT_DOWN_END_STATION_OF_LINE_TO_ADD);
            String downEndStation = scanner.nextLine();
            LineRepository.validateEndStationNames(upEndStation, downEndStation);
            LineRepository.initializeLine(lineName, upEndStation, downEndStation);
            System.out.println(MESSAGE_LINE_ADDED);
        }
    }


}
