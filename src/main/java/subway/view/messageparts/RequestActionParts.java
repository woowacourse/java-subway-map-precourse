package subway.view.messageparts;

public enum RequestActionParts {
    TO_ADD("등록할 "),
    TO_DELETE("삭제할 ");

    private String messageParts;

    private RequestActionParts(String messageParts) {
        this.messageParts = messageParts;
    }

    public String toString() {
        return messageParts;
    }
}
