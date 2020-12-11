package subway.menu;

public enum MainMenu implements Menu {

    STATION("1", "역 관리"),
    LINE("2", "노선 관리"),
    SECTION("3", "구간 관리"),
    MAP("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    final String order;
    final String menu;

    private static final String title = "메인 ";

    MainMenu(String order, String menu) {
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
