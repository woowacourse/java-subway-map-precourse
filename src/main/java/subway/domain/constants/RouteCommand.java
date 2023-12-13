package subway.domain.constants;

import java.util.Arrays;
import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

public enum RouteCommand {
    ADD("1"),
    DELETE("2"),
    BACK("B");

    private final String command;

    RouteCommand(String command) {
        this.command = command;
    }

    public static RouteCommand from(String command) {
        return Arrays.stream(RouteCommand.values())
                .filter(element -> element.command.equals(command))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_FUNCTION_COMMAND));

    }
}
