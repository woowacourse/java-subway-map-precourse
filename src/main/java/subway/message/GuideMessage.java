package subway.message;

public enum GuideMessage {
    MAIN_FUNCTION_LIST("## 메인 화면\n"
        + "1. 역 관리\n"
        + "2. 노선 관리\n"
        + "3. 구간 관리\n"
        + "4. 지하철 노선도 출력\n"
        + "Q. 종료"),
    CHOICE_FUNCTION_LIST("## 원하는 기능을 선택하세요."),
    ;

    private final String text;

    GuideMessage(String text) {
        this.text = text;
    }

    public String getGuideMessage() {
        return this.text;
    }
}
