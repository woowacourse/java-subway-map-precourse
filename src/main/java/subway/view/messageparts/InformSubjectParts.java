package subway.view.messageparts;

public enum InformSubjectParts {
    STATION_IS("지하철 역이 ");

    private String messageParts;

    private InformSubjectParts(String messageParts) {
        this.messageParts = messageParts;
    }

    public String toString() {
        return messageParts;
    }
}
