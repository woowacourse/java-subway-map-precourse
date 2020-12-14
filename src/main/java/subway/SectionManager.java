package subway;

import java.util.Scanner;

public class SectionManager {

    public static final String WANT_QUIT_CODE = "B";
    public static String userOption = "";
    public static final String MAIN_TITLE = "## 구간 관리 화면";
    public static final String SECTION_ENROLLMENT = "1. 구간 등록";
    public static final String SECTION_DELETION = "2. 구간 삭제";
    public static final String QUIT_OPTION = "B. 돌아가기";
    public static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String ERROR_PREFIX = "[ERROR] ";
    private static final int OPTION_MIN = 1;
    private static final int OPTION_MAX = 2;
    public static final String OPTION_ERROR_MESSAGE = "1~2 또는 B 옵션 중 하나를 입력하세요";
    public static final String INPUT_LINE_MESSAGE = "## 노선 이름을 입력하세요.";
    public static final String LINE_NAME_DELETION_ERROR_MESSAGE = "존재하는 2자 이상의 노선 이름을 입력하세요";
    private static final int MIN_NAME_LENGTH = 2;
    public static final String INPUT_STATION_MESSAGE = "## 역 이름을 입력하세요.";
    public static final String STATION_NAME_ERROR_MESSAGE = "존재하는 2자 이상의 역 이름을 입력하세요";
    public static final String INPUT_ORDER_MESSAGE = "## 순서를 입력하세요.";
    public static final String ORDER_ERROR_MESSAGE = "숫자로 순서를 입력하세요";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ENROLLMENT_SECTION_INFO_MESSAGE = "구간이 등록되었습니다";
    public static final String ASK_LINE_DELETION_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String ASK_STATION_DELETION_MESSAGE = "## 삭제할 구간의 역을 입력하세요.";
    public static final String DELETION_SECTION_MESSAGE = "구간이 삭제되었습니다";
    public static final String DELETION_FAIL_INFO_MESSAGE = "존재하지 않거나 삭제할 수 없습니다";

    public static void manage(Scanner scanner) {
        printSectionManagementScreen();
        userOption = getUserOption(scanner);
        callOptionMenu(userOption, scanner);
    }

    public static void printSectionManagementScreen() {
        System.out.println(MAIN_TITLE);
        System.out.println(SECTION_ENROLLMENT);
        System.out.println(SECTION_DELETION);
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
            throw new IllegalArgumentException(ERROR_PREFIX + OPTION_ERROR_MESSAGE);
        }
    }

    public static void callOptionMenu(String userOption, Scanner scanner) {
        if (!Character.isDigit(userOption.charAt(0))) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber == 1) {
            enrollSection(scanner);
        }
        if (optionNumber == 2) {
            deleteSection(scanner);
        }
    }

    public static void enrollSection(Scanner scanner) {
        System.out.println(INPUT_LINE_MESSAGE);
        String lineName = inputLineNameForSection(scanner);
        System.out.println(INPUT_STATION_MESSAGE);
        String stationName = inputStationNameForEnrollment(scanner);
        System.out.println(INPUT_ORDER_MESSAGE);
        int order = inputOrderForEnrollment(scanner);
        SubwayManager.addSection(lineName, stationName, order);
        System.out.println();
        System.out.println(INFO_PREFIX + ENROLLMENT_SECTION_INFO_MESSAGE);
        System.out.println();
    }

    public static String inputLineNameForSection(Scanner scanner) {
        String lineName = scanner.nextLine();
        try {
            validateLineNameForEnrollment(lineName);
            return lineName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputLineNameForSection(scanner);
        }
    }

    public static void validateLineNameForEnrollment(String lineName)
        throws IllegalArgumentException {
        if (lineName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(LINE_NAME_DELETION_ERROR_MESSAGE);
        }
        if (!SubwayManager.isExistLine(lineName)) {
            throw new IllegalArgumentException(LINE_NAME_DELETION_ERROR_MESSAGE);
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

    public static void validateStationNameForEnrollment(String stationName)
        throws IllegalArgumentException {
        if (stationName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
        if (!SubwayManager.isDuplicatedStation(stationName)) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
    }

    public static int inputOrderForEnrollment(Scanner scanner) {
        String order = scanner.nextLine();
        try {
            validateOrderForEnrollment(order);
            return Integer.parseInt(order);
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputOrderForEnrollment(scanner);
        }
    }

    public static void validateOrderForEnrollment(String order) throws IllegalArgumentException {
        try {
            int intOrder = Integer.parseInt(userOption);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX + ORDER_ERROR_MESSAGE);
        }
    }

    public static void deleteSection(Scanner scanner) {
        System.out.println(ASK_LINE_DELETION_MESSAGE);
        String lineName = inputLineNameForSection(scanner);
        System.out.println(ASK_STATION_DELETION_MESSAGE);
        String stationName = inputStationNameForEnrollment(scanner);
        if (SubwayManager.deleteSection(lineName, stationName)) {
            System.out.println(INFO_PREFIX + DELETION_SECTION_MESSAGE);
            System.out.println();
            return;
        }
        System.out.println(INFO_PREFIX + DELETION_FAIL_INFO_MESSAGE);
        System.out.println();
    }
}
