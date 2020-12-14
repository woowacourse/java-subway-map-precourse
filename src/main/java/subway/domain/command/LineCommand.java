package subway.domain.command;

import java.util.Arrays;

public enum LineCommand implements Command {
    LINE_REGISTRATION("1", "노선 등록"),
    LINE_DELETION("2", "노선 삭제"),
    PRINT_LINES("3", "노선 조회"),
    PREVIOUS_SCREEN("B", "돌아가기");

    private final String selector;
    private final String detail;

    LineCommand(String selector, String detail) {
        this.selector = selector;
        this.detail = detail;
    }

    public static LineCommand getCommand(String userMessage) {
        return Arrays.stream(values())
                .filter(command -> command.isMatched(userMessage))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CHOICE_ERROR_MESSAGE));
    }

    public boolean isLineRegistration() {
        return equals(LINE_REGISTRATION);
    }

    public boolean isLineDeletion() {
        return equals(LINE_DELETION);
    }

    public boolean isPrintLines() {
        return equals(PRINT_LINES);
    }

    @Override
    public boolean isMatched(String userMessage) {
        return selector.equals(userMessage);
    }

    @Override
    public String toString() {
        return selector + ". " + detail + "\n";
    }
}
