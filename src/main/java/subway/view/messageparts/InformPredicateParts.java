package subway.view.messageparts;

public enum InformPredicateParts {
    ADDED("등록되었습니다."),
    DELETED("삭제되었습니다.");

    private String messageParts;

    private InformPredicateParts(String messageParts) {
        this.messageParts = messageParts;
    }

    public String toString() {
        return messageParts;
    }
}
