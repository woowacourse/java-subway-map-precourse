package subway.domain.constants;

import java.util.Arrays;
import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

public enum StationCommand {
    ADD("1"),
    DELETE("2"),
    GET("3"),
    BACK("B");

    private final String command;

    StationCommand(String command) {
        this.command = command;
    }

    public static StationCommand from(String command) {
        return Arrays.stream(StationCommand.values())
                .filter(element -> element.command.equals(command))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_FUNCTION_COMMAND));

    }
}
