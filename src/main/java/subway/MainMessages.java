package subway;

public enum MainMessages {

    PRINT_MAIN("##", " 메인 화면"),
    STATION_MANAGEMENT("1", ". 역 관리"),
    LINE_MANAGEMENT("2", ". 노선 관리"),
    SECTION_MANAGEMENT("3", ". 구간 관리"),
    PRINT_SUBWAY_MAP("4", ". 지하철 노선도 출력"),
    QUIT("Q", ". 종료");

    private final String message;
    private final String selectNumber;

    MainMessages(String selectNumber, String message) {
        this.selectNumber = selectNumber;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getSelectNumber() {
        return selectNumber;
    }
}
