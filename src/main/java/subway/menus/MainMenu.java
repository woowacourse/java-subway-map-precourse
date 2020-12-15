package subway.menus;

import java.util.stream.Stream;

public enum MainMenu {
    STATION_MANAGEMENT("1", "역 관리"),
    LINE_MANAGEMENT("2", "노선 관리"),
    SECTION_MANAGEMENT("3", "구간 관리"),
    SHOW_SUBWAY_MAP("4", "지하철 노선도 출력"),
    EXIT_PROGRAM("Q", "종료");

    private final String option;
    private final String description;

    MainMenu(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public static MainMenu getMenu(String input) {
        return Stream.of(MainMenu.values())
            .filter(mainMenu -> mainMenu.option.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(MenuConstant.NOT_EXIST_MENU_EXCEPTION_MESSAGE));
    }

    @Override
    public String toString() {
        return option + MenuConstant.POINT + description;
    }
}
