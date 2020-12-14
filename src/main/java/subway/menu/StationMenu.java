package subway.menu;

public enum StationMenu implements Menu {

    REGISTER("1", "역 등록", Action.REGISTER),
    DELETE("2", "역 삭제", Action.DELETE),
    SEARCH("3", "역 조회", Action.SEARCH),
    BACK("B", "돌아가기", Action.BACK);

    private final String order;
    private final String menu;
    private final Action action;

    private static final String MENU_TITLE = "역 관리 ";
    private static final String MENU_TYPE = "역";

    StationMenu(String order, String menu, Action action) {
        this.order = order;
        this.menu = menu;
        this.action = action;
    }

    @Override
    public Menu run() {
        return action.action(this);
    }

    @Override
    public String toString() {
        return order + ". " + menu;
    }

    @Override
    public Menu[] getValues() {
        return values();
    }

    @Override
    public String getTitle() {
        return MENU_TITLE;
    }

    @Override
    public String getType() {
        return MENU_TYPE;
    }

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public String getOrder() {
        return order;
    }
}
