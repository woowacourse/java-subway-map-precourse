package subway.exception;

import java.util.regex.Pattern;
import subway.Scene;
import subway.domain.Line;
import subway.domain.Station;

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

    protected static boolean isValidStationName(String name) {
        return Station.isValidName(name);
    }

    protected static boolean isValidLineName(String name) {
        return Line.isValidName(name);
    }
}
