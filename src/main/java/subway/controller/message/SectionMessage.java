package subway.controller.message;

public enum SectionMessage implements Message {
    SELECT_FUNCTION("원하는 기능을 선택하세요."),
    ENTER_LINE_NAME("노선 이름을 입력하세요."),
    ENTER_STATION_NAME("역 이름을 입력하세요."),
    ENTER_ORDER("순서를 입력하세요."),
    ENTER_LINE_NAME_TO_BE_DELETED("삭제할 구간의 노선을 입력하세요."),
    ENTER_STATION_NAME_TO_BE_DELETED("삭제할 구간의 역을 입력하세요."),
    NOTICE_SECTION_LIST("지하철 노선도"),
    INFO_ADD_SECTION("구간이 등록되었습니다."),
    INFO_DELETE_SECTION("구간이 삭제되었습니다."),
    ERROR_SELECT_FUNCTION("선택할 수 없는 기능입니다."),
    ERROR_INVALID_ORDER("잘못된 순서입니다.");

    private String content;

    SectionMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
