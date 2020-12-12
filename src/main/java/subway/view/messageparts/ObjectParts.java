package subway.view.messageparts;

public enum ObjectParts {
    STATION_NAME("역 이름을 "),
    LINE_NAME("노선 이름을 "),
    UPSTREAM_TERMINUS("노선의 상행 종점역 이름을 "),
    DOWNSTREAM_TERMINUS("노선의 하행 종점역 이름을 ");

    private String messageParts;

    private ObjectParts(String messageParts) {
        this.messageParts = messageParts;
    }

    public String toString() {
        return messageParts;
    }
}
