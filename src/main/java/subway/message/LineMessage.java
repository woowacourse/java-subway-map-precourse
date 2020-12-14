package subway.message;

public enum LineMessage {
    LINE_FUNCTION_LIST("## 노선 관리 화면\n"
        + "1. 노선 등록\n"
        + "2. 노선 삭제\n"
        + "3. 노선 조회\n"
        + "B. 돌아가기"),

    LINE_ADD_SUCCESS("[INFO] 지하철 노선이 등록되었습니다."),
    ;


    private final String text;

    LineMessage(String text) {
        this.text = text;
    }

    public String getLineMessage() {
        return this.text;
    }

}
