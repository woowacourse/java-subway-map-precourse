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

    public void manage(Scanner scanner) {
        while (!userOption.equals(WANT_QUIT_CODE)) {
            printSectionManagementScreen();
            userOption = getUserOption(scanner);
            callOptionMenu(userOption, scanner);
        }
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
}
