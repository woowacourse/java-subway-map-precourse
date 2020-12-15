package subway.menus;

import java.util.stream.Stream;

public enum LineMenu implements Menu {
    LINE_ADD("1", "노선 등록"),
    LINE_DELETE("2", "노선 삭제"),
    LINE_SELECT("3", "노선 조회"),
    GO_BACK_TO_MAIN_MENU("B", "돌아가기");

    private String option;
    private String description;

    LineMenu(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public static LineMenu getMenu(String input) {
        return Stream.of(LineMenu.values())
            .filter(lineMenu -> lineMenu.option.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_MENU_EXCEPTION_MESSAGE));
    }

    @Override
    public String toString() {
        return option + POINT + description;
    }
}
