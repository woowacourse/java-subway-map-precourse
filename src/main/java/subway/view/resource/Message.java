package subway.view.resource;

public enum Message {
    INPUT_FUNCTION_INDEX("원하는 기능을 선택하세요."),
    INPUT_REGISTER_STATION_NAME("등록할 역 이름을 입력하세요."),
    INPUT_REGISTER_LINE_NAME("등록할 노선 이름을 입력하세요."),
    INPUT_REGISTER_FIRST_STATION("등록할 노선의 상행 종점역 이름을 입력하세요."),
    INPUT_REGISTER_LAST_STATION("등록할 노선의 하행 종점역 이름을 입력하세요."),
    INPUT_DELETE_STATION_NAME("삭제할 역 이름을 입력하세요."),
    INPUT_DELETE_LINE_NAME("삭제할 노선 이름을 입력하세요."),
    INPUT_LINE_OF_DELETE_SECTION("삭제할 구간의 노선을 입력하세요."),
    INPUT_STATION_OF_DELETE_SECTION("삭제할 구간의 역을 입력하세요."),
    INPUT_LINE("노선을 입력하세요."),
    INPUT_INDEX("순서를 입력하세요."),
    REGISTER_STATION_SUCCESS("지하철 역이 등록되었습니다."),
    REGISTER_LINE_SUCCESS("지하철 노선이 등록되었습니다."),
    REGISTER_SECTION_SUCCESS("구간이 등록되었습니다."),
    DELETE_STATION_SUCCESS("지하철 역이 삭제되었습니다."),
    DELETE_LINE_SUCCESS("지하철 노선이 삭제되었습니다."),
    DELETE_SECTION_SUCCESS("지하철 구간이 삭제되었습니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
