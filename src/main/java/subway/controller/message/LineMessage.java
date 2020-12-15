package subway.controller.message;

public enum LineMessage implements Message {
    SELECT_FUNCTION("원하는 기능을 선택하세요."),
    ENTER_LINE_NAME("등록할 노선 이름을 입력하세요."),
    ENTER_UPWARD_STATION_NAME("등록할 노선의 상행 종점역 이름을 입력하세요."),
    ENTER_DOWNWARD_STATION_NAME("등록할 노선의 하행 종점역 이름을 입력하세요."),
    ENTER_LINE_NAME_TO_BE_DELETED("삭제할 노선 이름을 입력하세요."),
    INFO_ADD_LINE("지하철 노선이 등록되었습니다."),
    INFO_DELETE_LINE("지하철 노선이 삭제되었습니다."),
    NOTICE_LINE_LIST("노선 목록"),
    ERROR_SELECT_FUNCTION("선택할 수 없는 기능입니다."),
    ERROR_DUPLICATE_LINE_NAME("이미 등록된 노선 이름입니다."),
    ERROR_INVALID_LINE_NAME_LENGTH("노선 이름은 2글자 이상이어야 합니다."),
    ERROR_NOT_EXIST_LINE("존재하지 않는 노선 이름입니다.");

    private String content;

    LineMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
