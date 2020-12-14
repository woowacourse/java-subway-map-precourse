package subway.screen;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.StationRepository;
import subway.screenMessage.StationScreenMessage;

class StationScreen implements SubwayScreen, StationScreenMessage {
    private static String stationScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            stationScreenInput = validateInput(scanner.nextLine());
            transfer(scanner);
        } while (!stationScreenInput.equals(BACK));
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
        inputAddStation(scanner);
        inputDeleteStation(scanner);
        inputDisplayAllStations();
    }

    private void inputDisplayAllStations() {
        if (stationScreenInput.equals(DISPLAY_ALL)) {
            System.out.println(MESSAGE_STATION_LIST);
            StationRepository.displayAllStations();
        }
    }

    private void inputDeleteStation(Scanner scanner) {
        if (stationScreenInput.equals(DELETE)) {
            System.out.println(MESSAGE_DELETE_STATION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            StationRepository.deleteStation(stationName);
            System.out.println(MESSAGE_STATION_DELETED);
        }
    }

    private void inputAddStation(Scanner scanner) {
        if (stationScreenInput.equals(ADD)) {
            System.out.println(MESSAGE_ADD_STATION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            StationRepository.addStation(stationName);
            System.out.println(MESSAGE_STATION_ADDED);
        }
    }
}
