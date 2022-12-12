package constants;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum StationMenu {
    FIRST("1", "1. 역 등록"),
    SECOND("2", "2. 역 삭제"),
    THIRD("3", "3. 역 조회"),
    BACK("B", "B. 돌아가기");

    private final String userInput;
    private final String menuName;

    StationMenu(String userInput, String menuName) {
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
        return Arrays.stream(StationMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }
}
