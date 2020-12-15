package subway;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationManager {
    public static final String KEY_STATION_MANAGER = "stationManager";
    public static final String MENU_INT_ADD_STATION = "1";
    public static final String MENU_INT_DELETE_STATION = "2";
    public static final String MENU_INT_PRINT_STATION = "3";
    public static final String MSG_INPUT_STATION_TO_ADD = "\n## 등록할 역 이름을 입력하세요";
    public static final String MSG_COMPLETE_STATION_ADDED = "\n[INFO] 지하철 역이 등록되었습니다.";
    public static final String MSG_COMPLETE_STATION_DELETED = "\n[INFO] 지하철 역이 삭제되었습니다.";
    public static final String INPUT_MSG_STATION_TO_DELETE = "\n## 삭제할 역 이름을 입력하세요";
    public static final String ERROR_MSG_EXISTING_STATION = "\n[ERROR] 이미 등록된 역입니다.";
    public static final String ERROR_MSG_STATION_NAME_SHOULD_OVER_2_CHARACTERS = "\n[ERROR] 역 이름을 2글자 이상이어야 합니다.";
    public static final String ERROR_MSG_NON_EXISTING_STATION = "\n[ERROR] 존재하지 않는 역입니다.";
    public static final String ERROR_MSG_CANNOT_DELETE_STATION_IN_SECTION = "\n[ERROR] 노선에 등록되어 있는 역을 지울 수 없습니다.";
    public static final int INT_MINIMUM_CHARACTERS = 2;
    private final Scanner scanner;

    public StationManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputView inputView = new InputView(scanner, KEY_STATION_MANAGER);
        String menuNumber = inputView.nextMenu();
        selectMenu(menuNumber);
    }

    public void selectMenu(String menuNumber) {
        if (menuNumber.equals(MENU_INT_ADD_STATION)) {
            addStation();
        } else if (menuNumber.equals(MENU_INT_DELETE_STATION)) {
            deleteStation();
        } else if (menuNumber.equals(MENU_INT_PRINT_STATION)) {
            printStation();
        }
    }

    private void addStation() {
        System.out.println(MSG_INPUT_STATION_TO_ADD);
        String station = InputView.askName(scanner);
        try {
            validateOverTwoCharacters(station);
            validateNotExisting(station);
            StationRepository.addStation(new Station(station));
            System.out.println(MSG_COMPLETE_STATION_ADDED);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private void validateNotExisting(String station) {
        if (StationRepository.hasStation(station)) {
            throw new IllegalArgumentException(ERROR_MSG_EXISTING_STATION);
        }
    }

    private void validateOverTwoCharacters(String station) {
        if (station.length() < INT_MINIMUM_CHARACTERS) {
            throw new IllegalArgumentException(ERROR_MSG_STATION_NAME_SHOULD_OVER_2_CHARACTERS);
        }
    }

    private void deleteStation() {
        System.out.println(INPUT_MSG_STATION_TO_DELETE);
        String station = InputView.askName(scanner);
        try {
            validateExisting(station);
            validateRegisteredToLine(station);
            StationRepository.deleteStation(station);
            System.out.println(MSG_COMPLETE_STATION_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            run();
        }
    }

    private void validateExisting(String station) {
        if (!StationRepository.hasStation(station)) {
            throw new IllegalArgumentException(ERROR_MSG_NON_EXISTING_STATION);
        }
    }

    private void validateRegisteredToLine(String station) {
        if (LineRepository.isStationInSection(station)) {
            throw new IllegalArgumentException(ERROR_MSG_CANNOT_DELETE_STATION_IN_SECTION);
        }
    }

    public void printStation() {
        StationRepository.print();
    }


}
