package subway.menu;

public enum SectionMenu implements Menu {

    REGISTER("1", "구간 등록"),
    DELETE("2", "구간 삭제"),
    BACK("B", "돌아가기");

    final String order;
    final String menu;

    private static final String title = "구간 관리 ";

    SectionMenu(String order, String menu) {
        this.order = order;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return order + ". " + menu;
    }
    @Override
    public Menu run() {
        return null;
    }

    @Override
    public Menu[] getValues() {
        return values();
    }
    @Override
    public String getTitle() {
        return title;
    }
}
