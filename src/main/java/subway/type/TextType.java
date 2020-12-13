package subway.type;

public enum TextType {
    NEW_LINE("\n"),
    HORIZONTAL_LINES("---"),
    STATION_ADDING_TEXT("## 등록할 역 이름을 입력하세요."),
    STATION_DELETION_TEXT("## 삭제할 역 이름을 입력하세요."),
    STATION_NAME_TEXT("## 역 목록"),
    LINE_ADDING_TEXT("## 등록할 노선 이름을 입력하세요."),
    LINE_UP_STATION_NAME_TEXT("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    LINE_DOWN_STATION_NAME_TEXT("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    LINE_DELETION_TEXT("## 삭제할 노선 이름을 입력하세요."),
    LINE_NAME_TEXT("## 노선 목록"),
    SECTION_ADDING_LINE_TEXT("## 노선을 입력하세요."),
    SECTION_ADDING_STATION_TEXT("## 역이름을 입력하세요."),
    SECTION_ADDING_ORDER_TEXT("## 순서를 입력하세요."),
    SECTION_DELETION_LINE_TEXT("## 삭제할 구간의 노선을 입력하세요."),
    SECTION_DELETION_STATION_TEXT("## 삭제할 구간의 역을 입력하세요."),
    TRANSIT_MAP_TEXT("## 지하철 노선도");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
