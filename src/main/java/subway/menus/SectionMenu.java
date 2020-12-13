package subway.menus;

import java.util.stream.Stream;

public enum SectionMenu implements Menu {
    SECTION_INSERT("1", "구간 등록"),
    SECTION_DELETE("2", "구간 삭제"),
    GO_BACK_TO_MAIN_MENU("B", "돌아가기");

    private String option;
    private String description;

    SectionMenu(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public static SectionMenu getMenu(String input) {
        return Stream.of(SectionMenu.values())
            .filter(sectionMenu -> sectionMenu.option.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_MENU_EXCEPTION_MESSAGE));
    }

    @Override
    public String toString() {
        return option + POINT + description;
    }
}
