package subway.domain.command;

import java.util.Arrays;

public interface Command {
    public static final String CHOICE_ERROR_MESSAGE = "선택할 수 없는 기능입니다.";

    public static Command getCommand(Command[] commands, String userMessage) {
        return Arrays.stream(commands)
                .filter(command -> command.isMatched(userMessage))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CHOICE_ERROR_MESSAGE));
    }

    public boolean isMatched(String userMessage);
}
