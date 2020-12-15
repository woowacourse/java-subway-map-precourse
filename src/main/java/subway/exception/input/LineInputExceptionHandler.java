package subway.exception.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.Controller.domain.LineController;

public class LineInputExceptionHandler extends InputExceptionHandler {

    private static final List<String> LINE_PATTERN = new ArrayList<>(
        Arrays.asList("1", "2", "3", "B"));

    public static void unselectable(String input) {
        if (contains(input, LINE_PATTERN)) {
            return;
        }
        unselectableError();
        LineController.select();
    }
}
