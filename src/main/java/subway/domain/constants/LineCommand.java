package subway.domain.constants;

import java.util.Arrays;
import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

public enum LineCommand {
    ADD("1"),
    DELETE("2"),
    GET("3"),
    BACK("B");

    private final String command;

    LineCommand(String command) {
        this.command = command;
    }

    public static LineCommand from(String command) {
        return Arrays.stream(LineCommand.values())
                .filter(element -> element.command.equals(command))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_FUNCTION_COMMAND));

    }
}
