package subway.view;

import java.util.Arrays;

public class MainDisplay implements Display {
    private enum mainMenu {
        CONTROL_STATION("1", "역 관리"),
        CONTROL_LINE("2", "노선 관리"),
        CONTROL_SECTION("3", "구간 관리"),
        PRINT_ALL_SECTION("4", "지하철 노선도 출력"),
        EXIT_PROGRAM("Q", "종료");

        private String menuKey;
        private String menuName;

        mainMenu(String menuKey, String menuName) {
            this.menuKey = menuKey;
            this.menuName = menuName;
        }
    }

    public static void selectMenu(){
        mainMenu.values().
    }
}
