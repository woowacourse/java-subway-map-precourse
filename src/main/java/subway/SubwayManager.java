package subway;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayManager {

    private static final String WANT_QUIT_CODE = "Q";
    private static final String MAIN_TITLE = "## 메인 화면";
    private static final String MANAGE_STATION_OPTION = "1. 역 관리";
    private static final String MANAGE_LINE_OPTION = "2. 노선 관리";
    private static final String MANAGE_SECTION_OPTION = "3. 구간 관리";
    private static final String PRINT_MAP_OPTION = "4. 지하철 노선도 출력";
    private static final String QUIT_OPTION = "Q. 종료";
    private static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String ERROR_MESSAGE = "1~4 또는 Q 옵션 중 하나를 입력하세요";
    private static final int OPTION_MIN = 1;
    private static final int OPTION_MAX = 4;
    private static String userOption = "";
    private static StationRepository stationRepository = new StationRepository();

    public static void manage(Scanner scanner) {
        while (!userOption.equals(WANT_QUIT_CODE)) {
            printMainScreen();
            userOption = getUserOption(scanner);
            callOptionMenu(userOption, scanner);
        }
    }

    public static void printMainScreen() {
        System.out.println(MAIN_TITLE);
        System.out.println(MANAGE_STATION_OPTION);
        System.out.println(MANAGE_LINE_OPTION);
        System.out.println(MANAGE_SECTION_OPTION);
        System.out.println(PRINT_MAP_OPTION);
        System.out.println(QUIT_OPTION);
        System.out.println();
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
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_MESSAGE);
        }
    }

    public static void callOptionMenu(String userOption, Scanner scanner) {
        if (!Character.isDefined(userOption.charAt(0))) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber == 1) {
            new StationManager().manage(scanner);
        }
//        if (optionNumber == 2) {
//            LineManagement.manage(scanner);
//        }
//        if (optionNumber == 3) {
//            SectionManagement.manage(scanner);
//        }
        if (optionNumber == 4) {
            printMap();
        }
    }

    public static void printMap() {

    }

    public static void addStation(String stationName) {
        stationRepository.addStation(new Station(stationName));
    }

    public static boolean deleteStation(String stationName) {
        return stationRepository.deleteStation(stationName);
    }

    public static void printStation() {
        for (Station station : stationRepository.stations()) {
            System.out.println(INFO_PREFIX + station.getName());
        }
        System.out.println();
    }

    public static boolean isDuplicated(String stationName) {
        return stationRepository.isDuplicated(stationName);
    }
}
