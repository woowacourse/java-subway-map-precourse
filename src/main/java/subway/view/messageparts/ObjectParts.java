package subway.view.messageparts;

public enum ObjectParts {
    STATION_NAME("역 이름을 ");

    private String messageParts;

    private ObjectParts(String messageParts) {
        this.messageParts = messageParts;
    }

    public String toString() {
        return messageParts;
    }
}
