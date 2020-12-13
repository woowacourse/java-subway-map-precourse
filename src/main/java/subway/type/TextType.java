package subway.type;

public enum TextType {
    NEW_LINE("\n"),
    HORIZONTAL_LINES("---"),
    STATION_ADDING_TEXT("## 등록할 역 이름을 입력하세요."),
    STATION_DELETION_TEXT("## 삭제할 역 이름을 입력하세요."),
    TRANSIT_MAP_TEXT("## 지하철 노선도");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
