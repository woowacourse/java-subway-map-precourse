package subway.message;

public enum CommonMessage {
    MAIN_FUNCTION_LIST("## 메인 화면\n"
        + "1. 역 관리\n"
        + "2. 노선 관리\n"
        + "3. 구간 관리\n"
        + "4. 지하철 노선도 출력\n"
        + "Q. 종료"),
    CHOICE_OPTION_LIST("## 원하는 기능을 선택하세요."),
    STATION_MAP_GUIDE("## 지하철 노선도"),
    LINE("---"),

    INFO("[INFO] "),

    NOT_SELECTABLE_ERROR("[ERROR] 선택할 수 없는 기능입니다."),

    ;



    private final String text;

    CommonMessage(String text) {
        this.text = text;
    }

    public String getCommonMessage() {
        return this.text;
    }
}
