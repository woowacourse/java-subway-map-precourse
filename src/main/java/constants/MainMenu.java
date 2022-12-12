package constants;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum MainMenu {
    FIRST("1", "1. 역 관리"),
    SECOND("2", "2. 노선 관리"),
    THIRD("3", "3. 구간 관리"),
    FOURTH("4", "4. 지하철 노선도 출력"),
    QUIT("Q", "Q. 종료");

    private final String userInput;
    private final String menuName;

    MainMenu(String userInput, String menuName) {
        this.userInput = userInput;
        this.menuName = menuName;
    }

    public static boolean isQuit(String selection) {
        return QUIT.userInput.equals(selection);
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
