package subway.views.lineviews;

enum StationMenu {
    STATION_INSERT("1", "역 등록"),
    STATION_DELETE("2", "역 삭제"),
    STATION_SELECT("3", "역 조회"),
    GO_BACK_TO_MAIN_MENU("B", "돌아가기");

    private String optionalItem;
    private String itemDescription;

    StationMenu(String optionalItem, String itemDescription) {
        this.optionalItem = optionalItem;
        this.itemDescription = itemDescription;
    }

    public String getOptionalItem() {
        return optionalItem;
    }

    @Override
    public String toString() {
        return optionalItem + ". " + itemDescription;
    }
}
