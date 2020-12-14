package subway;

import java.util.Scanner;
import subway.domain.Station;

public class StationManager {

    public static final String WANT_QUIT_CODE = "B";
    public static final String MAIN_TITLE = "## 역 관리 화면";
    public static final String STATION_ENROLLMENT = "1. 역 등록";
    public static final String STATION_DELETION = "2. 역 삭제";
    public static final String STATION_SEARCH = "3. 역 조회";
    public static final String QUIT_OPTION = "B. 돌아가기";
    public static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String OPTION_ERROR_MESSAGE = "1~3 또는 B 옵션 중 하나를 입력하세요";
    public static final String STATION_NAME_ERROR_MESSAGE = "존재하지 않는 2자 이상의 역 이름을 입력하세요";
    public static final String STATION_EXIST_ERROR_MESSAGE = "존재하는 2자 이상의 역 이름을 입력하세요";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String INPUT_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    public static final String ENROLLMENT_STATION_INFO_MESSAGE = "지하철 역이 등록되었습니다";
    public static final String ASK_DELETION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    public static final String DELETION_INFO_MESSAGE = "지하철 역이 삭제되었습니다";
    public static final String DELETION_FAIL_INFO_MESSAGE = "지하철 역이 존재하지 않거나 삭제할 수 없습니다";
    private static final int OPTION_MIN = 1;
    private static final int OPTION_MAX = 3;
    private static final int MIN_NAME_LENGTH = 2;
    public static String userOption = "";

    public static void manage(Scanner scanner) {
        printStationManagementScreen();
        userOption = getUserOption(scanner);
        callOptionMenu(userOption, scanner);
    }

    public static void printStationManagementScreen() {
        System.out.println(MAIN_TITLE);
        System.out.println(STATION_ENROLLMENT);
        System.out.println(STATION_DELETION);
        System.out.println(STATION_SEARCH);
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

    public static String inputStationNameForEnrollment(Scanner scanner) {
        String stationName = scanner.nextLine();
        try {
            validateStationNameForEnrollment(stationName);
            return stationName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputStationNameForEnrollment(scanner);
        }
    }

    public static String inputStationNameForDeletion(Scanner scanner) {
        String stationName = scanner.nextLine();
        try {
            validateStationNameForDeletion(stationName);
            return stationName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputStationNameForDeletion(scanner);
        }
    }

    public static void validateUserOption(String userOption) throws IllegalArgumentException {
        if (userOption.equals(WANT_QUIT_CODE)) {
            return;
        }
        int optionNumber;
        try {
            optionNumber = Integer.parseInt(userOption);
            if (optionNumber < OPTION_MIN || optionNumber > OPTION_MAX) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX + OPTION_ERROR_MESSAGE);
        }
    }

    public static void validateStationNameForEnrollment(String stationName) throws IllegalArgumentException {
        if (stationName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
        if (SubwayManager.isDuplicatedStation(stationName)) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
    }

    public static void validateStationNameForDeletion(String stationName) throws IllegalArgumentException {
        if (stationName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
        if (!SubwayManager.isExistStation(stationName)) {
            throw new IllegalArgumentException(STATION_EXIST_ERROR_MESSAGE);
        }
    }

    public static void callOptionMenu(String userOption, Scanner scanner) {
        if (!Character.isDigit(userOption.charAt(0))) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber == 1) {
            enrollStation(scanner);
        }
        if (optionNumber == 2) {
            deleteStation(scanner);
        }
        if (optionNumber == 3) {
            searchStation(scanner);
        }
    }

    public static void enrollStation(Scanner scanner) {
        System.out.println(INPUT_STATION_MESSAGE);
        String stationName = inputStationNameForEnrollment(scanner);
        SubwayManager.addStation(stationName);
        System.out.println();
        System.out.println(INFO_PREFIX + ENROLLMENT_STATION_INFO_MESSAGE);
        System.out.println();
    }

    public static void deleteStation(Scanner scanner) {
        System.out.println(ASK_DELETION_MESSAGE);
        String stationName = inputStationNameForDeletion(scanner);
        if (SubwayManager.deleteStation(stationName)) {
            System.out.println(INFO_PREFIX + DELETION_INFO_MESSAGE);
            System.out.println();
            return;
        }
        System.out.println(INFO_PREFIX + DELETION_FAIL_INFO_MESSAGE);
        System.out.println();
    }

    public static void searchStation(Scanner scanner) {
        SubwayManager.printStation();
    }
}
