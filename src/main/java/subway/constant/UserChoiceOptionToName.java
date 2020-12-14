package subway.constant;

public enum UserChoiceOptionToName {
    /**
     * 메인 메뉴 관련 항목
     */
    STATION_MANAGEMENT("1"),
    LINE_MANAGEMENT("2"),
    SECTION_MANAGEMENT("3"),
    STATION_MAP_PRINT("4"),
    EXIT("Q"),
    BACK("B"),

    /**
     * 역 메뉴 관련 항목
     */
    STATION_ADD("1"),
    STATION_DELETE("2"),
    STATION_CHECK("3"),

    /**
     * 라인 메뉴 관련 항목
     */
    LINE_ADD("1"),
    LINE_DELETE("2"),
    LINE_CHECK("3"),

    /**
     * 구간 메뉴 관련 항목
     */
    SECTION_ADD("1"),
    SECTION_DELETE("2"),
    ;
    private final String option;

    UserChoiceOptionToName(String option) {
        this.option = option;
    }

    public String getUserChoiceOptionToName() {
        return this.option;
    }
}
