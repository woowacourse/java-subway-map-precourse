package subway.view;

import java.util.Scanner;

public class UserInput {
    private static final String REQUEST_SELECT_MENU_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String REQUEST_SAVE_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String REQUEST_DELETE_STATION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getMenu() {
        System.out.println();
        System.out.println(REQUEST_SELECT_MENU_MESSAGE);
        String menu = scanner.nextLine().toUpperCase();     // 소문자 입력 예외처리
        System.out.println();
        return menu;
    }

    public static String getSaveStationName(){
        System.out.println(REQUEST_SAVE_STATION_MESSAGE);
        String stationName = scanner.nextLine();
        System.out.println();
        return stationName;
    }

    public static String getDeleteStationName() {
        System.out.println(REQUEST_DELETE_STATION_MESSAGE);
        String stationName = scanner.nextLine();
        System.out.println();
        return stationName;
    }
}
