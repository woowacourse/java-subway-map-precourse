package subway.menus;

import java.util.stream.Stream;

public enum StationMenu implements Menu {
    STATION_INSERT("1", "역 등록"),
    STATION_DELETE("2", "역 삭제"),
    STATION_SELECT("3", "역 조회"),
    GO_BACK_TO_MAIN_MENU("B", "돌아가기");

    private String option;
    private String description;

    StationMenu(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public static StationMenu getMenu(String input) {
        return Stream.of(StationMenu.values())
            .filter(stationMenu -> stationMenu.option.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_MENU_EXCEPTION_MESSAGE));
    }

    @Override
    public String toString() {
        return option + POINT + description;
    }
}
