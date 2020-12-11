package subway.menu;

public enum LineMenu implements Menu {

    REGISTER("1", "노선 등록"),
    DELETE("2", "노선 삭제"),
    SEARCH("3", "노선 조회"),
    BACK("B", "돌아가기");

    final String order;
    final String menu;

    private static final String title = "노선 관리 ";

    LineMenu(String order, String menu) {
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
}
