package subway;

import java.util.Scanner;

public class LineManager {

    public static final String MAIN_TITLE = "## 노선 관리 화면";
    public static final String STATION_ENROLLMENT = "1. 노선 등록";
    public static final String STATION_DELETION = "2. 노선 삭제";
    public static final String STATION_SEARCH = "3. 노선 조회";
    public static final String QUIT_OPTION = "B. 돌아가기";

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
}
