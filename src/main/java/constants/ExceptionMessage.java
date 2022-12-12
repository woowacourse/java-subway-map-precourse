package constants;

public enum ExceptionMessage {
    STATION_DUPLICATION("이미 존재하는 역입니다."),
    STATION_NOT_EXISTS("존재하지 않는 역입니다."),
    LINE_DOES_NOT_EXIST("존재하지 않는 노선입니다."),
    LINE_DOES_NOT_EXIST_IN_SECTION("구간에 해당 노선이 존재하지 않습니다."),
    STATION_DOES_NOT_EXIST_IN_SECTION("구간에 해당 지하철 역이 존재하지 않습니다."),
    SECTION_HAS_LESS_THAN_TWO_STATIONS("구간에는 2개 이상의 역이 존재해야 합니다."),
    STATION_NAME_LENGTH_ERROR("역의 이름은 두 글자 이상이어야 합니다."),
    ALREADY_REGISTERED_TO_SECTION("노선으로 등록된 역은 삭제할 수 없습니다."),
    WRONG_SELECTION("해당하는 메뉴가 없습니다."),
    LINE_EXIST("이미 존재하는 노선입니다");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] "+ this.message;
    }
}
