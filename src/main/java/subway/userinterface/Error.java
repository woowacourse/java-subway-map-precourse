package subway.userinterface;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.MenuRepository;
import subway.domain.StationRepository;

public class Error {
    private static final String ERROR = "\n[ERROR] ";

    public static boolean returnStatus(boolean status) {
        if (status) {
            System.out.println(ERROR + "선택할 수 없는 기능입니다.");
        }
        return status;
    }

    public static boolean isWrongMainMenuInput(String input) {
        boolean status = MenuRepository.mainMenuButtons.stream().noneMatch(button -> button.equals(input));
        return returnStatus(status);
    }

    public static boolean isWrongStationMenuInput(String input) {
        boolean status = MenuRepository.stationMenuButtons.stream().noneMatch(button -> button.equals(input));
        return returnStatus(status);
    }

    public static boolean isWrongLineMenuInput(String input) {
        boolean status = MenuRepository.lineMenuButtons.stream().noneMatch(button -> button.equals(input));
        return returnStatus(status);
    }

    public static boolean isWrongIntervalMenuInput(String input) {
        boolean status = MenuRepository.intervalMenuButtons.stream().noneMatch(button -> button.equals(input));
        return returnStatus(status);
    }

    public static boolean printAlreadyExistStationError(String stationNameInput) {
        if (StationRepository.isStationPresent(stationNameInput)) {
            System.out.println(ERROR + "이미 존재하는 역 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printAlreadyExistLineError(String lineNameInput) {
        if (LineRepository.isLinePresent(lineNameInput)) {
            System.out.println(ERROR + "이미 존재하는 노선 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printStationAlreadyExistInLineError(String stationNameInput) {
        if (LineRepository.hasStationInLine(stationNameInput)) {
            System.out.println(ERROR + "이미 노선안에 있는 역입니다.");
            return true;
        }
        return false;
    }

    public static boolean printStationAlreadyExistInCertainLineError(String lineName, String stationName) {
        Line line = LineRepository.findLineByName(lineName);
        if (LineRepository.hasStationInCertainLine(line, stationName)) {
            System.out.println(ERROR + lineName + "안에 존재하는 역 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printNotExistStationError(String stationNameInput) {
        if (!StationRepository.isStationPresent(stationNameInput)) {
            System.out.println(ERROR + "존재하지 않는 역 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printNotExistLineError(String lineNameInput) {
        if (!LineRepository.isLinePresent(lineNameInput)) {
            System.out.println(ERROR + "존재하지 않는 노선 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printStationNotExistInCertainLineError(String lineName, String stationName) {
        Line line = LineRepository.findLineByName(lineName);
        if (!LineRepository.hasStationInCertainLine(line, stationName)) {
            System.out.println(ERROR + lineName + "안에 존재하지 않는 역 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printNotEnoughStationInLineError(String lineName) {
        Line line = LineRepository.findLineByName(lineName);
        if (LineRepository.lines().get(line).size() < 3) {
            System.out.println(ERROR + lineName + "의 역을 더이상 삭제할 수 없습니다.");
            return true;
        }
        return false;
    }

    public static boolean printIsWrongSequenceInput(String lineName, int seq) {
        if (seq > LineRepository.lines().get(LineRepository.findLineByName(lineName)).size() + 1) {
            System.out.println(ERROR + "입력값이 너무 큽니다.");
            return true;
        }
        if (seq < 1) {
            System.out.println(ERROR + "입력값이 너무 작습니다.");
            return true;
        }
        return false;
    }

    public static void printNotIntInput() {
        System.out.println(ERROR + "숫자를 입력해야 합니다.");
    }
}
