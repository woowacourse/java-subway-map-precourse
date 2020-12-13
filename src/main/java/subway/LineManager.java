package subway;

import java.util.Scanner;

public class LineManager {

    public static final String MAIN_TITLE = "## 노선 관리 화면";
    public static final String STATION_ENROLLMENT = "1. 노선 등록";
    public static final String STATION_DELETION = "2. 노선 삭제";
    public static final String STATION_SEARCH = "3. 노선 조회";
    public static final String QUIT_OPTION = "B. 돌아가기";
    public static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String WANT_QUIT_CODE = "B";
    public static final String OPTION_ERROR_MESSAGE = "1~3 또는 B 옵션 중 하나를 입력하세요";
    private static final int OPTION_MIN = 1;
    private static final int OPTION_MAX = 3;
    private static final int MIN_NAME_LENGTH = 2;
    public static final String INPUT_LINE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    public static final String LINE_NAME_ERROR_MESSAGE = "존재하지 않는 2자 이상의 노선 이름을 입력하세요";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ENROLLMENT_LINE_INFO_MESSAGE = "지하철 역이 등록되었습니다";
    public static String userOption = "";

    public static void manage(Scanner scanner) {
        printLineManagerScreen();
        userOption = getUserOption(scanner);
        callOptionMenu(userOption, scanner);
    }

    public static void printLineManagerScreen() {
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

    public static void callOptionMenu(String userOption, Scanner scanner) {
        if (!Character.isDefined(userOption.charAt(0))) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber == 1) {
            enrollLine(scanner);
        }
//        if (optionNumber == 2) {
//            deleteStation(scanner);
//        }
//        if (optionNumber == 3) {
//            searchStation(scanner);
//        }
    }

    public static void enrollLine(Scanner scanner) {
        System.out.println(INPUT_LINE_MESSAGE);
        String lineName = inputLineNameForEnrollment(scanner);
        String upwardStationName = StationManager.inputStationNameForEnrollment(scanner);
        String downwardStationName = StationManager.inputStationNameForEnrollment(scanner);
        SubwayManager.addLine(lineName, upwardStationName, downwardStationName);
        System.out.println();
        System.out.println(INFO_PREFIX + ENROLLMENT_LINE_INFO_MESSAGE);
        System.out.println();
    }

    public static String inputLineNameForEnrollment(Scanner scanner) {
        String lineName = scanner.nextLine();
        try {
            validateLineNameForEnrollment(lineName);
            return lineName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputLineNameForEnrollment(scanner);
        }
    }

    public static void validateLineNameForEnrollment(String lineName)
        throws IllegalArgumentException {
        if (lineName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(LINE_NAME_ERROR_MESSAGE);
        }
        if (SubwayManager.isDuplicatedLine(lineName)) {
            throw new IllegalArgumentException(LINE_NAME_ERROR_MESSAGE);
        }
    }
}
