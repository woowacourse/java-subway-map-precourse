package subway.view.messageparts;

public enum ObjectParts {
    STATION_NAME("역 이름을 "),
    LINE_NAME("노선 이름을 "),
    UPSTREAM_TERMINUS("노선의 상행 종점역 이름을 "),
    DOWNSTREAM_TERMINUS("노선의 하행 종점역 이름을 "),
    LINE_FOR_ADD_SECTION("노선을 "),
    STATION_FOR_ADD_SECTION("역이름을 "),
    SECTION_ORDER("순서를 "),
    LINE_FOR_DELETE_SECTION("구간의 노선을 "),
    STATION_FOR_DELETE_SECTION("구간의 역을 ");

    private String messageParts;

    private ObjectParts(String messageParts) {
        this.messageParts = messageParts;
    }

    public String toString() {
        return messageParts;
    }
}
