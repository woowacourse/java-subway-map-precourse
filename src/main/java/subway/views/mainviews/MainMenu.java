package subway.views.mainviews;

enum MainMenu {
    STATION_MANAGEMENT("1", "역 관리"),
    LINE_MANAGEMENT("2", "노선 관리"),
    SECTION_MANAGEMENT("3", "구간 관리"),
    SHOW_SUBWAYS("4", "지하철 노선도 출력"),
    EXIT_PROGRAM("Q","종료");

    private String optionalItem;
    private String itemDescription;

    MainMenu(String optionalItem, String itemDescription) {
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
