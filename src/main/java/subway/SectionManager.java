package subway;

import java.util.Scanner;

public class SectionManager {

    public static final String WANT_QUIT_CODE = "B";
    public static String userOption = "";
    public static final String MAIN_TITLE = "## 구간 관리 화면";
    public static final String SECTION_ENROLLMENT = "1. 구간 등록";
    public static final String SECTION_DELETION = "2. 구간 삭제";
    public static final String QUIT_OPTION = "B. 돌아가기";

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
}
