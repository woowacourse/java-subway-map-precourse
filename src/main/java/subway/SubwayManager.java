package subway;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import view.SubwayManagerView;

public class SubwayManager {

    private static final String WANT_QUIT_CODE = "Q";
    private static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String ERROR_MESSAGE = "1~4 또는 Q 옵션 중 하나를 입력하세요";
    private static final int OPTION_MIN = 1;
    private static final int OPTION_MAX = 4;
    static final int OPTION_ONE = 1;
    static final int OPTION_TWO = 2;
    static final int OPTION_THREE = 3;
    static final int OPTION_FOUR = 4;
    private static String userOption = "";
    private static StationRepository stationRepository = new StationRepository();
    private static LineRepository lineRepository = new LineRepository();

    public void manage(Scanner scanner) {
        while (!userOption.equals(WANT_QUIT_CODE)) {
            SubwayManagerView.printSubwayManagerMainScreen();
            userOption = getUserOption(scanner);
            runOptionMenu(userOption, scanner);
        }
    }

    public static String getUserOption(Scanner scanner) {
        try {
            System.out.println(ASK_OPTION_MESSAGE);
            userOption = scanner.nextLine();
            System.out.println();
            validateUserOption(userOption);
            return userOption;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return getUserOption(scanner);
        }
    }

    public static void validateUserOption(String userOption) throws IllegalArgumentException {
        if (userOption.equals(WANT_QUIT_CODE)) {
            return;
        }
        try {
            int optionNumber = Integer.parseInt(userOption);
            if (optionNumber < OPTION_MIN || optionNumber > OPTION_MAX) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void runOptionMenu(String userOption, Scanner scanner) {
        if (!Character.isDigit(userOption.charAt(0))) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber == OPTION_ONE) {
            StationManager.manage(scanner);
        }
        if (optionNumber == OPTION_TWO) {
            LineManager.manage(scanner);
        }
        if (optionNumber == OPTION_THREE) {
            SectionManager.manage(scanner);
        }
        if (optionNumber == OPTION_FOUR) {
            printMap();
        }
    }

    public static void addStation(String stationName) {
        stationRepository.addStation(new Station(stationName));
    }

    public static boolean deleteStation(String stationName) {
        return stationRepository.deleteStation(stationName);
    }

    public static boolean deleteLine(String lineName) {
        return lineRepository.deleteLineByName(lineName);
    }

    public static void printStation() {
        for (Station station : stationRepository.stations()) {
            System.out.println(INFO_PREFIX + station.getName());
        }
        System.out.println();
    }

    public static boolean isDuplicatedStation(String stationName) {
        return stationRepository.isDuplicated(stationName);
    }

    public static void addLine(String lineName, String upwardStationName,
        String downwardStationName) {
        lineRepository.addLine(lineName, upwardStationName, downwardStationName);
    }

    public static boolean isDuplicatedLine(String lineName) {
        return lineRepository.isDuplicated(lineName);
    }

    public static boolean isExistStation(String stationName) {
        for (Station station : stationRepository.stations()) {
            if (station.isSameName(stationName)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isExistLine(String lineName) {
        for (Line line : lineRepository.lines()) {
            if (line.isSameName(lineName)) {
                return true;
            }
        }
        return false;
    }

    public static void printLine() {
        for (Line line : lineRepository.lines()) {
            System.out.println(INFO_PREFIX + line.getName());
        }
        System.out.println();
    }

    public static void addSection(String lineName, String stationName, int order) {
        lineRepository.addSection(lineName, stationName, order);
    }

    public static boolean deleteSection(String lineName, String stationName) {
        return lineRepository.deleteSection(lineName, stationName);
    }

    public static void printMap() {
        lineRepository.printAll();
    }

    public static boolean isStationInLine(String name) {
        return lineRepository.isStationInLine(name);
    }
}
