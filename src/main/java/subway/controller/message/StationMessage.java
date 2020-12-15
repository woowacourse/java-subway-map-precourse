package subway.controller.message;

public enum StationMessage implements Message {
    SELECT_FUNCTION("원하는 기능을 선택하세요."),
    ENTER_STATION_NAME("등록할 역 이름을 입력하세요."),
    ENTER_STATION_NAME_TO_BE_DELETED("삭제할 역 이름을 입력하세요."),
    INFO_ADD_STATION("지하철 역이 등록되었습니다."),
    INFO_DELETE_STATION("지하철 역이 삭제되었습니다."),
    NOTICE_STATION_LIST("역 목록"),
    ERROR_SELECT_FUNCTION("선택할 수 없는 기능입니다."),
    ERROR_DUPLICATE_STATION_NAME("이미 등록된 역 이름입니다."),
    ERROR_INVALID_STATION_NAME_LENGTH("역 이름은 2글자 이상이어야 합니다."),
    ERROR_NOT_EXIST_STATION("존재하지 않는 역 이름입니다."),
    ERROR_STATION_ADDED_TO_LINE("노선에 등록된 역은 삭제할 수 없습니다.");

    private String content;

    StationMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
