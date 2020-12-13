package subway.menus;

public enum SectionMenu implements Menu{
    SECTION_INSERT("1", "구간 등록"),
    SECTION_DELETE("2", "구간 삭제"),
    GO_BACK_TO_MAIN_MENU("B", "돌아가기");

    private String option;
    private String description;

    SectionMenu(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public String getOption() {
        return option;
    }

    @Override
    public String toString() {
        return option + POINT + description;
    }
}
