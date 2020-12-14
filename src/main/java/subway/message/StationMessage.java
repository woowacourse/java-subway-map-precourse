package subway.message;

public enum StationMessage {
    STATION_FUNCTION_LIST("## 역 관리 화면\n"
        + "1. 역 등록\n"
        + "2. 역 삭제\n"
        + "3. 역 조회\n"
        + "B. 돌아가기"),
    STATION_ADD_GUIDE("## 등록할 역 이름을 입력하세요"),
    ;
    private final String text;

    StationMessage(String text) {
        this.text = text;
    }

    public String getStationMessage() {
        return this.text;
    }

}
