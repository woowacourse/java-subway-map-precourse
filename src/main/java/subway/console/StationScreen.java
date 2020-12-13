package subway.console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.StationRepository;

class StationScreen implements SubwayScreen {
    private static final String STATION_SCREEN_MANAGER_MENU = "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";
    private static final String MESSAGE_ADD_STATION_INPUT_STATION_NAME = "\n## 등록할 역 이름을 입력하세요.";
    private static final String MESSAGE_DELETE_STATION_INPUT_STATION_NAME = "\n## 삭제할 역 이름을 입력하세요.";
    private static final String MESSAGE_STATION_LIST = "\n## 역 목록";
    private static final String[] STATION_MENU_CHOICES = {"1", "2", "3", "B"};
    private static final String STATION_SCREEN_SELECT_ADD = STATION_MENU_CHOICES[0];
    private static final String STATION_SCREEN_SELECT_DELETE = STATION_MENU_CHOICES[1];
    private static final String STATION_SCREEN_SELECT_DISPLAY_ALL = STATION_MENU_CHOICES[2];
    private static final String STATION_SCREEN_SELECT_GO_BACK = STATION_MENU_CHOICES[3];
    private static final String MESSAGE_STATION_ADDED = "\n[INFO] 지하철 역이 등록되었습니다.";
    private static final String MESSAGE_STATION_DELETED = "\n[INFO] 지하철 역이 삭제되었습니다.";
    private static final String MESSAGE_NO_STATION = "\n[INFO] 등록된 역이 존재하지 않습니다.";
    private static String stationScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            stationScreenInput = getInput(scanner);
            validateInput(stationScreenInput);
            transfer(scanner);
        } while (!stationScreenInput.equals(STATION_SCREEN_SELECT_GO_BACK));
    }

    @Override
    public void transfer(Scanner scanner) {
        inputAddStation(scanner);
        inputDeleteStation(scanner);
        inputDisplayAllStations();
    }

    private void inputDisplayAllStations() {
        if (stationScreenInput.equals(STATION_SCREEN_SELECT_DISPLAY_ALL)) {
            System.out.println(MESSAGE_STATION_LIST);
            StationRepository.displayAllStations();
            printIfNoStation();
        }
    }

    private void printIfNoStation() {
        if (StationRepository.stations().size() == 0) {
            System.out.println(MESSAGE_NO_STATION);
        }
    }

    private void inputDeleteStation(Scanner scanner) {
        if (stationScreenInput.equals(STATION_SCREEN_SELECT_DELETE)) {
            System.out.println(MESSAGE_DELETE_STATION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            StationRepository.deleteStation(stationName);
            System.out.println(MESSAGE_STATION_DELETED);
        }
    }

    private void inputAddStation(Scanner scanner) {
        if (stationScreenInput.equals(STATION_SCREEN_SELECT_ADD)) {
            System.out.println(MESSAGE_ADD_STATION_INPUT_STATION_NAME);
            String stationName = scanner.nextLine();
            StationRepository.addStation(stationName);
            System.out.println(MESSAGE_STATION_ADDED);
        }
    }

    @Override
    public void printScreen() {
        System.out.println(STATION_SCREEN_MANAGER_MENU);
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String getInput(Scanner scanner) {
        stationScreenInput = scanner.nextLine();
        validateInput(stationScreenInput);
        return stationScreenInput;
    }

    @Override
    public void validateInput(String input) {
        List<String> choices = Arrays.asList(STATION_MENU_CHOICES);
        if(!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
    }
}
