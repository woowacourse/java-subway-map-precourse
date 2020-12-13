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

    public static boolean printAlreadyExistStationError(String stationNameInput) {
        if (StationRepository.isStationExists(stationNameInput)) {
            System.out.println(ERROR + "이미 존재하는 역 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printAlreadyExistLineError(String lineNameInput) {
        if (LineRepository.isLineExists(lineNameInput)) {
            System.out.println(ERROR + "이미 존재하는 노선 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printStationExistInLineError(String stationNameInput) {
        if (LineRepository.hasStationInLine(stationNameInput)) {
            System.out.println(ERROR + "이미 노선안에 있는 역입니다.");
            return true;
        }
        return false;
    }

    public static boolean printNotExistStationError(String stationNameInput) {
        if (!StationRepository.isStationExists(stationNameInput)) {
            System.out.println(ERROR + "존재하지 않는 역 이름입니다.");
            return true;
        }
        return false;
    }

    public static boolean printNotExistLineError(String lineNameInput) {
        if (!LineRepository.isLineExists(lineNameInput)) {
            System.out.println(ERROR + "존재하지 않는 노선 이름입니다.");
            return true;
        }
        return false;
    }

//    public static boolean printStationAlreadyExistInLineError(String lineName, String stationName) {
//        Line line = LineRepository.findLineByName(lineName);
//        if (LineRepository.hasStationInCertainLine(line, stationName)) {
//            System.out.println(ERROR + lineName + "안에 존재하는 역 이름입니다.");
//            return true;
//        }
//        return false;

//    }
}
