package subway.message;

public enum StationMessage {
    STATION_FUNCTION_LIST("## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기"),
    ;

    private final String text;

    StationMessage(String text) {
        this.text = text;
    }

    public String getStationMessage() {
        return this.text;
    }

}
