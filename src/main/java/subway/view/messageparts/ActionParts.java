package subway.view.messageparts;

public enum ActionParts {
    TO_ADD("등록할 "),
    TO_DELETE("삭제할 ");

    private String messageParts;

    private ActionParts(String messageParts) {
        this.messageParts = messageParts;
    }

    public String toString() {
        return messageParts;
    }
}
