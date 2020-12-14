package subway.exception;

import java.util.regex.Pattern;
import subway.Scene;

public class ExceptionManager {

    public static Error checkValidCommand(Scene scene, String command) {
        if (scene.hasCommand(command)) {
            return Error.OK;
        }
        return Error.INVALID_COMMAND;
    }

    protected static boolean isNumber(String input) {
        String numberPattern = "[+-]?[0-9]+";
        return Pattern.matches(numberPattern, input);
    }

    protected static boolean isValidStationNameLength(String name) {
        return name.length() >= Error.MINIMUM_STATION_NAME_LENGTH;
    }

    protected static boolean isValidLineNameLength(String name) {
        return name.length() >= Error.MINIMUM_LINE_NAME_LENGTH;
    }
}
