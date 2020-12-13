package subway.menus;

public enum MainMenu implements Menu{
    STATION_MANAGEMENT("1", "역 관리"),
    LINE_MANAGEMENT("2", "노선 관리"),
    SECTION_MANAGEMENT("3", "구간 관리"),
    SHOW_SUBWAYS("4", "지하철 노선도 출력"),
    EXIT_PROGRAM("Q", "종료");

    private String option;
    private String description;

    MainMenu(String option, String description) {
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
