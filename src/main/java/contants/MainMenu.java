package contants;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum MainMenu {
    FIRST_MENU("1", "1. 역 관리"),
    SECOND_MENU("2", "2. 노선 관리"),
    THIRD_MENU("3", "3. 구간 관리"),
    FOURTH_MENU("4", "4. 지하철 노선도 출력"),
    QUIT("Q", "Q. 종료");

    private final String userInput;
    private final String menuName;

    MainMenu(String userInput, String menuName) {
        this.userInput = userInput;
        this.menuName = menuName;
    }

    public String getUserInput() {
        return this.userInput;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public static String getWholeMenu() {
        return Arrays.stream(MainMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }
}
