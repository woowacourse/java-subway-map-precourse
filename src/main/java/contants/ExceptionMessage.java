package contants;

public enum ExceptionMessage {
    STATION_DUPLICATION("이미 존재하는 역입니다."),
    STATION_NOT_EXISTS("존재하지 않는 역입니다."),
    LINE_DOES_NOT_EXIST("존재하지 않는 노선입니다."),
    LINE_DOES_NOT_EXIST_IN_SECTION("구간에 해당 노선이 존재하지 않습니다."),
    STATION_DOES_NOT_EXIST_IN_SECTION("구간에 해당 지하철 역이 존재하지 않습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] "+ this.message;
    }
}
