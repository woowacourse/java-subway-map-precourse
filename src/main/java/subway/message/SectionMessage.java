package subway.message;

public enum SectionMessage {

    SECTION_FUNCTION_LIST("## 구간 관리 화면\n"
        + "1. 구간 등록\n"
        + "2. 구간 삭제\n"
        + "B. 돌아가기"),
    ;


    private final String text;

    SectionMessage(String text) {
        this.text = text;
    }

    public String getSectionMessage() {
        return this.text;
    }

}
