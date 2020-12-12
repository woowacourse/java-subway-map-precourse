package subway.view.messageparts;

public enum InformSubjectParts {
    STATION_IS("지하철 역이 "),
    LINE_IS("지하철 노선이 "),
    SECTION_IS("구간이 ");

    private String messageParts;

    private InformSubjectParts(String messageParts) {
        this.messageParts = messageParts;
    }

    public String toString() {
        return messageParts;
    }
}
