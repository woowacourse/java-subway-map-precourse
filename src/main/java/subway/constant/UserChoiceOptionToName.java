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
    ;

    private final String option;

    UserChoiceOptionToName(String option){
        this.option = option;
    }
    public String getUserChoiceOptionToName(){
        return this.option;
    }
}
