package subway.type;

public enum TextType {
    STATION_ADDING_TEXT("## 등록할 역 이름을 입력하세요.");

    private final String text;

    TextType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
