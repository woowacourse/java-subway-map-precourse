package subway;

import java.util.Scanner;
import subway.domain.Station;

public class StationManager {

    public static final String WANT_QUIT_CODE = "B";
    public static final String MAIN_TITLE = "## 역 관리 화면";
    public static final String STATION_ENROLLMENT = "역 등록";
    public static final String STATION_DELETION = "역 삭제";
    public static final String STATION_SEARCH = "역 조회";
    public static final String QUIT_OPTION = "역 조회";
    public static final String ASK_OPTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String OPTION_ERROR_MESSAGE = "1~3 또는 B 옵션 중 하나를 입력하세요";
    public static final String STATION_NAME_ERROR_MESSAGE = "존재하지 않는 2자 이상의 역 이름을 입력하세요";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ENROLLMENT_INFO_MESSAGE = "지하철 역이 등록되었습니다";
    public static final String DELETION_INFO_MESSAGE = "지하철 역이 삭제되었습니다";
    public static final String DELETION_FAIL_INFO_MESSAGE = "지하철 역이 존재하지 않습니다";
    private static final int OPTION_MIN = 1;
    private static final int OPTION_MAX = 3;
    private static final int MIN_NAME_LENGTH = 2;
    public static String userOption = "";

    public static void manage(Scanner scanner) {
        while (!userOption.equals(WANT_QUIT_CODE)) {
            printStationManagementScreen();
            userOption = getUserOption(scanner);
            callOptionMenu(userOption, scanner);
        }
    }

    public static void printStationManagementScreen() {
        System.out.println(MAIN_TITLE);
        System.out.println(STATION_ENROLLMENT);
        System.out.println(STATION_DELETION);
        System.out.println(STATION_SEARCH);
        System.out.println(QUIT_OPTION);
    }
}
