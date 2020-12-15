package subway.domain.menu;

public enum MainMenu {
    STATION("1", MenuList.STATION.getName()+" 관리")
    , LINE("2", MenuList.LINE.getName()+" 관리")
    , SECTION("3", MenuList.SECTION.getName()+" 관리")
    , MAP("4", MenuList.MAP.getName()+" 출력")
    , END("Q", "종료");

    final private String order;
    final private String message;

    MainMenu(String order, String message) {
        this.order = order;
        this.message = message;
    }

    public String getOrder() {
        return order;
    }

    public String getMessage() {
        return message;
    }

}
