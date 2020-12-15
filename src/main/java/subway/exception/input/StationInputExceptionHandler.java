package subway.exception.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.Controller.domain.StationController;

public class StationInputExceptionHandler extends InputExceptionHandler {

    private static final List<String> STATION_PATTERN = new ArrayList<>(
        Arrays.asList("1", "2", "3", "B"));

    public static void unselectable(String input) {
        if (contains(input, STATION_PATTERN)) {
            return;
        }
        unselectableError();
        StationController.select();
    }
}
