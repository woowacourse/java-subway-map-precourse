package subway.domain.command;

import java.util.Arrays;

public enum SectionCommand implements Command {
    SECTION_REGISTRATION("1", "구간 등록"),
    SECTION_DELETION("2", "구간 삭제"),
    PREVIOUS_SCREEN("B", "돌아가기");

    private final String selector;
    private final String detail;

    SectionCommand(String selector, String detail) {
        this.selector = selector;
        this.detail = detail;
    }

    public static SectionCommand getCommand(String userMessage) {
        return Arrays.stream(values())
                .filter(command -> command.isMatched(userMessage))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CHOICE_ERROR_MESSAGE));
    }

    public boolean isSectionRegistration() {
        return equals(SECTION_REGISTRATION);
    }

    public boolean isSectionDeletion() {
        return equals(SECTION_DELETION);
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
