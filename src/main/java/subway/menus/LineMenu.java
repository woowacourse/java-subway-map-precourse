package subway.menus;

public enum LineMenu implements Menu{
    LINE_INSERT("1", "노선 등록"),
    LINE_DELETE("2", "노선 삭제"),
    LINE_SELECT("3", "노선 조회"),
    GO_BACK_TO_MAIN_MENU("B", "돌아가기");

    private String option;
    private String description;

    LineMenu(String option, String description) {
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
