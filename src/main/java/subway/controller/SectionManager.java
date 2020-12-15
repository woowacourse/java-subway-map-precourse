package subway.controller;

import subway.InputView;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Scanner;

public class SectionManager {
    public static final String KEY_SECTION_MANAGER = "sectionManager";
    public static final String MENU_INT_ADD_STATION_TO_SECTION = "1";
    public static final String MENU_INT_DELETE_STATION_FROM_SECTION = "2";
    public static final String MSG_INPUT_LINE_TO_REGISTER = "\n## 노선을 입력하세요.";
    public static final String MSG_INPUT_STATION_TO_REGISTER_TO_SECTION = "\n## 역이름을 입력하세요.";
    public static final String MSG_INPUT_STATION_ORDER_IN_SECTION = "\n## 순서를 입력하세요.";
    public static final String MSG_INPUT_LINE = "\n## 노선을 입력하세요.";
    public static final String MSG_INPUT_STATION_TO_DELETE = "\n## 삭제할 구간의 역을 입력하세요.";
    public static final String MSG_COMPLETE_LINE_DELETED = "\n[INFO] 구간이 삭제되었습니다.";
    public static final String ERROR_MSG_NON_EXISTING_STATION = "\n[ERROR] 존재하지 않는 역입니다.";
    public static final String ERROR_MSG_NON_EXISTING_STATION_IN_SECTION = "\n[ERROR] 노선에 존재하지 않는 역입니다.";
    public static final String ERROR_MSG_LINE_SHOULD_HAVE_AT_LEAST_TWO_STATIONS = "\n[ERROR] 노선에 등록된 역이 2개인 경우 역을 삭제할 수 없습니다.";
    public static final String ERROR_MSG_NON_EXISTING_LINE = "\n[ERROR] 존재하지 않는 노선입니다.";
    public static final int INT_ORDINARY_TO_CODING_INDEX = 1;
    public static final int INT_MINIMUM_STATIONS_AT_SECTION = 2;
    private final Scanner scanner;

    public SectionManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputView inputView = new InputView(scanner, KEY_SECTION_MANAGER);
        String menuNumber = inputView.nextMenu();
        selectMenu(menuNumber);
    }

    private void selectMenu(String menuNumber) {
        if (menuNumber.equals(MENU_INT_ADD_STATION_TO_SECTION)) {
            addStationToStation();
        } else if (menuNumber.equals(MENU_INT_DELETE_STATION_FROM_SECTION)) {
            deleteLine();
        }
    }

    private void addStationToStation() {
        try {
            String line = askLineAndValidate();
            String station = askStationAndValidate();
            String index = InputView.askName(scanner, MSG_INPUT_STATION_ORDER_IN_SECTION);
            Line lineToRegister = LineRepository.searchLineByName(line);
            int toCodingIndex = Integer.parseInt(index) - INT_ORDINARY_TO_CODING_INDEX;
            lineToRegister.addStationToSection(toCodingIndex, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private String askStationAndValidate() throws IllegalArgumentException {
        String station = InputView.askName(scanner, MSG_INPUT_STATION_TO_REGISTER_TO_SECTION);
        validateExistingStation(station);
        return station;
    }

    private String askLineAndValidate() throws IllegalArgumentException {
        String line = InputView.askName(scanner, MSG_INPUT_LINE_TO_REGISTER);
        validateExistingLine(line);
        return line;
    }

    private void validateExistingLine(String line) {
        if (!LineRepository.hasLine(line)) {
            throw new IllegalArgumentException(ERROR_MSG_NON_EXISTING_LINE);
        }
    }

    private void validateExistingStation(String station) {
        if (!StationRepository.hasStation(station)) {
            throw new IllegalArgumentException(ERROR_MSG_NON_EXISTING_STATION);
        }
    }

    private void deleteLine() {
        try {
            String line = InputView.askName(scanner, MSG_INPUT_LINE);
            String station = InputView.askName(scanner, MSG_INPUT_STATION_TO_DELETE);
            validateExistingLine(line);
            validateLineHasLeastTwoStation(line);
            validateStationInSection(line, station);
            System.out.println(MSG_COMPLETE_LINE_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private void validateStationInSection(String line, String station) {
        if (!LineRepository.searchLineByName(line).deleteStationFromSection(station)) {
            throw new IllegalArgumentException(ERROR_MSG_NON_EXISTING_STATION_IN_SECTION);
        }
    }

    private void validateLineHasLeastTwoStation(String name) {
        if (LineRepository.searchLineByName(name).sectionLength() <= INT_MINIMUM_STATIONS_AT_SECTION) {
            throw new IllegalArgumentException(ERROR_MSG_LINE_SHOULD_HAVE_AT_LEAST_TWO_STATIONS);
        }
    }

}
