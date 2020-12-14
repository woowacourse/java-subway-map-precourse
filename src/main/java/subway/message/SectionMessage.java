package subway.message;

public enum SectionMessage {

    SECTION_FUNCTION_LIST("## 구간 관리 화면\n"
        + "1. 구간 등록\n"
        + "2. 구간 삭제\n"
        + "B. 돌아가기"),

    SECTION_GUIDE_TO_LINE("## 노선을 입력하세요."),
    SECTION_GUIDE_TO_STATION("## 역이름을 입력하세요."),
    SECTION_GUIDE_TO_INDEX("## 순서를 입력하세요."),

    SECTION_NOT_FOUND_LINE_NAME_ERROR("[ERROR] 노선을 찾을 수 없습니다."),
    SECTION_NOT_FOUND_STATION_NAME_ERROR("[ERROR] 역 이름을 찾을 수 없습니다."),
    ;

    private final String text;

    SectionMessage(String text) {
        this.text = text;
    }

    public String getSectionMessage() {
        return this.text;
    }

}
