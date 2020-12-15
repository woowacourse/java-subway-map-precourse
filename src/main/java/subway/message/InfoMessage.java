package subway.message;

public enum InfoMessage {

    STATION_ADDED("지하철 역이 등록되었습니다."),
    STATION_REMOVED("지하철 역이 삭제되었습니다."),

    LINE_ADDED("지하철 노선이 등록되었습니다."),
    LINE_REMOVED("지하철 노선이 삭제되었습니다."),

    SECTION_ADDED("구간이 등록되었습니다."),
    SECTION_REMOVED("구간이 삭제되었습니다."),
    ;

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
