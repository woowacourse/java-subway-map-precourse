package subway.domain.constants;

import java.util.Arrays;
import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

public enum FunctionCommand {
    STATION("1"),
    LINE("2"),
    ROUTE("3"),
    PRINT("4"),
    QUIT("Q");

    private final String command;

    FunctionCommand(String command) {
        this.command = command;
    }

    public static FunctionCommand from(String command) {
        return Arrays.stream(FunctionCommand.values())
                .filter(element -> element.command.equals(command))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_FUNCTION_COMMAND));
    }

}
