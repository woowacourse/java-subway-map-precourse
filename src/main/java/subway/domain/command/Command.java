package subway.domain.command;

public interface Command {
    public static final String CHOICE_ERROR_MESSAGE = "선택할 수 없는 기능입니다.";

    public boolean isMatched(String userMessage);
}
